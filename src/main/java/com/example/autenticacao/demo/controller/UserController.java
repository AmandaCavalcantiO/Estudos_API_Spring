package com.example.autenticacao.demo.controller;

import com.example.autenticacao.demo.model.UserModel;
import com.example.autenticacao.demo.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserController(UserRepository repository, PasswordEncoder encoder ) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> listAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/user/register")
    public ResponseEntity<UserModel> save(@RequestBody UserModel user){
        user.setPassword(encoder.encode(user.getPassword()));

        return ResponseEntity.ok(repository.save(user));
    }


}
