package com.roman.cadastrousuario.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    private String nome;
    private String email;
    private String senha; //adc senha pois não tinha colocado antes
}