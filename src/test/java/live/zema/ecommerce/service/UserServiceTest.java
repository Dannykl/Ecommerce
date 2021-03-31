package live.zema.ecommerce.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import live.zema.ecommerce.domain.User;
import live.zema.ecommerce.mapper.DateMapper;
import live.zema.ecommerce.mapper.UserMapper;
import live.zema.ecommerce.model.UserDto;
import live.zema.ecommerce.repository.UserRepository;
import live.zema.ecommerce.security.PasswordConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        String email = "danielniguse8@gmail.com";
        User user = User.builder()
                .email(email)
                .password("pass")
                .createdDate(Timestamp.valueOf("2018-11-12 01:02:03.123456789"))
                .build();
        given(userRepository.findByEmail(email)).willReturn(Optional.of(user));
//        when(userRepository.save(user)).thenReturn(user);
    }

    @Test
    void testFindByEmail() {
//        String email = "danielniguse8@gmail.com";
//        Optional<UserDto> actual = userService.findByEmail(email);
//        System.out.println("fetched " + actual);

//        assertEquals(actual.get().getEmail(), email);
    }
}
