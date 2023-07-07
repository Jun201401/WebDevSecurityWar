package com.jun201401.webdevsecuritywar.usermanagementapi.controller.user;

import com.jun201401.webdevsecuritywar.usermanagementapi.dto.user.GetUserDto;
import com.jun201401.webdevsecuritywar.usermanagementapi.dto.user.PostUserDto;
import com.jun201401.webdevsecuritywar.usermanagementapi.dto.user.RespUserDto;
import com.jun201401.webdevsecuritywar.usermanagementapi.entity.Authority;
import com.jun201401.webdevsecuritywar.usermanagementapi.entity.User;
import com.jun201401.webdevsecuritywar.usermanagementapi.exception.DuplicateUserIdException;
import com.jun201401.webdevsecuritywar.usermanagementapi.exception.NotFoundAuthorityException;
import com.jun201401.webdevsecuritywar.usermanagementapi.exception.ValidationFailedException;
import com.jun201401.webdevsecuritywar.usermanagementapi.repository.authority.AuthorityRepository;
import com.jun201401.webdevsecuritywar.usermanagementapi.repository.user.UserRepository;
import com.jun201401.webdevsecuritywar.usermanagementapi.service.user.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    @Value("${user.default.authorityId}")
    private String defaultAuthorityId;
    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<GetUserDto> getUser(@PathVariable String userId) {
        return ResponseEntity.ok().body(userService.getUser(userId));
    }

    @PostMapping
    public ResponseEntity<RespUserDto> createMember(@Valid @RequestBody PostUserDto postUserDto,
                                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        if (userRepository.existsById(postUserDto.getId())) {
            throw new DuplicateUserIdException("User ID 중복 : " + postUserDto.getId());
        }
        Authority defaultAuthority = authorityRepository.findById(defaultAuthorityId)
                .orElseThrow(() -> new NotFoundAuthorityException(defaultAuthorityId));
        User user = userService.createUser(postUserDto, defaultAuthority);
        RespUserDto responseDto = new RespUserDto(user.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
