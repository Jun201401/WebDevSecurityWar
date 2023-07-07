package com.jun201401.webdevsecuritywar.usermanagementapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    private String id;
    private String password;
    private String nickname;
    private String email;
    @ManyToOne
    @JoinColumn(name = "authorities_id")
    private Authority userAuthority;
}
