package com.jun201401.webdevsecuritywar.usermanagementapi.repository.user;

import com.jun201401.webdevsecuritywar.usermanagementapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>, UserRepositoryCustom {
}
