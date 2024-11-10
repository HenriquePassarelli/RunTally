package com.runtally.runtally.controllers;

import com.runtally.runtally.dto.RoleDTO;
import com.runtally.runtally.dto.UpdateRoleDto;
import com.runtally.runtally.entities.Role;
import com.runtally.runtally.services.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public Role save(@RequestBody RoleDTO role) {
        return roleService.save(role);
    }

    @PutMapping
    public Role update(@RequestBody UpdateRoleDto role) {
        return roleService.update(role);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        roleService.delete(id);
    }

    @GetMapping("{id}")
    public Role getRole(@PathVariable Integer id) {
        return roleService.getRole(id);
    }

    @GetMapping("/all")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }
}
