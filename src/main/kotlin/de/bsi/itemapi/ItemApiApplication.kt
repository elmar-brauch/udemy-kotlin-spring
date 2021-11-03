package de.bsi.itemapi

import de.bsi.itemapi.service.ItemService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["de.bsi"])
class ItemApiApplication

fun main(args: Array<String>) {
	val context = runApplication<ItemApiApplication>(*args)
	val bean : ItemService? = context.getBean("itemService_2") as? ItemService
	val item = bean?.createAndPersistItem("Stern")
	println("Item created: $item")
	//context.stop()
}
