package ru.morrigan.service.util;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.morrigan.model.Role;
import ru.morrigan.model.User;
import ru.morrigan.service.RoleServiceImpl;
import ru.morrigan.service.UserServiceImpl;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class StartupInitializer {
    private final RoleServiceImpl rs;
    private final UserServiceImpl us;
    private final BCryptPasswordEncoder bcpe;

    @PostConstruct
    public void initRoles(){
        Role roleUser = new Role();
        roleUser.setName("USER");
        rs.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ADMIN");
        rs.save(roleAdmin);
        // Этот работает

        Set<Role> roleListUser = new HashSet<>();
        User user = new User();
        user.setName("User");
        user.setLastname("Usov");
        user.setAge(24);
        user.setEmail("User@yandex.com");
        user.setUsername(user.getName());
        user.setPassword(bcpe.encode("user"));

        roleListUser.add(roleUser);
        user.setRoles(roleListUser);
        us.save(user);

        Set<Role> roleListAdmin = new HashSet<>();
        User admin = new User();
        admin.setUsername(admin.getName());
        admin.setName("Admin");
        admin.setLastname("Adminov");
        admin.setAge(36);
        admin.setEmail("Admin@yandex.com");
        admin.setPassword(bcpe.encode("admin"));

        roleListAdmin.add(roleUser);
        roleListAdmin.add(roleAdmin);
        admin.setRoles(roleListAdmin);
        us.save(admin);
    }
}