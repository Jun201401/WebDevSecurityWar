package com.jun201401.webdevsecuritywar.usermanagementapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_has_roles")
public class UserRole {
    @EmbeddedId
    private Pk pk;
    @Embeddable
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Pk implements Serializable {
        @Column(name = "users_id")
        private Long userId;
        @Column(name = "roles_id")
        private Long roleId;
    }

    @MapsId("userId")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "users_id")
    private User user;

    @MapsId("roleId")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "roles_id")
    private Role role;
}
