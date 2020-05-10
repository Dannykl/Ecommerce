package live.zema.ecommerce.service;

import live.zema.ecommerce.domain.Item;
import live.zema.ecommerce.domain.LineItem;
import live.zema.ecommerce.domain.Order;
import live.zema.ecommerce.domain.User;
import live.zema.ecommerce.repository.OrderRepository;
import live.zema.ecommerce.web.mapper.*;
import live.zema.ecommerce.web.model.LineItemDto;
import live.zema.ecommerce.web.model.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author danielniguse
 */

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final DateMapper dateMapper;
    private final UserMapper userMapper;
    private final LineItemMapper lineItemMapper;
    private final ItemMapper itemMapper;

    //TODO refactoring required
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
                dateMapper.asTimestamp(orderDto.getCreatedDate()), listOfLineItems, userMapper.userDtoToUser(orderDto.getUserDto()));
        return orderMapper.orderToOrderDto(orderRepository.save(order));
    }

    @Override
    public Set<OrderDto> findAllOrder() {
        Set<OrderDto> orders = new HashSet<>();
        var example = orderRepository.findAll();

        for (Order i : example) {
            orders.add(new OrderDto(i.getId(), dateMapper.asOffsetDateTime(i.getCreatedDate()),
                    lineItemToLineItemDto(i.getLineItems()),
                    userMapper.userToUserDto(new User(i.getUser().getEmail(), null,
                            i.getUser().getRoleType(), i.getUser().getOrders(), i.getUser().getCreatedDate()))));
        }
        return orders;
    }

    //TODO itemDto needs to handled and passed to client. at the moment it shows null
    private List<LineItemDto> lineItemToLineItemDto(List<LineItem> lineItem) {
        List<LineItemDto> items = new ArrayList<>();

        lineItem.forEach(item -> items.add((lineItemMapper.lineItemToLineItemDto(new LineItem(
                item.getId(),
                item.getQuantity(),
                null,
                new Item(
                        item.getItem().getId(),
                        item.getItem().getName(),
                        item.getItem().getDescription(),
                        item.getItem().getPrice(),
                        item.getItem().getCreatedDate()))))
        ));
        System.out.println(items);
        System.out.println(items);
        return items;
    }


}
