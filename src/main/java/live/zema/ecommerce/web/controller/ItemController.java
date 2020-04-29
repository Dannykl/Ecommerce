package live.zema.ecommerce.web.controller;

import live.zema.ecommerce.service.ItemService;
import live.zema.ecommerce.web.model.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

/**
 * @author danielniguse
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/item")
@RestController
public class ItemController {

    final ItemService itemService;

    @GetMapping({"/{id}"})
    ResponseEntity<?> getItem(@PathVariable UUID id) {
        Optional<ItemDto> item = itemService.getItem(id);

        if (item.isEmpty()) {
            return ResponseEntity.badRequest().body("invalid item Id: " + id);
        }
        return new ResponseEntity(itemService.getItem(id), HttpStatus.OK);
    }

    @GetMapping()
    ResponseEntity getItems() {
        return new ResponseEntity(itemService.getAllItems(), HttpStatus.OK);
    }
}
