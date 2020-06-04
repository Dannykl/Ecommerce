package live.zema.ecommerce.web.mapper;

import javax.annotation.processing.Generated;
import live.zema.ecommerce.domain.Order;
import live.zema.ecommerce.domain.Order.OrderBuilder;
import live.zema.ecommerce.web.model.OrderDto;
import live.zema.ecommerce.web.model.OrderDto.OrderDtoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-04T21:20:59+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public OrderDto orderToOrderDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDtoBuilder orderDto = OrderDto.builder();

        if ( order.getId() != null ) {
            orderDto.id( order.getId() );
        }
        orderDto.createdDate( dateMapper.asOffsetDateTime( order.getCreatedDate() ) );

        return orderDto.build();
    }

    @Override
    public Order orderDtoToOrder(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        OrderBuilder order = Order.builder();

        order.id( orderDto.getId() );
        order.createdDate( dateMapper.asTimestamp( orderDto.getCreatedDate() ) );

        return order.build();
    }
}
