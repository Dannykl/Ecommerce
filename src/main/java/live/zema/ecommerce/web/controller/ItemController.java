package live.zema.ecommerce.web.controller;

import live.zema.ecommerce.model.ItemDto;
import live.zema.ecommerce.service.ItemService2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author danielniguse
 */
@RequestMapping("/api/v1/item")
@RestController
public class ItemController {
    final ItemService2 itemService2;

    public ItemController(ItemService2 itemService2) {
        this.itemService2 = itemService2;
    }

    @GetMapping({"/{id}"})
    ResponseEntity<ItemDto> getItem(@PathVariable long id) {
        return itemService2.getItem(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping()
    ResponseEntity<List<ItemDto>> getItems() {
        List<ItemDto> allItems = itemService2.getAllItems();
        return !allItems.isEmpty() ? ResponseEntity.ok(allItems)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //TODO (ADMIN)
    // CREATE the product

    //TODO (ADMIN)
    // UPDATE the product

    //TODO (ADMIN)
    // DELETE the product
}
