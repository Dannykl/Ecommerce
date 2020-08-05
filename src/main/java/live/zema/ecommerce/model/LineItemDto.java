package live.zema.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.Null;

/**
 * @author danielniguse
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LineItemDto {
    @Id
    @Null
    private long id;

    private int quantity;

    private OrderDto orderDto;

    private ItemDto itemDto;
}
