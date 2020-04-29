package live.zema.ecommerce.service;

import live.zema.ecommerce.domain.Item;
import live.zema.ecommerce.domain.LineItem;
import live.zema.ecommerce.domain.Order;
import live.zema.ecommerce.repository.OrderRepository;
import live.zema.ecommerce.web.mapper.DateMapper;
import live.zema.ecommerce.web.mapper.OrderMapper;
import live.zema.ecommerce.web.model.LineItemDto;
import live.zema.ecommerce.web.model.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public OrderDto placeOrder(OrderDto orderDto) {

        List<LineItem> listOfLineItems = new ArrayList<>();
        Item item;
        LineItem lineItem;
        for (LineItemDto lineItemDto : orderDto.getLineItemsDto()) {
            item = new Item(lineItemDto.getItemDto().getId(), lineItemDto.getItemDto().getName(),
                    lineItemDto.getItemDto().getDescription(), lineItemDto.getItemDto().getPrice(),
                    dateMapper.asTimestamp(lineItemDto.getItemDto().getCreatedDate()));
            lineItem = new LineItem(lineItemDto.getId(), lineItemDto.getQuantity(),
                    orderMapper.orderDtoToOrder(lineItemDto.getOrderDto()), item);
            listOfLineItems.add(lineItem);
        }

        Order order = new Order(
                orderDto.getId(),
                dateMapper.asTimestamp(orderDto.getCreatedDate()), listOfLineItems);
        return orderMapper.orderToOrderDto(orderRepository.save(order));
    }
}
