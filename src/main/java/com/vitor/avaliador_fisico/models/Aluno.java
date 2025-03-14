package com.vitor.avaliador_fisico.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome" , length = 50 , nullable = false)
    @NotNull
    @NotEmpty
    private String nome;

    @Column(name = "Peso" , nullable = false)
    @NotEmpty
    @NotNull
    private Double peso;


    @Column(name = "Altura" , nullable = false)
    @NotNull
    @NotEmpty
    private Double altura;

    @Column(name = "IMC" ,  nullable = false)
    private Double imc ;

    //GETS E SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public void calcularIMC(){
        if(peso!=null && altura!=null && altura>0){
            this.imc = peso/(altura*altura);

        }
    }

}
