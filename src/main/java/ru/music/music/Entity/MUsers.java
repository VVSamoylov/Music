package ru.music.music.Entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="users")
public class MUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name="midle_name")
    private String midleName;
    @Column(name="last_name")
    private String LastName;
    /**
     * подписки выделены в отдельную сущьность потому что могут иметь свои свойства например время начала и окончания, статус премиум или нет
     *
     */


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE )
    @JoinColumn(name="usersubscript_id", nullable=true)
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
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
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
        if (!(o instanceof MUsers mUsers)) return false;
        return Objects.equals(id, mUsers.id) && Objects.equals(firstName, mUsers.firstName) && Objects.equals(midleName, mUsers.midleName) && Objects.equals(LastName, mUsers.LastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, midleName, LastName);
    }
}
