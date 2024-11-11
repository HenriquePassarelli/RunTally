package com.runtally.runtally.controllers;

import com.runtally.runtally.dto.PermissionDTO;
import com.runtally.runtally.dto.UpdatePermissionDTO;
import com.runtally.runtally.entities.Permission;
import com.runtally.runtally.services.PermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permission")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping
    public Permission save(@RequestBody PermissionDTO permission) {
        return permissionService.save(permission);
    }

    @PutMapping
    public Permission update(@RequestBody UpdatePermissionDTO permission) {
        return permissionService.update(permission);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        permissionService.delete(id);
    }

    @GetMapping("{id}")
    public Permission getPermission(@PathVariable Integer id) {
        return permissionService.getPermission(id);
    }

    @GetMapping("/all")
    public List<Permission> getPermissions() {
        return permissionService.getPermissions();
    }
}
