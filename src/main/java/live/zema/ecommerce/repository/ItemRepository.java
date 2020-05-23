package live.zema.ecommerce.repository;

import live.zema.ecommerce.domain.Item;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * @author danielniguse
 */
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
}
