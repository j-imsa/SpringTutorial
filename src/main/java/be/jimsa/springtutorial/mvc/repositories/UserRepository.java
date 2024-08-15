package be.jimsa.springtutorial.mvc.repositories;

import be.jimsa.springtutorial.mvc.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
