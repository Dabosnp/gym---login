package gym.login.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.loginservice.model.*;

import gym.login.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/gym")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
     @Autowired
    private LoginService service;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        logger.info("Tentataivo di login per user:" + user.getUsername());
        String token = service.authenticate(user);
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
