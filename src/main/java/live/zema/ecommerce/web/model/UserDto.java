package live.zema.ecommerce.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import live.zema.ecommerce.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.time.OffsetDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    @Id
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @Null
    RoleType roleType;

    @Null
    private Set<Order> orders;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    @Null
    private OffsetDateTime createdDate;


}
