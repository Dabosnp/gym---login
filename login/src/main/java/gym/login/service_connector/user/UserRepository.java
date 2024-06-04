package gym.login.service_connector.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<UserEntity, String> {
        UserEntity findByUserAndPassword(String username, String password);
    }

