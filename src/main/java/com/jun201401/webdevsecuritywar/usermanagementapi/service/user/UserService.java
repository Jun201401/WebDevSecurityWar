package com.jun201401.webdevsecuritywar.usermanagementapi.service.user;

import com.jun201401.webdevsecuritywar.usermanagementapi.dto.user.GetUserDto;
import com.jun201401.webdevsecuritywar.usermanagementapi.dto.user.PostUserDto;
import com.jun201401.webdevsecuritywar.usermanagementapi.entity.Authority;
import com.jun201401.webdevsecuritywar.usermanagementapi.entity.User;

public interface UserService {
    GetUserDto getUser(String userId);
    User createUser(PostUserDto postUserDto, Authority defaultAuthority);
}
