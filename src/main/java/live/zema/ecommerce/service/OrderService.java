package live.zema.ecommerce.service;

import live.zema.ecommerce.web.model.OrderDto;

import java.util.List;
import java.util.Set;

/**
 * @author danielniguse
 */
public interface OrderService {
    OrderDto placeOrder(OrderDto orderDta);

    Set<OrderDto> findAllOrder();

    List<OrderDto> findCustomerOrder(String email);


}
