package live.zema.ecommerce.web.controller;

import live.zema.ecommerce.service.ItemService;
import live.zema.ecommerce.service.OrderService;
import live.zema.ecommerce.service.UserService;
import live.zema.ecommerce.model.LineItemDto;
import live.zema.ecommerce.model.OrderDto;
import live.zema.ecommerce.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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
    final UserService userService;

    @PostMapping
    ResponseEntity<?> placeOrder(@RequestBody OrderDto orderDto) {
        List<LineItemDto> listOfILineItems = new ArrayList<>();

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();

        for (LineItemDto lineItem : orderDto.getLineItemsDto()) {
            //check if the item exists
            var item = itemService.getItem(lineItem.getItemDto().getId());
            if (item.isEmpty()) {
                return ResponseEntity.badRequest().body("invalid item Id: " + lineItem.getItemDto().getId());
            }
            //lineItem
            listOfILineItems.add(new LineItemDto(lineItem.getId(), lineItem.getQuantity(), lineItem.getOrderDto(), item.get()));
        }

        UserDto currentUserDto = new UserDto(currentUser, null, null, null, null);

        try {
            var order = orderService.placeOrder(new OrderDto(orderDto.getId(), orderDto.getCreatedDate(), listOfILineItems, currentUserDto));
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to place order " + e.getMessage());
        }
    }

    //TODO THIS SHOULD ONLY BE USED BY ADMIN
    @GetMapping
    ResponseEntity finaAllOrders() {
        return new ResponseEntity(orderService.findAllOrder(), HttpStatus.OK);
    }

    //TODO email should be checked before proceed
    @GetMapping({"/{email}"})
    ResponseEntity getAllOrdersByUserEmail(@PathVariable String email) {
        return new ResponseEntity(orderService.findCustomerOrder(email), HttpStatus.OK);
    }

}
