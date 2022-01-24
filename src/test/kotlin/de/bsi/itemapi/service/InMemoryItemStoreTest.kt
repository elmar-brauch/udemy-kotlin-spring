package de.bsi.itemapi.service

import de.bsi.itemapi.model.Item
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito

const val DEFAULT_ID = "123"

internal class InMemoryItemStoreTest {

    private lateinit var itemStore : InMemoryItemStore
    private val idGeneratorMock = Mockito.mock(IdGenerator::class.java)
    private val firstItem = Item("Schuh", "333")

    @BeforeEach
    fun setUp() {
        Mockito.`when`(idGeneratorMock.generateId()).thenReturn(DEFAULT_ID)
        itemStore = InMemoryItemStore(idGeneratorMock)
        itemStore.items.add(firstItem)
    }

    @Test
    fun saveItemWithIdNull() {
        assertEquals(DEFAULT_ID, saveItemWithId(null))
        assertEquals(2, itemStore.items.size)
    }

    @Test
    fun saveItemWithNewId() {
        assertEquals("567", saveItemWithId("567"))
        assertEquals(2, itemStore.items.size)
    }

    @Test
    fun saveItemWithExistingId() {
        assertEquals(firstItem.id, saveItemWithId(firstItem.id))
        assertEquals(1, itemStore.items.size)
    }

    fun saveItemWithId(id: String?) : String {
        val item = Item("Ball", id)
        return itemStore.saveItem(item)
    }

}