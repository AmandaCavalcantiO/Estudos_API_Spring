package com.example.autenticacao.demo.repository;

import com.example.autenticacao.demo.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserModel, String> {

    public Optional<UserModel> findByLogin(String login);
}
