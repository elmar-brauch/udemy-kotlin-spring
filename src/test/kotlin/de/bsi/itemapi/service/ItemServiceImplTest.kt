package de.bsi.itemapi.service

import de.bsi.itemapi.BeanConfig
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [BeanConfig::class])
internal class ItemServiceImplTest {

    @Autowired lateinit var service: ItemService

    @Test
    fun createAndPersistItem() {
        val item = service.createAndPersistItem("Ball")
        assertEquals("Ball", item.name)
    }
}