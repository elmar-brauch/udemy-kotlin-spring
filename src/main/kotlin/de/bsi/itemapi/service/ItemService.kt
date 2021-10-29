package de.bsi.itemapi.service

import de.bsi.itemapi.model.Item

interface ItemService {

    /**
     * Creates a new Item with given name and random id.
     */
    fun createAndPersistItem(name: String): Item

    /**
     * Searches for item by id in  persistence layer.
     */
    fun findItemById(id: String): Item?

    /**
     * Removes given item in persistence layer.
     */
    fun removeItem(item: Item)

}