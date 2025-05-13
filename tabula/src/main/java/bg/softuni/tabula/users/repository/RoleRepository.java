package bg.softuni.tabula.users.repository;

import bg.softuni.tabula.users.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
}
