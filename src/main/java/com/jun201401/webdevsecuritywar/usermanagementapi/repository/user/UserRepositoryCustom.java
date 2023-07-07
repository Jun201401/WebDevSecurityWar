package com.jun201401.webdevsecuritywar.usermanagementapi.repository.user;

import com.jun201401.webdevsecuritywar.usermanagementapi.dto.user.GetUserDto;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserRepositoryCustom {
    GetUserDto getUser(String userId);
}
