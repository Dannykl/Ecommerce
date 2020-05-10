package live.zema.ecommerce.service;

import live.zema.ecommerce.web.model.OrderDto;

import java.util.Set;

/**
 * @author danielniguse
 */
public interface OrderService {
    OrderDto placeOrder(OrderDto orderDta);

    Set<OrderDto> findAllOrder();

//    Set<Order> findByUser(String userDto);

}
