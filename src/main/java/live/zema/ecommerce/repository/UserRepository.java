package live.zema.ecommerce.repository;

import live.zema.ecommerce.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author danielniguse
 */
public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByEmail(String email);
}
