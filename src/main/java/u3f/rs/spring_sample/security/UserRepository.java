package u3f.rs.spring_sample.security;

import org.springframework.data.repository.CrudRepository;
import u3f.rs.spring_sample.security.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}
