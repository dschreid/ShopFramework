package com.github.dschreid.shop.server.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Model for Session.
 *
 * @author dschreid
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn
    private User user;

    @Column private String token;
    @Column private Long expiresAt;

}
