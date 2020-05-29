package live.zema.ecommerce.web.mapper;

import javax.annotation.processing.Generated;
import live.zema.ecommerce.domain.Item;
import live.zema.ecommerce.domain.Item.ItemBuilder;
import live.zema.ecommerce.web.model.ItemDto;
import live.zema.ecommerce.web.model.ItemDto.ItemDtoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-29T22:58:05+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public ItemDto itemToItemDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDtoBuilder itemDto = ItemDto.builder();

        if ( item.getId() != null ) {
            itemDto.id( item.getId() );
        }
        itemDto.name( item.getName() );
        itemDto.description( item.getDescription() );
        itemDto.price( item.getPrice() );
        itemDto.createdDate( dateMapper.asOffsetDateTime( item.getCreatedDate() ) );
        itemDto.image( item.getImage() );

        return itemDto.build();
    }

    @Override
    public Item itemDtoToItem(ItemDto itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        ItemBuilder item = Item.builder();

        item.id( itemDto.getId() );
        item.name( itemDto.getName() );
        item.description( itemDto.getDescription() );
        item.price( itemDto.getPrice() );
        item.createdDate( dateMapper.asTimestamp( itemDto.getCreatedDate() ) );
        item.image( itemDto.getImage() );

        return item.build();
    }
}
