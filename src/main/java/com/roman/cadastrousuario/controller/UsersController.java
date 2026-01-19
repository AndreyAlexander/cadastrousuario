package com.roman.cadastrousuario.controller;

import com.roman.cadastrousuario.business.UsersService;
import com.roman.cadastrousuario.dto.request.UserRequestDTO;
import com.roman.cadastrousuario.dto.response.UserResponseDTO;
import com.roman.cadastrousuario.infrastructure.entitys.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<Void> saveUsers(@RequestBody UserRequestDTO dto) {

        //fiz a conversão pra dto
        Users user = Users.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .build();

        usersService.saveUsers(user);
        return ResponseEntity.status(201).build(); // fiz alteração aq tbm, pq 201 é melhor pra post
    }

    @GetMapping
    public ResponseEntity<UserResponseDTO> findByUsernameEmail(@RequestParam String email) {
        Users user = usersService.findByUsernameEmail(email);

        UserResponseDTO response = UserResponseDTO.builder()
                .id(user.getId())
                .nome(user.getNome())
                .email(user.getEmail())
                .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<Void> updateUsersId(@RequestParam Integer id, @RequestBody UserRequestDTO dto) {
        Users user = Users.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .build();
        usersService.updateUsersId(id, user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByUsernameEmail(@RequestParam String email) {
        usersService.deleteByUsernameEmail(email);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<UserResponseDTO> findById(@RequestParam Integer id) {
        Users user = usersService.findById(id);

        UserResponseDTO response = UserResponseDTO.builder()
                .id(user.getId())
                .nome(user.getNome())
                .email(user.getEmail())
                .build();

        return ResponseEntity.ok(response);
    }


}