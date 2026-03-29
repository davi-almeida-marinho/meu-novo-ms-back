package com.springTests.meu_novo_ms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Setter
@Getter
@Entity
@Table(name = "t_usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Parada que identifica que a coluna é uma chave primaria
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nome_usuario")
    private String nome;

    @Column(name = "idade_usuario")
    private Integer idade;

    @Column(name = "genero_usuario")
    private String genero;

    @Column(name = "senha_usuario")
    private String senha;



    public UsuarioModel() {

    }


}
