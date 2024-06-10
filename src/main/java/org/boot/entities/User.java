package org.boot.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    private String username;
    private String password;
    private String status;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
