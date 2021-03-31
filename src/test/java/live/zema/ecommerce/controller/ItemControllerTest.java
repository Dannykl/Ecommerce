package live.zema.ecommerce.controller;

import live.zema.ecommerce.domain.Item;
import live.zema.ecommerce.model.ItemDto;
import live.zema.ecommerce.service.ItemService2;
import live.zema.ecommerce.util.JwtUtil;
import live.zema.ecommerce.web.controller.ItemController;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ItemService2 itemService2;

    @Autowired
    JwtUtil jwtUtil;

    final private String url = "/api/v1/item/";
    final private long id = 2;

//    @BeforeEach
////    public void setUp(){
////        this.mockMvc = MockMvcBuilders.standaloneSetup(new ItemController(itemService2)).build();
////    }

    @Test
    void testGetItem() throws Exception {
//        given(itemService2.getItem(any())).willReturn(getSingleItem());
//        mockMvc.perform(get(url + id).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
    }


    private Optional<ItemDto> getSingleItem() {
        return Optional.of(ItemDto.builder()
                .id(id)
                .description("foot wear")
                .name("shoe name X")
                .price(BigDecimal.valueOf(99.29))
                .image("http/")
                .createdDate(OffsetDateTime.parse(""))
                .build());
    }

}
