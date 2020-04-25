package live.zema.ecommerce.bootstrap;

import live.zema.ecommerce.domain.Item;
import live.zema.ecommerce.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author danielniguse
 */

@RequiredArgsConstructor
@Component
public class ItemLoader implements CommandLineRunner {

    private final ItemRepository itemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBrandObjects();
    }

    private void loadBrandObjects() {
        if (itemRepository.count() == 0) {
            itemRepository.save(Item.builder()
                    .name("Laptop")
                    .description("Dell")
                    .price(new BigDecimal("429.99"))
                    .build());
            itemRepository.save(Item.builder()
                    .name("Phone")
                    .description("Nokia")
                    .price(new BigDecimal("199.99"))
                    .build());
            itemRepository.save(Item.builder()
                    .name("watch")
                    .description("Casio")
                    .price(new BigDecimal("29.99"))
                    .build());


        }
    }
}
