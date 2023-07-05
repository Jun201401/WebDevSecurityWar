package com.jun201401.webdevsecuritywar.usermanagementapi.service.user;

import com.jun201401.webdevsecuritywar.usermanagementapi.dto.user.PostUserDto;
import com.jun201401.webdevsecuritywar.usermanagementapi.entity.User;

public interface UserService {
    User createUser(PostUserDto postUserDto);
}
