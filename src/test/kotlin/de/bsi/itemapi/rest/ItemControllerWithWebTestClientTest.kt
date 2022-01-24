package de.bsi.itemapi.rest

import de.bsi.itemapi.model.Item
import de.bsi.itemapi.service.InMemoryItemStore
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
internal class ItemControllerWithWebTestClientTest(
    @Autowired val store: InMemoryItemStore) {

    private val client = WebTestClient.bindToServer()
        .baseUrl("http://localhost:8080/item").build()

    @BeforeEach
    fun setup() {
        store.items.clear()
        store.items.add(Item("Kotlin", "1.5"))
        store.items.add(Item("Spring", "5"))
        assertEquals(2, store.items.size)
    }

    @Test
    fun getRequest() {
        client.get().uri("?id=1.5").exchange()
            .expectStatus().is2xxSuccessful
            .expectBody()
            .jsonPath("$.name").isEqualTo("Kotlin")
    }

    @Test
    fun deleteRequest() {
        client.delete().uri("/5").exchange()
            .expectStatus().isNoContent
        assertEquals(1, store.items.size)
    }

    @Test
    fun postRequest() {
        client.post().bodyValue(Item("Java", "11")).exchange()
            .expectStatus().isCreated
        assertEquals(3, store.items.size)
    }

    @Test
    fun getBadRequest() {
        client.get().uri("?id=5").exchange()
            .expectStatus().isBadRequest

    }

}