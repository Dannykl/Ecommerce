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
@Table(name = "customers")
public class User {

    @Id
    private String email;

    private String password;

    @Column(name = "role_type")
    private RoleType roleType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Order> orders;

    @CreationTimestamp
    @Column(updatable = false, name = "created_date")
    private Timestamp createdDate;


}
