package com.example.wwwjava.repositories;

import com.example.wwwjava.models.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Rollback(false)
public class RoleRepositoryTests {
    @Autowired
    private RoleRepository repo;

    @Test
    public void checkExsitingRoles(){
        List<Role> listRoles = repo.findAll(); // with USER and Admin

        assertEquals(listRoles.size(), 2);
    }

    @Test
    public void checkIfAdminRoleExist(){
        List<Role> listRoles = repo.findAll();
        Role adminRole = listRoles.stream().filter(role -> role.getName().equals("ROLE_ADMIN")).collect(Collectors.toList()).get(0);

        assertEquals(adminRole == null,false);
    }

    @Test
    public void checkIfUserRoleExist(){
        List<Role> listRoles = repo.findAll();
        Role adminRole = listRoles.stream().filter(role -> role.getName().equals("ROLE_USER")).collect(Collectors.toList()).get(0);

        assertEquals(adminRole == null,false);
    }
}
