package com.runtally.runtally.dto;

public record PermissionDTO(String name, String description) {
    @Override
    public String toString() {
        return "PermissionDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
