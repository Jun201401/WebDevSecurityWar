package com.jun201401.webdevsecuritywar.usermanagementapi.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetUserDto {
    private String id;
    private String password;
    private String nickname;
    private String email;
    private String userAuthority;
}