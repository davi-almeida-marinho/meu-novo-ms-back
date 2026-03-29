package com.springTests.meu_novo_ms.service;

import com.springTests.meu_novo_ms.model.UsuarioModel;
import org.springframework.stereotype.Service;

@Service
public class MetodoExcecoesNomeUsuarioService {

    public void validacaoNomeUsuario(UsuarioModel usuarioModel) throws IllegalArgumentException{
        if (!(usuarioModel.getNome().matches("^[a-zA-Z\\s]+$"))){
            throw new IllegalArgumentException("---AVISO--- \n\nO campo nome só aceita letras");
        }
         if (usuarioModel.getNome().length() == 1){
             throw new IllegalArgumentException("---AVISO--- \n\nO campo nome não pode conter apenas 1 caracter");
         }
    }

}
