package live.zema.ecommerce.web.controller;

import live.zema.ecommerce.domain.Order;
import live.zema.ecommerce.service.OrderService;
import live.zema.ecommerce.web.model.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author danielniguse
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
@RestController
public class OrderController {
    final OrderService orderService;

    @PostMapping
    ResponseEntity placeOrder(@RequestBody OrderDto orderDto){
        return new ResponseEntity(orderService.placeOrder(orderDto), HttpStatus.CREATED);
    }
}
