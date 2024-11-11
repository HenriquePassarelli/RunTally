package com.runtally.runtally.dto;

import java.util.List;

public record UpdateRoleDto(Integer id, String name, String description, List<Integer> permissions) {
}
