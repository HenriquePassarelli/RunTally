package com.runtally.runtally.repositories;

import com.runtally.runtally.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
