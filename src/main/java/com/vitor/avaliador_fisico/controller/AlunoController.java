package com.vitor.avaliador_fisico.controller;


import com.vitor.avaliador_fisico.Service.AlunoService;
import com.vitor.avaliador_fisico.models.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Indica que essa classe expõe endpoints de API REST.
@RequestMapping("/alunos") // Define a Rota base da API
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    //Criar novo aluno

    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.savarAluno(aluno);
        return ResponseEntity.ok(novoAluno);
    }

    // Buscar um aluno pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAluno(@PathVariable Long id){
        Optional<Aluno> aluno = alunoService.buscarAlunoPorId(id);
        return aluno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    //  Listar todos os alunos
    @GetMapping
    public ResponseEntity<List<Aluno>> listarTodosAlunos(){
        List<Aluno> alunos = alunoService.listarTodosAlunos();
        return ResponseEntity.ok(alunos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado){
        try {
            Aluno aluno = alunoService.atualizarAluno(id, alunoAtualizado);
            return ResponseEntity.ok(aluno);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id){
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }


}
