package com.luvina.cm.controller;

import com.luvina.cm.dto.UserDto;
import com.luvina.cm.dto.UserResDto;
import com.luvina.cm.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;

    @PostMapping("/api/v1/users")
    @ApiOperation("Create User")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Create user successfully")
    })
    public ResponseEntity<UserResDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserResDto response = userService.saveUser(userDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
