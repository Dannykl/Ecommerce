package live.zema.ecommerce.service;

import live.zema.ecommerce.domain.Order;
import live.zema.ecommerce.repository.OrderRepository;
import live.zema.ecommerce.web.mapper.DateMapper;
import live.zema.ecommerce.web.mapper.OrderMapper;
import live.zema.ecommerce.web.model.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author danielniguse
 */

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final DateMapper dateMapper;

    @Override
    public OrderDto placeOrder(OrderDto orderDta) {

        Order r = new Order(orderDta.getId(),
                dateMapper.asTimestamp(orderDta.getCreatedDate()), orderDta.getLineItemsDto());
        System.out.println(r);
//        return orderMapper.orderToOrderDto(orderRepository.save(r));
        return orderMapper.orderToOrderDto(orderRepository.save(r));
    }
}
