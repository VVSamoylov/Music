package ru.music.music.Entity;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name="subscriptions")
public class Subscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // в базе поле имеет уникальное значение и не используется вместо id что бы можно менять имя подписки
    @Column(name="subscription_name")
    private String subscriptionName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscriptions that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(subscriptionName, that.subscriptionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subscriptionName);
    }
}
