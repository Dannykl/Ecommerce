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
                    .name("Face mask")
                    .description("Eagle")
                    .price(new BigDecimal("18.99"))
                    .image("https://firebasestorage.googleapis.com/v0/b/decom-599ca.appspot.com/o/0681814c978e23e335eeef9a4fa202e5.jpeg?alt=media&token=7e0b96a1-eaf7-42b9-96c4-8b5e1b45cf7b")
                    .build());
            itemRepository.save(Item.builder()
                    .name("Face mask")
                    .description("Genuine Leather")
                    .price(new BigDecimal("19.99"))
                    .image("https://firebasestorage.googleapis.com/v0/b/decom-599ca.appspot.com/o/11700f56bb178fe38607b417d60f2085.jpg?alt=media&token=cdb46657-76f8-4222-8c3c-2c2c16f5e491")
                    .build());
            itemRepository.save(Item.builder()
                    .name("Face mask")
                    .description("Leopard")
                    .price(new BigDecimal("20.99"))
                    .image("https://firebasestorage.googleapis.com/v0/b/decom-599ca.appspot.com/o/953f9ef00fd02a60e82204dcb61e0544.jpeg?alt=media&token=a913cd5a-af7c-4884-847e-cb9259743c04")
                    .build());
        }
    }
}
