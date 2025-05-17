package ru.music.music.Entity;

import jakarta.persistence.*;


@Entity
@Table(name="subscriptions")
public class Subscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="subscription_name")
    private String subscriptionName;
}
