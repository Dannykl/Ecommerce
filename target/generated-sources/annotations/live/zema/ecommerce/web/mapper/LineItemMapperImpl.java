package live.zema.ecommerce.web.mapper;

import javax.annotation.processing.Generated;
import live.zema.ecommerce.domain.LineItem;
import live.zema.ecommerce.domain.LineItem.LineItemBuilder;
import live.zema.ecommerce.web.model.LineItemDto;
import live.zema.ecommerce.web.model.LineItemDto.LineItemDtoBuilder;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-29T11:01:28+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class LineItemMapperImpl implements LineItemMapper {

    @Override
    public LineItemDto lineItemToLineItemDto(LineItem lineItem) {
        if ( lineItem == null ) {
            return null;
        }

        LineItemDtoBuilder lineItemDto = LineItemDto.builder();

        if ( lineItem.getId() != null ) {
            lineItemDto.id( lineItem.getId() );
        }
        lineItemDto.quantity( lineItem.getQuantity() );

        return lineItemDto.build();
    }

    @Override
    public LineItem lineItemDtoToLineItem(LineItemDto lineItemDto) {
        if ( lineItemDto == null ) {
            return null;
        }

        LineItemBuilder lineItem = LineItem.builder();

        lineItem.id( lineItemDto.getId() );
        lineItem.quantity( lineItemDto.getQuantity() );

        return lineItem.build();
    }
}
