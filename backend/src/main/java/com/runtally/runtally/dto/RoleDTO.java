package com.runtally.runtally.dto;

import java.util.List;

public record RoleDTO(String name, String description, List<Integer> permissions) {

    @Override
    public String toString() {
        return "RoleDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
