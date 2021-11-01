package de.bsi.itemapi

import de.bsi.itemapi.model.Item
import de.bsi.itemapi.service.ItemPersistenceService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ItemApiApplication

fun main(args: Array<String>) {
	val context = runApplication<ItemApiApplication>(*args)
	val bean = context.getBean(ItemPersistenceService::class.java)
	val id = bean.saveItem(Item("Ball", null))
	println("Item created and found: " + bean.findItem(id))
	// context.stop()
}
