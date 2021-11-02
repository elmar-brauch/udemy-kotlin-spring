package de.bsi.itemapi.rest

import de.bsi.itemapi.model.Item
import de.bsi.itemapi.service.ItemService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/item")
class ItemController(private val service: ItemService) {

    @GetMapping
    fun getItemBy(@RequestParam id: String): ResponseEntity<Item> {
        val item = service.findItemById(id)
        if (item != null)
            return ResponseEntity.ok(item)
        return ResponseEntity.notFound().build()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addItem(@RequestBody item: Item) = service.createAndPersistItem(item.name)

    @DeleteMapping("/{itemId}")
    fun deleteItemBy(@PathVariable itemId: String): ResponseEntity<Unit> {
        val item = service.findItemById(itemId) ?: return ResponseEntity.notFound().build()
        service.removeItem(item)
        return ResponseEntity.noContent().build()
    }
}