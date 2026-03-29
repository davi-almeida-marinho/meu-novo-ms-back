package com.springTests.meu_novo_ms.service;

import com.springTests.meu_novo_ms.model.UsuarioModel;
import org.springframework.stereotype.Service;

@Service
public class MetodoExcecosIdadeUsuarioService {

    public void validaIdadeDoUsuario(UsuarioModel usuarioModel) throws IllegalArgumentException{
        String conversaoIdadeDoUsuario = String.valueOf(usuarioModel.getIdade());
        if (!(conversaoIdadeDoUsuario.matches("^[0-9]+$"))){
            throw new IllegalArgumentException("---AVISO--- \n\nO campo idade só aceita números");
        }
        if (usuarioModel.getIdade() <= 0){
            throw new IllegalArgumentException("---AVISO--- \n\nO campo idade deve conter uma idade maior que zero");
        }
        if (usuarioModel.getIdade() > 116){
            throw new IllegalArgumentException("---AVISO--- \n\nO campo idade deve conter uma idade menor que 116, pois a pessoa mais velha do mundo atualmente tem 116 anos!");
        }

    }
}
