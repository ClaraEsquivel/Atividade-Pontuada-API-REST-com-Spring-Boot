package com.senai.Atividade_Pontuada_API_REST_com_Spring_Boot.service;

import com.senai.Atividade_Pontuada_API_REST_com_Spring_Boot.exception.EmailJaCadastradoException;
import com.senai.Atividade_Pontuada_API_REST_com_Spring_Boot.model.Funcionario;
import com.senai.Atividade_Pontuada_API_REST_com_Spring_Boot.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarTodos(){
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(@Valid Funcionario funcionario){
        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()){
            throw new EmailJaCadastradoException("Funcionário já cadastrado. Um funcionário já foi cadastrado com esse e-mail, utilize outro e-mail para se cadastrar.");
        }
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(@Valid Funcionario funcionario){
        Funcionario funcionarioAtualizar = funcionarioRepository.findByEmail(funcionario.getEmail())
                .orElseThrow(() -> new IllegalArgumentException(("Funcionário não encontrado.")));

        funcionarioAtualizar.setNome((funcionario.getNome()));
        funcionarioAtualizar.setCpf((funcionario.getCpf()));
        funcionarioAtualizar.setDataNascimento((funcionario.getDataNascimento()));
        funcionarioAtualizar.setEmail((funcionario.getEmail()));
        funcionarioAtualizar.setSalario((funcionario.getSalario()));
        funcionarioAtualizar.setSexo((funcionario.getSexo()));
        funcionarioAtualizar.setSetor((funcionario.getSetor()));
        funcionarioAtualizar.setEstadoCivil((funcionario.getEstadoCivil()));
        funcionarioAtualizar.setEndereco((funcionario.getEndereco()));

        return funcionarioRepository.save(funcionarioAtualizar);
    }

    public void excluir(Long id){
        Funcionario funcionarioExcluir = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException ("Funcionário não encontrado. Esse usuário não existe ou já foi deletado."));
        funcionarioRepository.delete(funcionarioExcluir);
    }
}
