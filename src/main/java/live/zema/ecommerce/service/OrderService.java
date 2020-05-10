package live.zema.ecommerce.service;

import live.zema.ecommerce.web.model.OrderDto;

/**
 * @author danielniguse
 */
public interface OrderService {
    OrderDto placeOrder(OrderDto orderDta);


}
