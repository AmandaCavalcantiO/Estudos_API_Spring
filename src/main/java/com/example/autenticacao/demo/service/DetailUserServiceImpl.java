package com.example.autenticacao.demo.service;

import com.example.autenticacao.demo.data.UserDetailData;
import com.example.autenticacao.demo.model.UserModel;
import com.example.autenticacao.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetailUserServiceImpl implements UserDetailsService {

    public DetailUserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    private final UserRepository repository;
    @Override
    public UserDetailData loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserModel> user = repository.findByLogin(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }
        return new UserDetailData(user);
    }
}
