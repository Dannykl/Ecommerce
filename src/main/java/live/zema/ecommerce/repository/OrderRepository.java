package live.zema.ecommerce.repository;

import live.zema.ecommerce.domain.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author danielniguse
 */

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
//    Set<Order> findByUser(String user);

}
