package ru.music.music.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.music.music.Repository.SubscriptionRepository;

/**
 * helsCheck для проверки живучести сервиса в Kubernetes
 */
@RestController
public class HelsCheck {

    @GetMapping("/helscheck")
    public String getHelsCheck(){
        return "ok";
    }
}
