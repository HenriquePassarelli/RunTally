package com.runtally.runtally.services;

import com.runtally.runtally.dto.RoleDTO;
import com.runtally.runtally.dto.UpdateRoleDto;
import com.runtally.runtally.entities.Role;
import com.runtally.runtally.repositories.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public Role save(RoleDTO roleDTO) {
        return roleRepository.save(new Role(roleDTO));
    }

    @Transactional
    public Role update(UpdateRoleDto roleDTO) {
        Role role = getRole(roleDTO.id());

        role.setName(roleDTO.name());
        role.setDescription(roleDTO.description());

        return roleRepository.save(role);
    }

    @Transactional
    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }

    public Role getRole(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
