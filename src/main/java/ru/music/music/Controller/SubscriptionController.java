package ru.music.music.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.music.music.Repository.SubscriptionRepository;

/**
 * GET /subscriptions/top - получить ТОП-3 популярных подписок
 */
@RestController
public class SubscriptionController {
    @Autowired
    private SubscriptionRepository subRepo;
}
