package live.zema.ecommerce.web.mapper;

import live.zema.ecommerce.domain.LineItem;
import live.zema.ecommerce.web.model.LineItemDto;
import org.mapstruct.Mapper;

/**
 * @author danielniguse
 */


@Mapper(uses = DateMapper.class)
public interface LineItemMapper {

    LineItemDto lineItemToLineItemDto(LineItem lineItem);

    LineItem lineItemDtoToLineItem(LineItemDto lineItemDto);


}