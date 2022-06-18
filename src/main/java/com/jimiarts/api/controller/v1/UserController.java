package com.jimiarts.api.controller.v1;

import com.jimiarts.api.model.User;
import com.jimiarts.api.service.UserService;
import com.jimiarts.api.spring.ResponseObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseObject<User>> create(
            @Validated @RequestBody User user,
            BindingResult bindingResult) {
        ResponseObject<User> userResponseObject = new ResponseObject<>(user);

        if (bindingResult.hasErrors()) {
            userResponseObject.setFieldErrors(bindingResult);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userResponseObject);
        }

        userResponseObject.setData(userService.create(user));

        return ResponseEntity.ok(userResponseObject);
    }
}
