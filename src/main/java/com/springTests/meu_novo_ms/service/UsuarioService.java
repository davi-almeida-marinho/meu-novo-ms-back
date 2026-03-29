package com.springTests.meu_novo_ms.service;

import com.springTests.meu_novo_ms.model.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springTests.meu_novo_ms.repository.UsuarioRepositoryImpl;

import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositoryImpl usuarioRepository;

    @Autowired
    private MetodoExcecoesNomeUsuarioService metodoExcecoesNomeUsuarioService;

    @Autowired
    private MetodoExcecosIdadeUsuarioService metodoExcecosIdadeUsuarioService;

    @Autowired
    private MetodoExcecoesGeneroUsuarioService metodoExcecoesGeneroUsuarioService;

    @Autowired
    private MetodoExcecaoSenhaUsuarioService metodoExcecaoSenhaUsuarioService;

    public void cadastroUsuario(UsuarioModel usuarioModel) throws IllegalArgumentException {
        try {
            metodoExcecoesNomeUsuarioService.validacaoNomeUsuario(usuarioModel);
            metodoExcecosIdadeUsuarioService.validaIdadeDoUsuario(usuarioModel);
            metodoExcecoesGeneroUsuarioService.validaoGeneroUsuario(usuarioModel);
            metodoExcecaoSenhaUsuarioService.validaSenhaUsuario(usuarioModel);

            usuarioRepository.salvarUsuario(usuarioModel);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    public List<UsuarioModel> listaDeTodosUsuarios() throws IllegalArgumentException{
          List<UsuarioModel> usuarioModelList = usuarioRepository.listaDeTodosOsUsuarios();

          if (usuarioModelList.isEmpty()){
              throw new IllegalArgumentException("---AVISO--- \n\nLista de usuários consta - se vazia!");
          }

          return usuarioModelList;
    }

    public UsuarioModel buscarPorId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("O ID fornecido é inválido.");
        }

        UsuarioModel usuario = usuarioRepository.buscarId(id);

        if (usuario == null) {
            throw new RuntimeException("Usuário com ID " + id + " não encontrado no sistema.");
        }

        return usuario;
    }






}
