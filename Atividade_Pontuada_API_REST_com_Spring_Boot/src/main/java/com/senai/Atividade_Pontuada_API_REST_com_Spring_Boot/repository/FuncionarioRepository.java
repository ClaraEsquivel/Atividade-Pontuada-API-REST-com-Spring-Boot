package com.senai.Atividade_Pontuada_API_REST_com_Spring_Boot.repository;

import com.senai.Atividade_Pontuada_API_REST_com_Spring_Boot.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByEmail(String email);
}
