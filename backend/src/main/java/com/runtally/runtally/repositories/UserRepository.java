package com.runtally.runtally.repositories;

import com.runtally.runtally.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update USER u set u.password = ?2, u.name = ?3 where u.id = ?1")
    Integer updateById(String id, String password, String name);

    @Modifying
    @Query("delete from USER u where u.id = ?1")
    void deleteById(String id);

    @Query("select u from USER u where u.id = ?1")
    Optional<User> findById(String id);
}