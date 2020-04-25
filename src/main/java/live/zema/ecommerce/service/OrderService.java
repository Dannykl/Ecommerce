package live.zema.ecommerce.service;

import live.zema.ecommerce.web.model.OrderDto;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

/**
 * @author danielniguse
 */
public interface OrderService {
    OrderDto placeOrder(OrderDto orderDta);
}
