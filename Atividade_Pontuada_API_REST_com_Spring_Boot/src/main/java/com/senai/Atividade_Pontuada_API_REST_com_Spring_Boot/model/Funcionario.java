package com.senai.Atividade_Pontuada_API_REST_com_Spring_Boot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório.")
    @Size(min = 11, max = 11, message = "O CPF deve ter apenas 11 caracteres sem contar o '.' e o '-' .")
    private String cpf;

    @NotBlank(message = "A data de nascimento é obrigatória.")
    private String dataNascimento;

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email deve ser válido")
    private String email;

    private double salario;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    private Setor setor;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String cpf, String dataNascimento, String email, double salario,
                       Sexo sexo, Setor setor, EstadoCivil estadoCivil, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.salario = salario;
        this.sexo = sexo;
        this.setor = setor;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O nome é obrigatório.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O CPF é obrigatório.") @Size(min = 11, max = 11, message = "O CPF deve ter apenas 11 caracteres sem contar o '.' e o '-' .") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank(message = "O CPF é obrigatório.") @Size(min = 11, max = 11, message = "O CPF deve ter apenas 11 caracteres sem contar o '.' e o '-' .") String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank(message = "A data de nascimento é obrigatória.") String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotBlank(message = "A data de nascimento é obrigatória.") String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotBlank(message = "O email é obrigatório.") @Email(message = "O email deve ser válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O email é obrigatório.") @Email(message = "O email deve ser válido") String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", email='" + email + '\'' +
                ", salario=" + salario +
                ", sexo=" + sexo +
                ", setor=" + setor +
                ", estadoCivil=" + estadoCivil +
                ", endereco=" + endereco +
                '}';
    }
}
