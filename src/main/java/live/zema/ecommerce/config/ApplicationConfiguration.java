package live.zema.ecommerce.config;

import live.zema.ecommerce.repository.ItemRepository;
import live.zema.ecommerce.service.ItemService2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public ItemService2 itemService2(ItemRepository itemRepository){
        return new ItemService2(itemRepository);
    }
}
