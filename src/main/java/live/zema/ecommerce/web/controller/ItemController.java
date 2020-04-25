package live.zema.ecommerce.web.controller;

import live.zema.ecommerce.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author danielniguse
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/item")
@RestController
public class ItemController {

    final ItemService itemService;

    @GetMapping()
    ResponseEntity getItems(){
        return new ResponseEntity(itemService.getAllItems(), HttpStatus.OK);
    }
}
