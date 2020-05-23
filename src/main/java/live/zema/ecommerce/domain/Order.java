package live.zema.ecommerce.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author danielniguse
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(updatable = false, name = "created_date")
    private Timestamp createdDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order",cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_id")
    private List<LineItem> lineItems;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
}
