package ru.music.music.Repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.music.music.Entity.Subscriptions;

public interface SubscriptionRepository extends CrudRepository<Subscriptions, Long> {
    @Query("select sub from Subscriptions sub where sub.subscriptionName = :name")
    Subscriptions findBySubscriptionName(String name);

}
