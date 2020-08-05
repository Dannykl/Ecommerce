package live.zema.ecommerce.mapper;

import live.zema.ecommerce.domain.Item;
import live.zema.ecommerce.model.ItemDto;
import org.mapstruct.Mapper;

/**
 * @author danielniguse
 */


@Mapper(uses = DateMapper.class)
public interface ItemMapper {

    ItemDto itemToItemDto(Item item);

    Item itemDtoToItem(ItemDto itemDto);


}
