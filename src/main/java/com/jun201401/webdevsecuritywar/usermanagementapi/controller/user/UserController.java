package com.jun201401.webdevsecuritywar.usermanagementapi.controller.user;

import com.jun201401.webdevsecuritywar.usermanagementapi.dto.user.PostUserDto;
import com.jun201401.webdevsecuritywar.usermanagementapi.dto.user.RespUserDto;
import com.jun201401.webdevsecuritywar.usermanagementapi.entity.User;
import com.jun201401.webdevsecuritywar.usermanagementapi.exception.DuplicateUserIdException;
import com.jun201401.webdevsecuritywar.usermanagementapi.exception.ValidationFailedException;
import com.jun201401.webdevsecuritywar.usermanagementapi.repository.user.UserRepository;
import com.jun201401.webdevsecuritywar.usermanagementapi.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<RespUserDto> createMember(@Valid @RequestBody PostUserDto postUserDto,
                                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        if (userRepository.existsById(postUserDto.getId())) {
            throw new DuplicateUserIdException("User ID 중복 : " + postUserDto.getId());
        }

        User user = userService.createUser(postUserDto);
        RespUserDto responseDto = new RespUserDto(user.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
