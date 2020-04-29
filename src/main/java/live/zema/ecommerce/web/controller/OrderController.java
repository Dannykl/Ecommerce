package live.zema.ecommerce.web.controller;

import live.zema.ecommerce.service.ItemService;
import live.zema.ecommerce.service.OrderService;
import live.zema.ecommerce.web.model.LineItemDto;
import live.zema.ecommerce.web.model.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danielniguse
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
@RestController
public class OrderController {
    final OrderService orderService;
    final ItemService itemService;

    @PostMapping
    ResponseEntity<?> placeOrder(@RequestBody OrderDto orderDto) {
        List<LineItemDto> listOfILineItems = new ArrayList<>();

        for (LineItemDto lineItem : orderDto.getLineItemsDto()) {
            //check if the item exists
            var item = itemService.getItem(lineItem.getItemDto().getId());
            if (item.isEmpty()) {
                return ResponseEntity.badRequest().body("invalid item Id: " + lineItem.getItemDto().getId());
            }
            //lineItem
            listOfILineItems.add(new LineItemDto(lineItem.getId(), lineItem.getQuantity(), lineItem.getOrderDto(), item.get()));

        }
        try {
            var order = orderService.placeOrder(new OrderDto(orderDto.getId(), orderDto.getCreatedDate(), listOfILineItems));
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to place order " + e.getMessage());
        }
    }

}
