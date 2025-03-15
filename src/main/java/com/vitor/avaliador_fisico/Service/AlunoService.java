package com.vitor.avaliador_fisico.Service;


import com.vitor.avaliador_fisico.models.Aluno;
import com.vitor.avaliador_fisico.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoService {
    @Autowired // Espécie de instanciador
    private AlunoRepository alunoRepository;

    //metodo para salvar um aluno no banco
    public Aluno savarAluno (Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // Metodo para buscar um aluno por Id
    public Aluno buscarAluno(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno nao encontrado"));

    }

    //Metodo para atualizar dados do Aluno

    public Aluno atualizarAluno(Long id, Aluno alunoAtualizado) {
        Optional<Aluno> alunoencontrado = alunoRepository.findById(id);
        if (alunoencontrado.isPresent()) {
            Aluno aluno = alunoencontrado.get();
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setPeso(alunoAtualizado.getPeso());
            aluno.setAltura(alunoAtualizado.getAltura());
            return alunoRepository.save(aluno);
        }
        throw new RuntimeException("Aluno nao encontrado");

    }

    public  void  deletarAluno(Long id) {

        Optional<Aluno> alunoencontrado = alunoRepository.findById(id);

        if (alunoencontrado.isPresent()) {
          alunoRepository.deleteById(id);
        }else {
            throw new RuntimeException("Aluno nao encontrado");
        }
    }

}
