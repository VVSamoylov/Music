package ru.music.music.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.music.music.Repository.MUserRepository;

/**
 * POST /users - создать пользователя
 * GET /users/{id} - получить информацию о пользователе
 * PUT /users/{id} - обновить пользователя
 * DELETE /users/{id} - удалить пользователя
 * POST /users/{id}/subscriptions - добавить подписку
 * GET /users/{id}/subscriptions - получить подписки пользователя
 * DELETE /users/{id}/subscriptions/{sub_id} - удалить подписку
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private MUserRepository urepo;


}
