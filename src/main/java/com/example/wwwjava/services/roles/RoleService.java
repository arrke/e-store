package com.example.wwwjava.services.roles;

import com.example.wwwjava.models.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Optional<Role> getRoleById(Long id);
    List<Role> getAllRoles();

    Role saveRole(Role role);

    void deleteRoleById(Long id);
    Role findRoleByName(String roleName);

}
