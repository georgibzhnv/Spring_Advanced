package bg.softuni.tabula.users.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false)
    private long id;

    @NotNull
    @Column(name = "email",nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String passwordHash;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "user_id")
    private List<RoleEntity> roleEntity;
}
