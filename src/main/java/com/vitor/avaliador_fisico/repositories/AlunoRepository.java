package com.vitor.avaliador_fisico.repositories;

import com.vitor.avaliador_fisico.models.Aluno;
import com.vitor.avaliador_fisico.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//
public interface AlunoRepository extends JpaRepository<Aluno, Long> {



}
