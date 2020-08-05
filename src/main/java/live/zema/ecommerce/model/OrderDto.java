package live.zema.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author danielniguse
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    @Id
    @Null
    private long id;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    @Null
    private OffsetDateTime createdDate;

    @NotNull
    private List<LineItemDto> lineItemsDto;

    @Null
    UserDto userDto;
}
