package br.com.self_employed.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.self_employed.models.Entity.UserModel;
import br.com.self_employed.services.User.UserDTO;
import br.com.self_employed.services.User.UserService;
import br.com.self_employed.utils.GeneralUtilities;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Page<UserModel>> getUsers(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<UserModel> users = userService.getUser(page, size);
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/users/signup")
    public ResponseEntity<UserModel> postUser(@RequestBody @Valid UserDTO userDTO) {
        UserModel data = userService.postUser(userDTO, "STAFF");
        return ResponseEntity.created(GeneralUtilities.toUri("/users/signup")).body(data);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<UserModel> show(@PathVariable String username) {
        UserModel user = userService.getUser(username);
        return ResponseEntity.ok(user);
    }

}
