package live.zema.ecommerce.service;

import live.zema.ecommerce.domain.Item;
import live.zema.ecommerce.model.ItemDto;
import live.zema.ecommerce.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ItemService2Test {

    private final ItemRepository itemRepository = mock(ItemRepository.class);
    private final ItemService2 itemService2 = new ItemService2(itemRepository);

    @BeforeEach
    public void setUpt() {
        Item itemFixture = Item.builder()
                .id(1L)
                .name("dummyItem")
                .description("dummyDescription")
                .price(BigDecimal.ZERO)
                .image("dummyImage")
                .build();
        when(itemRepository.findAll()).thenReturn(List.of(itemFixture));
        when(itemRepository.findById(1L)).thenReturn(Optional.of(itemFixture));
    }

    @Test
    public void shouldGetAllItems() {
        List<ItemDto> allItems = itemService2.getAllItems();
        assertThat(allItems.size(), is(1));
    }

    @Test
    public void shouldGetItemById() {
        Optional<ItemDto> actual = itemService2.getItem(1L);
        assertThat(actual.get().getId(), is(1L));
        assertThat(actual.get().getName(), is("dummyItem"));
        assertThat(actual.get().getDescription(), is("dummyDescription"));
    }

}