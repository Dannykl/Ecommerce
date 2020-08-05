package live.zema.ecommerce.domain;

import lombok.*;

import javax.persistence.*;


/**
 * @author danielniguse
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "line_item")
public class LineItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
