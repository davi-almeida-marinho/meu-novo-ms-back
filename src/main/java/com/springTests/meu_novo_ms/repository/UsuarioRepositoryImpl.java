package com.springTests.meu_novo_ms.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import com.springTests.meu_novo_ms.model.UsuarioModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;   //JEITO de chamar este objeto do spring que tem como função conversar com o banco

    @Override
    @Transactional
    public void salvarUsuario(UsuarioModel usuarioModel) {

        String sql = "INSERT INTO t_usuarios (nome_usuario, idade_usuario, genero_usuario ,senha_usuario) VALUES (?, ?, ?, ?)";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1, usuarioModel.getNome());
        query.setParameter(2, usuarioModel.getIdade());
        query.setParameter(3, usuarioModel.getGenero());
        query.setParameter(4, usuarioModel.getSenha());

        query.executeUpdate();
    }

    @Override
    public List<UsuarioModel> listaDeTodosOsUsuarios() {
        String sql = "SELECT * FROM UsuarioModel um";
        return entityManager.createNativeQuery(sql, UsuarioModel.class).getResultList();
    }

    @Override
    public UsuarioModel buscarId(Long id) {
        String sql = "SELECT * FROM t_usuarios WHERE id = ?";
        try {
            Query query = entityManager.createNativeQuery(sql, UsuarioModel.class);
            query.setParameter(1, id);
            return (UsuarioModel) query.getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null;

        }
    }
}