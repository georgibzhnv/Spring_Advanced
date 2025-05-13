package bg.softuni.tabula.users.repository;

import bg.softuni.tabula.users.model.UserEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findOneByEmail(@NotNull String email);
}
