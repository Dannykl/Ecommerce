package live.zema.ecommerce.service;

import live.zema.ecommerce.domain.Item;
import live.zema.ecommerce.domain.LineItem;
import live.zema.ecommerce.domain.Order;
import live.zema.ecommerce.domain.User;
import live.zema.ecommerce.repository.OrderRepository;
import live.zema.ecommerce.web.mapper.DateMapper;
import live.zema.ecommerce.web.mapper.OrderMapper;
import live.zema.ecommerce.web.mapper.UserMapper;
import live.zema.ecommerce.web.model.ItemDto;
import live.zema.ecommerce.web.model.LineItemDto;
import live.zema.ecommerce.web.model.OrderDto;
import live.zema.ecommerce.web.model.UserDto;
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


    //TODO refactoring is required
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

    @Override
    public List<OrderDto> findCustomerOrder(String email) {
        var orders = orderRepository.findAll();
        List<OrderDto> ordersDto = new ArrayList<>();

        for (Order i : orders) {
            if (i.getUser().getEmail().equals(email)) {
                ordersDto.add(new OrderDto(
                        i.getId(),
                        dateMapper.asOffsetDateTime(i.getCreatedDate()),
                        lineItemToLineItemDto(i.getLineItems())
                        , new UserDto(
                        i.getUser().getEmail(), null, null, null, null)));
            }
        }
        return ordersDto;
    }


    private List<LineItemDto> lineItemToLineItemDto(List<LineItem> lineItem) {

        List<LineItemDto> items = new ArrayList<>();
        ItemDto product;
        LineItemDto lineItemDto;
        for (LineItem x : lineItem) {
            product = new ItemDto(
                    x.getItem().getId(),
                    x.getItem().getName(),
                    x.getItem().getDescription(),
                    x.getItem().getPrice(),
                    dateMapper.asOffsetDateTime(x.getItem().getCreatedDate()));

            lineItemDto = new LineItemDto(x.getId(), x.getQuantity(),
                    orderMapper.orderToOrderDto(x.getOrder()), product);
            items.add(lineItemDto);

        }
        return items;
    }

}
