package live.zema.ecommerce.mapper;

import live.zema.ecommerce.domain.Order;
import live.zema.ecommerce.model.OrderDto;
import org.mapstruct.Mapper;

/**
 * @author danielniguse
 */


@Mapper(uses = DateMapper.class)
public interface OrderMapper {

    OrderDto orderToOrderDto(Order order);
    Order orderDtoToOrder(OrderDto orderDto);


}
