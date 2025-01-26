package com.example.k8s.autoscaling;

import com.example.k8s.autoscaling.User.Builder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public UserDto createUser(UserCreateDto userDto) {
    Builder builder = new Builder(passwordEncoder);
    User user = builder
        .firstName(userDto.getFirstName())
        .lastName(userDto.getLastName())
        .password(userDto.getPassword())
        .build();

    userRepository.save(user);
    return new UserDto(user.getId(), user.getFirstName(), user.getLastName());
  }

  public UserDto findUser(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));

    return new UserDto(user.getId(), user.getFirstName(), user.getLastName());
  }
}
