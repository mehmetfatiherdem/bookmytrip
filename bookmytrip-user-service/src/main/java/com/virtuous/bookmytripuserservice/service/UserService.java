package com.virtuous.bookmytripuserservice.service;

import com.virtuous.bookmytripuserservice.converter.UserConverter;
import com.virtuous.bookmytripuserservice.dto.request.UserSaveRequest;
import com.virtuous.bookmytripuserservice.dto.response.UserResponse;
import com.virtuous.bookmytripuserservice.exception.BookMyTripException;
import com.virtuous.bookmytripuserservice.exception.ExceptionMessages;
import com.virtuous.bookmytripuserservice.model.Role;
import com.virtuous.bookmytripuserservice.model.User;
import com.virtuous.bookmytripuserservice.model.enums.RoleName;
import com.virtuous.bookmytripuserservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return UserConverter.toResponse(users);
    }

    public UserResponse getUserByEmail(String email) {
        User user = findByEmail(email);
        return UserConverter.toResponse(user);
    }

    public UserResponse createUser(UserSaveRequest request, RoleName roleName) {
        User user = new User();
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPhoneNumber());

        Role role = roleService.findRoleByRoleName(roleName);

        user.getRoles().add(role);

        userRepository.save(user);

        return UserConverter.toResponse(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public UserResponse getProfile() {
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String email = userDetails.getUsername();
        User user = findByEmail(email);
        return UserConverter.toResponse(user);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User findByEmail(String email) {
       Optional<User> user = userRepository.findByEmail(email);

       if (user.isEmpty()) {
           throw new BookMyTripException(ExceptionMessages.USER_NOT_FOUND);
       }

       return user.get();
    }
}
