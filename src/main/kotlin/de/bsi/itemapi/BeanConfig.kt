package de.bsi.itemapi

import de.bsi.itemapi.service.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfig {

    @Bean("itemService_2")
    fun itemService() : ItemService {
        val bean = ItemServiceImpl()
        bean.service = itemPersistenceService()
        return bean
    }

    @Bean("itemStore_2", initMethod = "cleanStore", destroyMethod = "cleanStore")
    fun itemPersistenceService() = InMemoryItemStore(idGenerator())

    @Bean(name = ["idGenerator_2"])
    fun idGenerator() = IdGenerator()

}