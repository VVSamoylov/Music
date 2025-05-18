package ru.music.music.Controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.music.music.Entity.MUser;
import ru.music.music.Entity.Subscriptions;
import ru.music.music.Repository.MUserRepository;
import ru.music.music.Repository.SubscriptionRepository;

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
    @Autowired
    private SubscriptionRepository subRepo;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping("/")
    @Transactional
    public @ResponseBody String craeteUser(@RequestBody MUser user){
        try {
            if(user.getId()!= null){
                // удалил на всякий случай так как генерация Id  с помощью базы данных
                user.setId(null);
            }
            urepo.save(user);
        }catch (Exception e){
            logger.error("create user transaction error {}", e.getMessage());
            return "not Created";
        }
        return "created";
    }
    @GetMapping("/{id}")
    public @ResponseBody MUser getUser(@PathVariable Long id){
        return urepo.findById(id).orElse(null);
    }
    @GetMapping("/all")
    public @ResponseBody Iterable<MUser> getAllUsers(){
        return urepo.findAll();
    }
    @PutMapping("/{id}")
    @Transactional
    public  @ResponseBody String updateUser(@PathVariable long id, @RequestBody MUser user){
        try{
            MUser curentUser = urepo.findById(id).orElse(null);
            if(curentUser == null){
                logger.info("not updated user not found");
                return "404";
            }
            curentUser.setFirstName(user.getFirstName());
            curentUser.setMidleName(user.getMidleName());
            curentUser.setLastName(user.getLastName());
            urepo.save(curentUser);
        }catch (Exception e){
            logger.error("update transactional error {}", e.getMessage());
            return "error";
        }
        return "ok";
    }
    @DeleteMapping("/{id}")
    @Transactional
    public @ResponseBody String deleteUser(@PathVariable Long id){
        try{
            urepo.deleteById(id);
        }catch (Exception e){
            logger.error("datete user transactional error {}", e.getMessage());
          return "error";
        }
        return "ok";
    }
    @PostMapping("/{id}/subscriptions")
    @Transactional
    public @ResponseBody String createUserSubscription(@PathVariable Long id, @RequestBody Subscriptions subscriptions){
        try{
            MUser user = urepo.findById(id).orElse(null);
            if(user == null){
                logger.info("create subscription error user  not found " );
                return "user not found";
            }
            Subscriptions curSub  = subRepo.findBySubscriptionName(subscriptions.getSubscriptionName());
            //если подписка новая ит только что созданая и ее нет в базе то сохраняем ее в базу
            if(curSub == null){
                subRepo.save(subscriptions);
                curSub = subscriptions;
            }
            user.getSubscriptions().add(curSub);
            urepo.save(user);
            return "ok";
        }catch (Exception e){
            logger.error(" cretate subscription transactional error {}", e.fillInStackTrace());
            return "error";
        }
    }
    @GetMapping("/{id}/subscriptions")
    public @ResponseBody Iterable<Subscriptions> getUserSubscription(@PathVariable long id){
        return urepo.findById(id).orElse(null).getSubscriptions();
    }
    @DeleteMapping("/{id}/subscriptions/{sub_id}")
    @Transactional
    public @ResponseBody String deleteUserSubscription(@PathVariable Long id, @PathVariable Long sub_id){
        try{
            MUser user = urepo.findById(id).orElse(null);
            if(user == null){
                logger.info("delete subcription error user not found");
                return "user not found";
            }
            // можно было бы сразу получить подписку что бы меньше лезть в базу для увеличения производительности, но это просто пример.
            if(!subRepo.existsById(sub_id)){
                return "subscription not found";
            }
            user.getSubscriptions().remove(subRepo.findById(sub_id).get());
        }catch (Exception e){
            logger.error("delete subscription  transactional error {}", e.getMessage());
            return "error";
        }
        return "ok";
    }
}
