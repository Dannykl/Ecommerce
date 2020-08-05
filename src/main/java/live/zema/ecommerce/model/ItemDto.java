package live.zema.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * @author danielniguse
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDto {
    @Id
    @Null
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private BigDecimal price;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    @Null
    private OffsetDateTime createdDate;

    @Null
    private String image;
}
