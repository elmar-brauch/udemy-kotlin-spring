package de.bsi.itemapi.service

import de.bsi.itemapi.model.Item
import org.springframework.stereotype.Service

@Service
class InMemoryItemStore(private val idGenerator: IdGenerator) : ItemPersistenceService {

    internal val items = mutableListOf<Item>()

    override fun deleteItem(itemId: String) {
        if (!items.removeIf { itemId == it.id })
            throw NoSuchElementException("No item found with id %s".format(itemId))
    }

    override fun findItem(itemId: String) = items.firstOrNull { itemId == it.id }

    override fun saveItem(item: Item): String {
        if (item.id == null)
            item.id = idGenerator.generateId()
        if (items.stream().anyMatch { item.id == it.id })
            deleteItem(item.id!!)
        items.add(item)
        return item.id!!
    }
}