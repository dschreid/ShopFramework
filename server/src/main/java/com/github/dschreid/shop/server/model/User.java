package com.github.dschreid.shop.server.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Model for User.
 *
 * @author dschreid
 */
@Data
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true) private String username;
    @Column(unique = true) private String email;
    @Column private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Column
    private double balance;

    @Column
    private String address;

    /**
     * Instantiates a new User.
     */
    @Deprecated
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param username the username
     * @param password the password
     * @param email    the email
     */
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * Highest role role.
     *
     * @return the role
     */
    public Role highestRole() {
        Role role = Role.GUEST;
        for (Role tmp : roles) {
            if (tmp.getPermissionLevel() > role.getPermissionLevel())
                role = tmp;
        }
        return role;
    }
}
