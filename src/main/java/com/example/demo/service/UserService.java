package com.example.demo.service;

import com.example.demo.dto.user.NewUserDTO;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.postgres.User;
import com.example.demo.exception.BaseAppException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.postgres.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserDTO getUserByEmail(String email) {
    User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User cannot be found"));
    return userMapper.toUserDto(user);
  }

  public void addUser(NewUserDTO userDTO) {
    try {
      User user = userMapper.toUser(userDTO);
      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      userRepository.save(user);
    }
    catch (Exception e) {
      throw new BaseAppException(e.getMessage());
    }
  }

  public void updateDisplayNameByEmail(String displayName, String email) {
    try {
      userRepository.updateDisplayNameByEmail(displayName, email);
    }
    catch (Exception e) {
      throw new BaseAppException(e.getMessage());
    }
  }

  public void removeUserByEmail(String email) {
    try {
      userRepository.removeByEmail(email);
    }
    catch (Exception e) {
      throw new BaseAppException(e.getMessage());
    }
  }

}
