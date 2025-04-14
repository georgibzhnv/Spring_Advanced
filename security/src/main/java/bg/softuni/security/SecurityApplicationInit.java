package bg.softuni.security;

import bg.softuni.security.model.AuthorityEntity;
import bg.softuni.security.model.UserEntity;
import bg.softuni.security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityApplicationInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SecurityApplicationInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        UserEntity user = new UserEntity();
        user.setName("user")
                .setPassword(passwordEncoder.encode("user"))
                .setEnabled(true);

        AuthorityEntity authorityEntity = new AuthorityEntity();
        authorityEntity.setName("ROLE_USER");
        authorityEntity.setUser(user);
        user.setAuthorities(List.of(authorityEntity));

        userRepository.save(user);

        UserEntity admin = new UserEntity();
        admin.setName("admin")
                .setEnabled(true)
                .setPassword(passwordEncoder.encode("admin"));

        AuthorityEntity adminAuthorityEntity = new AuthorityEntity();
        adminAuthorityEntity.setName("ROLE_ADMIN");
        adminAuthorityEntity.setUser(admin);

        AuthorityEntity adminUserAuthorityEntity = new AuthorityEntity();
        adminUserAuthorityEntity.setName("ROLE_USER");
        adminUserAuthorityEntity.setUser(admin);

        admin.setAuthorities(List.of(adminAuthorityEntity,adminUserAuthorityEntity));

        userRepository.save(admin);
    }
}
