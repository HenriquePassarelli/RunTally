package com.runtally.runtally.repositories;

import com.runtally.runtally.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Query("delete from USER u where u.id = ?1")
    void deleteById(String id);

    @Query("select u from USER u where u.id = ?1")
    Optional<User> findById(String id);

    @Query("select u from USER u where u.email = ?1 and u.password = ?2")
    Optional<User> findByEmailAndPassword(String email, String password);

    @Query("select u from USER u where u.email = ?1")
    Optional<User> findByEmail(String email);
}