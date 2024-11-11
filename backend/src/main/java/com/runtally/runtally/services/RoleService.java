package com.runtally.runtally.services;

import com.runtally.runtally.dto.RoleDTO;
import com.runtally.runtally.dto.UpdateRoleDto;
import com.runtally.runtally.entities.Permission;
import com.runtally.runtally.entities.Role;
import com.runtally.runtally.repositories.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final PermissionService permissionService;

    public RoleService(RoleRepository roleRepository, PermissionService permissionService) {
        this.roleRepository = roleRepository;
        this.permissionService = permissionService;
    }

    @Transactional
    public Role save(RoleDTO roleDTO) {
        List<Permission> permissions = permissionService.getPermissions(roleDTO.permissions());
        if (permissions.isEmpty()) throw new IllegalArgumentException("Permissions do not exist or are invalid");

        Role role = new Role(roleDTO.name(), roleDTO.description(), permissions);

        return roleRepository.save(role);
    }

    @Transactional
    public Role update(UpdateRoleDto roleDTO) {
        Role role = getRole(roleDTO.id());

        role.setName(roleDTO.name());
        role.setDescription(roleDTO.description());
        role.setPermissions(permissionService.getPermissions(roleDTO.permissions()));

        return roleRepository.save(role);
    }

    @Transactional
    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }

    public Role getRole(Integer id) {
        return roleRepository.findById(id).orElseThrow(() -> new NullPointerException("Role not found"));
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public List<Role> getRoles(List<Integer> roles) {
        return roleRepository.findAllById(roles);
    }
}
