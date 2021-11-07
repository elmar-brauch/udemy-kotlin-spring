package de.bsi.itemapi.rest

import de.bsi.itemapi.model.Item
import de.bsi.itemapi.service.InMemoryItemStore
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException
import org.springframework.web.reactive.function.client.toEntity

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
internal class ItemControllerTest(@Autowired private val store: InMemoryItemStore) {

    private val client = WebClient.create("http://localhost:8080/item")

    @BeforeEach
    fun setup() {
        store.items.clear()
        store.items.add(Item("Kotlin", "1.5"))
        store.items.add(Item("Spring", "5"))
        assertEquals(2, store.items.size)
    }

    @Test
    fun getRequest() {
        val item = client.get().uri("?id=1.5").retrieve().bodyToMono(Item::class.java).block()
        assertEquals("Kotlin", item!!.name)
    }

    @Test
    fun deleteRequest() {
        client.delete().uri("/5").retrieve().toBodilessEntity().block()
        assertEquals(1, store.items.size)
    }

    @Test
    fun postRequest() {
        client.post().bodyValue(Item("Java", "11")).retrieve().bodyToMono(Item::class.java).block()
        assertEquals(3, store.items.size)
    }

    @Test
    fun getBadRequest() {
        try {
            client.get().uri("?id=5").retrieve().toEntity<Any>().block()
            fail("Bad Request Exception was expected.")
        } catch (ex: WebClientResponseException) {
            assertEquals(HttpStatus.BAD_REQUEST, ex.statusCode)
        }
    }

    @Test
    fun postBadRequest() {
        try {
            client.post().bodyValue(Item("Java17", "17")).retrieve().toEntity<Any>().block()
            fail("Bad Request Exception was expected.")
        } catch (ex: WebClientResponseException) {
            assertEquals(HttpStatus.BAD_REQUEST, ex.statusCode)
        }
    }
}