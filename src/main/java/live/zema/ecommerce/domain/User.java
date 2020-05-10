package live.zema.ecommerce.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer")
public class User {

    @Id
    private String email;

    private String password;

    private RoleType roleType;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Order> orders;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;


}
