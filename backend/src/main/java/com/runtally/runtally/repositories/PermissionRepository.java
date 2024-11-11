package com.runtally.runtally.repositories;

import com.runtally.runtally.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
