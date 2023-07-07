package com.jun201401.webdevsecuritywar.usermanagementapi.repository.user;

import com.jun201401.webdevsecuritywar.usermanagementapi.dto.user.GetUserDto;
import com.jun201401.webdevsecuritywar.usermanagementapi.entity.QAuthority;
import com.jun201401.webdevsecuritywar.usermanagementapi.entity.QUser;
import com.jun201401.webdevsecuritywar.usermanagementapi.entity.User;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class UserRepositoryImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {
    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public GetUserDto getUser(String userId) {
        QUser qUser = QUser.user;
        QAuthority qAuthority = QAuthority.authority;

        return from(qUser)
                .where(qUser.id.eq(userId))
                .innerJoin(qUser.userAuthority, qAuthority)
                .select(Projections.constructor(GetUserDto.class,
                        qUser.id,
                        qUser.password,
                        qUser.nickname,
                        qUser.email,
                        qAuthority.name
                        ))
                .fetchOne();
    }
}
