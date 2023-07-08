package com.jun201401.webdevsecuritywar.usermanagementapi.service.user;

import com.jun201401.webdevsecuritywar.usermanagementapi.dto.user.GetUserDto;
import com.jun201401.webdevsecuritywar.usermanagementapi.dto.user.PostUserDto;
import com.jun201401.webdevsecuritywar.usermanagementapi.entity.Authority;
import com.jun201401.webdevsecuritywar.usermanagementapi.entity.User;
import com.jun201401.webdevsecuritywar.usermanagementapi.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public GetUserDto getUser(String userId) {
        return userRepository.getUser(userId);
    }

    @Override
    @Transactional
    public User createUser(PostUserDto postUserDto, Authority defaultAuthority) {
        User user = new User(
                postUserDto.getId(),
                postUserDto.getPassword(),
                postUserDto.getNickname(),
                postUserDto.getEmail(),
                defaultAuthority
        );
        return userRepository.saveAndFlush(user);
    }
}
