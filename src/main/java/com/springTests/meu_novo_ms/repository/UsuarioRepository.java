package com.springTests.meu_novo_ms.repository;

import com.springTests.meu_novo_ms.model.UsuarioModel;

import java.util.List;

public interface UsuarioRepository {
    void salvarUsuario(UsuarioModel usuarioModel);
    List<UsuarioModel> listaDeTodosOsUsuarios();
    UsuarioModel buscarId(Long id);
}
