package live.zema.ecommerce.web.controller;

import live.zema.ecommerce.service.ItemService;
import live.zema.ecommerce.service.OrderService;
import live.zema.ecommerce.service.UserService;
import live.zema.ecommerce.web.model.LineItemDto;
import live.zema.ecommerce.web.model.OrderDto;
import live.zema.ecommerce.web.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author danielniguse
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
@RestController
public class OrderController {
    final OrderService orderService;
    final ItemService itemService;
    final UserService userService;

    //    @RequestMapping(value = "/{authorId}/book",
    @PostMapping
    ResponseEntity<?> placeOrder(@RequestBody OrderDto orderDto) {
        List<LineItemDto> listOfILineItems = new ArrayList<>();

        Optional<UserDto> userDto = userService.findByEmail(orderDto.getUserDto().getEmail());
        if (userDto.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(orderDto.getUserDto().getEmail() + " doesnt exist");
        } else {

            for (LineItemDto lineItem : orderDto.getLineItemsDto()) {
                //check if the item exists
                var item = itemService.getItem(lineItem.getItemDto().getId());
                if (item.isEmpty()) {
                    return ResponseEntity.badRequest().body("invalid item Id: " + lineItem.getItemDto().getId());
                }
                //lineItem
                listOfILineItems.add(new LineItemDto(lineItem.getId(), lineItem.getQuantity(), lineItem.getOrderDto(), item.get()));

            }
        }
        try {
            var order = orderService.placeOrder(new OrderDto(orderDto.getId(), orderDto.getCreatedDate(), listOfILineItems, orderDto.getUserDto()));
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to place order " + e.getMessage());
        }
    }

    //TODO RETURN NESTED DATA - EACH NESTED DATA IS IDENTICAL
    @GetMapping
    ResponseEntity finaAllOrders() {
        return new ResponseEntity(orderService.findAllOrder(), HttpStatus.OK);
    }

    //TODO should be secured
    //list all orders for specific user
    @GetMapping({"/{email}"})
    ResponseEntity getAllOrdersByUserEmail(@PathVariable String email) {
        return new ResponseEntity(orderService.findCustomerOrder(email), HttpStatus.OK);
    }

}
