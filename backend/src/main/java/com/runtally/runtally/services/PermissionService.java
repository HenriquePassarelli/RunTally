package com.runtally.runtally.services;

import com.runtally.runtally.dto.PermissionDTO;
import com.runtally.runtally.dto.UpdatePermissionDTO;
import com.runtally.runtally.entities.Permission;
import com.runtally.runtally.repositories.PermissionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Transactional
    public Permission save(PermissionDTO permission) {
        return permissionRepository.save(new Permission(permission.name(), permission.description()));
    }

    @Transactional
    public Permission update(UpdatePermissionDTO permission) {
        Permission permissionToUpdate = getPermission(permission.id());

        permissionToUpdate.setName(permission.name());
        permissionToUpdate.setDescription(permission.description());

        return permissionRepository.save(permissionToUpdate);
    }

    @Transactional
    public void delete(Integer id) {
        permissionRepository.deleteById(id);
    }

    public Permission getPermission(Integer id) {
        return permissionRepository.findById(id).orElseThrow(() -> new NullPointerException("Permission not found"));
    }

    public List<Permission> getPermissions() {
        return permissionRepository.findAll();
    }

    public List<Permission> getPermissions(List<Integer> permissions) {
        return permissionRepository.findAllById(permissions);
    }
}
