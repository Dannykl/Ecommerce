package live.zema.ecommerce.service;

import live.zema.ecommerce.domain.Item;
import live.zema.ecommerce.repository.ItemRepository;
import live.zema.ecommerce.mapper.ItemMapper;
import live.zema.ecommerce.model.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author danielniguse
 */
@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public List<ItemDto> getAllItems() {
        List<ItemDto> listOfItems = new ArrayList<>();
        itemRepository.findAll().forEach(eachItem -> listOfItems.add(itemMapper.itemToItemDto(eachItem)));
        return listOfItems;
    }

    @Override
    public Optional<ItemDto> getItem(long id) {
        Optional<Item> result = itemRepository.findById(id);
        return result.isEmpty() ? Optional.empty() : Optional.of(itemMapper.itemToItemDto(result.get()));
    }


}
