package ru.music.music.Repository;


import org.springframework.data.repository.CrudRepository;
import ru.music.music.Entity.Subscriptions;

public interface SubscriptionRepository extends CrudRepository<Subscriptions, Long> {
}
