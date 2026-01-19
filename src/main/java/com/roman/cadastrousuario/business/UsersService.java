package com.roman.cadastrousuario.business;

import com.roman.cadastrousuario.infrastructure.entitys.Users;
import com.roman.cadastrousuario.infrastructure.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private UsersRepository repository;

    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public void saveUsers(Users users) {
        repository.saveAndFlush(users);
    }

    public Users findByUsernameEmail(String email) {

        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado!")
        );
    }

    public void  deleteByUsernameEmail(String email) {
        repository.deleteByEmail(email);
    }

    public void updateUsersId(Integer id, Users users) {
        Users usersEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario não encontrado!"));
        Users usersUpdate = Users.builder()
                .email(users.getEmail() != null ?
                        users.getEmail() : usersEntity.getEmail())
                .nome(users.getNome() != null ? users.getNome() :
                        usersEntity.getNome())
                .id(usersEntity.getId())
                .senha(users.getSenha() != null ? users.getSenha() : usersEntity.getSenha())
                .build();

        repository.saveAndFlush(usersUpdate);
    }

    public Users findById(Integer id) { //criei esse metodo para chamar pelo id
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário com ID " + id + " não encontrado!")
        );
    }


}
