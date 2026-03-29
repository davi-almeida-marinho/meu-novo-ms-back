package com.springTests.meu_novo_ms.service;

import com.springTests.meu_novo_ms.model.UsuarioModel;
import org.springframework.stereotype.Service;

@Service
public class MetodoExcecaoSenhaUsuarioService {

    public void validaSenhaUsuario(UsuarioModel usuarioModel) throws IllegalArgumentException{
        if (usuarioModel.getSenha().length() == 1){
            throw new IllegalArgumentException("---AVISO--- \n\nO campo senha não deve conter apenas 1 caracter!");
        }
    }


}
