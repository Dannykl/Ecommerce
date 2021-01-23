package live.zema.ecommerce.service;

import live.zema.ecommerce.domain.Item;
import live.zema.ecommerce.model.ItemDto;
import live.zema.ecommerce.repository.ItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author danielniguse
 */
public class ItemService2  {
    private final ItemRepository itemRepository;

    public ItemService2(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public List<ItemDto> getAllItems() {
        return itemRepository
                .findAll()
                .stream()
                .map(this::mapToItemDto)
                .collect(Collectors.toList());
    }

    private ItemDto mapToItemDto(Item item) {
        return ItemDto
                .builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .price(item.getPrice())
                .image(item.getImage())
                .build();
    }


    public Optional<ItemDto> getItem(long id) {
        Optional<Item> result = itemRepository.findById(id);
        return result.isEmpty() ? Optional.empty() : Optional.of(mapToItemDto(result.get()));
    }


}
