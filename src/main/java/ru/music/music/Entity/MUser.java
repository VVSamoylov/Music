package ru.music.music.Entity;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="users")
public class MUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name="midle_name")
    private String midleName;
    @Column(name="last_name")
    private String lastName;
    /**
     * подписки выделены в отдельную сущьность потому что могут иметь свои свойства например время начала и окончания, статус премиум или нет
     *
     */
    // одной подпиской може пользоваться мнго пользователей и у пользователя может быть много подписок
    @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinTable(name = "list_subscriptions", joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="subscription_id", referencedColumnName = "id"))
    private Set<Subscriptions> subscriptions;

    // Lombok не использую в силу одной из причин


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidleName() {
        return midleName;
    }

    public void setMidleName(String midleName) {
        this.midleName = midleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Subscriptions> getSubscriptions() {
        return subscriptions;
    }


    public void setSubscriptions(Set<Subscriptions> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MUser mUser)) return false;
        return Objects.equals(id, mUser.id) && Objects.equals(firstName, mUser.firstName) && Objects.equals(midleName, mUser.midleName) && Objects.equals(lastName, mUser.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, midleName, lastName);
    }
}
