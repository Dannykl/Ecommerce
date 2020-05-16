package live.zema.ecommerce.repository;

import live.zema.ecommerce.domain.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * @author danielniguse
 */

public interface OrderRepository extends PagingAndSortingRepository<Order, UUID> {
//    Set<Order> findByUser(String user);

}
