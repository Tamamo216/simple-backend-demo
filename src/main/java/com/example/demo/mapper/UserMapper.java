package com.example.demo.mapper;

import com.example.demo.dto.user.NewUserDTO;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.postgres.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserDTO toUserDto(User user);
  User toUser(UserDTO userDTO);

  NewUserDTO toNewUserDto(User user);
  User toUser(NewUserDTO newUserDTO);
}
