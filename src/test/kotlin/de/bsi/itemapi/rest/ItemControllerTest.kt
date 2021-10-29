package de.bsi.itemapi.rest

import de.bsi.itemapi.model.Item
import de.bsi.itemapi.service.InMemoryItemStore
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.reactive.function.client.WebClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class ItemControllerTest(@Autowired private val store: InMemoryItemStore) {

    private val client = WebClient.create("http://localhost:8080/item")

    init {
        store.items.clear()
        store.items.add(Item("Kotlin", "1.5"))
        store.items.add(Item("Spring", "5"))
        assertEquals(2, store.items.size)
    }

    @Test
    @Order(1)
    fun getRequest() {
        val item = client.get().uri("?id=1.5").retrieve().bodyToMono(Item::class.java).block()
        assertEquals("Kotlin", item!!.name)
    }

    @Test
    @Order(2)
    fun deleteRequest() {
        client.delete().uri("/5").retrieve().toBodilessEntity().block()
        assertEquals(1, store.items.size)
    }

    @Test
    @Order(3)
    fun postRequest() {
        client.post().bodyValue(Item("Java", "11")).retrieve().bodyToMono(Item::class.java).block()
        assertEquals(3, store.items.size)
    }
}