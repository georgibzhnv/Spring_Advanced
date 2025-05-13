package bg.softuni.tabula.users.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false)
    private long id;

    @Column(name = "role",nullable = false)
    private String role;
}
