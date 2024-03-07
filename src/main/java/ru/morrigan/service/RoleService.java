package ru.morrigan.service;

import ru.morrigan.model.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAllRoles();
    void save(Role role);
    Role getRoleByName(String role);
}
