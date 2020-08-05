package live.zema.ecommerce.service;

import live.zema.ecommerce.model.ItemDto;

import java.util.List;
import java.util.Optional;

/**
 * @author danielniguse
 */
public interface ItemService {
    List<ItemDto> getAllItems();

    Optional<ItemDto> getItem(long id);

}
