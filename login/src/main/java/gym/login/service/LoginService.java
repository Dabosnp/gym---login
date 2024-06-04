package gym.login.service;

import com.example.loginservice.model.User;
import gym.login.service.util.JwtUtil;
import gym.login.service_connector.user.UserEntity;
import gym.login.service_connector.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public String authenticate(User user) {
        UserEntity dbUser = userRepository.findByUserAndPassword(user.getUsername(), user.getPassword());
        if (dbUser != null) {
            return jwtUtil.generateToken(user.getUsername());
        } else {
            return null;
        }
    }
}
