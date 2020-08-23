package live.zema.ecommerce.repository;

import live.zema.ecommerce.domain.Item;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author danielniguse
 */
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

    List<Item> findAll();

    Optional<Item> findById(Long aLong);
}
