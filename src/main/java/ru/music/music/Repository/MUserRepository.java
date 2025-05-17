package ru.music.music.Repository;

import org.springframework.data.repository.CrudRepository;
import ru.music.music.Entity.MUser;

public interface MUserRepository extends CrudRepository<MUser, Long> {
}
