package com.runtally.runtally.dto;

public record UpdatePermissionDTO(Integer id, String name, String description) {
    @Override
    public String toString() {
        return "UpdatePermissionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
