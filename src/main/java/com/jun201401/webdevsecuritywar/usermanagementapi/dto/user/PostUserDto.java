package com.jun201401.webdevsecuritywar.usermanagementapi.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostUserDto {
    @NotBlank
    private String id;
    @NotBlank
    private String password;
    @NotBlank
    private String nickname;
    @Email
    private String email;
}
