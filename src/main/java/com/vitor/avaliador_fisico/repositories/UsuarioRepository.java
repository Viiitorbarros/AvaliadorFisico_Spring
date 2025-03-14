package com.vitor.avaliador_fisico.repositories;


import com.vitor.avaliador_fisico.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // DIZER QUE É UM REPOSITORY
public interface UsuarioRepository extends JpaRepository<Usuario , Long> {


}
