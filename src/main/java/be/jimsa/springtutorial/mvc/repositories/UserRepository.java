package be.jimsa.springtutorial.mvc.repositories;

import be.jimsa.springtutorial.mvc.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    // 1. Query
    @Query("SELECT u from UserEntity u where u.email = :email order by u.createdAt DESC")
    Optional<UserEntity> getUserUsingQuery(String email);

    @Query(
            value = "SELECT * from tutappdb.users u where u.email = :email order by u.created_at DESC",
            nativeQuery = true
    )
    Optional<UserEntity> getUserUsingNativeQuery(@Param("email") String emailAddress);

    @Query("SELECT u from UserEntity u where u.email = ?1 and u.id = ?2 order by u.createdAt DESC")
    Optional<UserEntity> getUserUsingQuery(String email, Long id);

    /*
    * Normally, to use the update, we had to find the object first (findBy...),
    * then save it again (.save()),
    * which was considered as an update
    * considering that the ID already existed!
    * Now, we can use JPQL to update it directly!
    * */
    @Transactional
    @Modifying
    @Query("UPDATE UserEntity u SET u.email = ?1 WHERE u.id = ?2")
    int updateStatusById(String email, long id);


    // 2. NamedQuery


    // 3. NamedNativeQuery


}
