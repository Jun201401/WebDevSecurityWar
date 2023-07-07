package com.jun201401.webdevsecuritywar.usermanagementapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;
}
