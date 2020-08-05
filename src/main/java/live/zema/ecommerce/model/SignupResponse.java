package live.zema.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Null;
import java.time.OffsetDateTime;

/**
 * @author danielniguse
 */
@AllArgsConstructor
@Data
public class SignupResponse {

    private String owner;
    private String message;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

}
