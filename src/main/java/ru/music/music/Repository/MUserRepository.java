package ru.music.music.Repository;

import org.springframework.data.repository.CrudRepository;
import ru.music.music.Entity.MUsers;

public interface MUserRepository extends CrudRepository<MUsers, Long> {
}
