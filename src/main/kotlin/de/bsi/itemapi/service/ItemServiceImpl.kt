package de.bsi.itemapi.service

import de.bsi.itemapi.model.Item
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ItemServiceImpl : ItemService {

    @Autowired lateinit var service : ItemPersistenceService

    override fun createAndPersistItem(name: String): Item {
        val newItem = Item(name, null)
        service.saveItem(newItem)
        return newItem
    }

    override fun findItemById(id: String) = service.findItem(id)

    override fun removeItem(item: Item) {
        if (item.id != null)
            service.deleteItem(item.id!!)
    }
}