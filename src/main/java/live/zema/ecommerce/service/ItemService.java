package live.zema.ecommerce.service;

import live.zema.ecommerce.web.model.ItemDto;

import java.util.List;

/**
 * @author danielniguse
 */
public interface ItemService {
    List<ItemDto> getAllItems();
}
