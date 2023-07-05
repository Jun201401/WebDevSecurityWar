package com.jun201401.webdevsecuritywar.usermanagementapi.repository.user;

import com.jun201401.webdevsecuritywar.usermanagementapi.entity.User;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class UserRepositoryImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {
    public UserRepositoryImpl() {
        super(User.class);
    }
}
