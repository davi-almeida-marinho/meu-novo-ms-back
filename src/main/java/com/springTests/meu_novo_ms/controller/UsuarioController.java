package com.springTests.meu_novo_ms.controller;

import com.springTests.meu_novo_ms.model.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.springTests.meu_novo_ms.service.UsuarioService;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*") //Permite que o front fale com o back
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody UsuarioModel usuarioModel) {
        try {
            usuarioService.cadastroUsuario(usuarioModel);
            //201 papai
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            //400 papai
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            //500 papai
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuario(@PathVariable Long id){
        UsuarioModel usuarioModel = usuarioService.buscarPorId(id);

        if (usuarioModel != null){
            return ResponseEntity.ok(usuarioModel);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado."); // 404 papai
        }

    }

    @GetMapping("listar")
    public ResponseEntity<List<UsuarioModel>> listarUsuarios(){
        List<UsuarioModel> listaDeUsuarios = usuarioService.listaDeTodosUsuarios();

        if (listaDeUsuarios.isEmpty()){
            return ResponseEntity.noContent().build(); //204 papai nao content
        }
        return ResponseEntity.ok(listaDeUsuarios);
    }


}


