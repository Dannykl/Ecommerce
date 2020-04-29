package live.zema.ecommerce.service;

import live.zema.ecommerce.web.model.ItemDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author danielniguse
 */
public interface ItemService {
    List<ItemDto> getAllItems();

    Optional<ItemDto> getItem(UUID id);

}
