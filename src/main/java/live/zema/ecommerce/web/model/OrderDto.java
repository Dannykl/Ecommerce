package live.zema.ecommerce.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import live.zema.ecommerce.domain.LineItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Null;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

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
    private UUID id;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    @Null
    private OffsetDateTime createdDate;

    @NotNull
    private List<LineItem> lineItemsDto;

//    Customer customer;
}
