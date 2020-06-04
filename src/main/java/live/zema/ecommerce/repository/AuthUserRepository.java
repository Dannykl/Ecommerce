package live.zema.ecommerce.repository;

import live.zema.ecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author danielniguse
 */
@Repository
public interface AuthUserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);

}
