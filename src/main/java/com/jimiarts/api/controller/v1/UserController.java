package com.jimiarts.api.controller.v1;

import com.jimiarts.api.model.User;
import com.jimiarts.api.spring.ResponseObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/user")
@Slf4j
public class UserController {
    @PostMapping
    public ResponseEntity<ResponseObject<User>> create(
            @Validated @RequestBody User user,
            BindingResult bindingResult) {
        ResponseObject<User> userResponseObject = new ResponseObject<>(user);

        if (bindingResult.hasErrors()) {
            userResponseObject.setFieldErrors(bindingResult);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userResponseObject);
        }
        return ResponseEntity.ok(userResponseObject);
    }
}
