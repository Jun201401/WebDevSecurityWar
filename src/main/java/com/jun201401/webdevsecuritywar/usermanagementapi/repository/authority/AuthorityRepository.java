package com.jun201401.webdevsecuritywar.usermanagementapi.repository.authority;

import com.jun201401.webdevsecuritywar.usermanagementapi.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
