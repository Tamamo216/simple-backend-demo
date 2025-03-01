package com.example.demo.controller;

import com.example.demo.dto.user.NewUserDTO;
import com.example.demo.entity.postgres.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "User", description = "User API")
public class UserController {

  private final UserService userService;

  @Operation(summary = "Get user by id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "User found"),
      @ApiResponse(responseCode = "404", description = "User not found"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable Long id) {
    return ResponseEntity.ok(new User());
  }

  @Operation(summary = "Add a new user")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "User created"),
      @ApiResponse(responseCode = "400", description = "Invalid input"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  @PostMapping("/")
  public ResponseEntity<Void> addUser(@RequestBody NewUserDTO user) {
    userService.addUser(user);
    return ResponseEntity.status(201).build();
  }

  @Operation(summary = "Update user display name")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "User updated"),
      @ApiResponse(responseCode = "400", description = "Invalid input"),
      @ApiResponse(responseCode = "404", description = "User not found"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  @PutMapping("/{email}")
  public ResponseEntity<Void> updateDisplayName(@PathVariable String email, @RequestParam String displayName) {
    userService.updateDisplayNameByEmail(displayName, email);
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Remove user by email")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "User deleted"),
      @ApiResponse(responseCode = "404", description = "User not found"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  @DeleteMapping("/{email}")
  public ResponseEntity<Void> removeUser(@PathVariable String email) {
    userService.removeUserByEmail(email);
    return ResponseEntity.noContent().build();
  }
}
