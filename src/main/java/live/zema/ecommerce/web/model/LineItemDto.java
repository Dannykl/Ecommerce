package live.zema.ecommerce.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.Null;
import java.util.UUID;

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
    private UUID id;

    private int quantity;

    private OrderDto orderDto;

    private ItemDto itemDto;
}
