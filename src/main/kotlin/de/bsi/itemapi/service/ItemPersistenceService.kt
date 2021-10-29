package de.bsi.itemapi.service

import de.bsi.itemapi.model.Item

interface ItemPersistenceService {

    /**
     * Deletes Item identified by id.
     *
     * @param itemId of Item to be deleted
     * @throws NoSuchElementException
     */
    fun deleteItem(itemId: String)

    /**
     * Searches for Item by id.
     *
     * @param itemId search criteria
     * @return found Item or null
     */
    fun findItem(itemId: String): Item?

    /**
     * Overwrites existing item
     * or stores new item the first time and generates a random item id, if not present.
     *
     * @param item existing or new instance.
     * @return Item's id.
     */
    fun saveItem(item: Item): String

}