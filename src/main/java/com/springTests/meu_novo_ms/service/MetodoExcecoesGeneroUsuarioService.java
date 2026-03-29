package com.springTests.meu_novo_ms.service;

import com.springTests.meu_novo_ms.model.UsuarioModel;
import org.springframework.stereotype.Service;

@Service
public class MetodoExcecoesGeneroUsuarioService {

    public void validaoGeneroUsuario(UsuarioModel usuarioModel) throws IllegalArgumentException{
        if (!(usuarioModel.getGenero().matches("^[a-zA-Z\\s]+$"))){
            throw new IllegalArgumentException("---AVISO--- \n\nO campo gênero só deve conter letras!");
        }
    }
}
