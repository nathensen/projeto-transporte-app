package com.transporte.entity;

public class Motorista {
    private int idMotorista;
    private String nome;
    private String cpf;

    public Motorista() {}
    
    // Construtor completo
    public Motorista(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
    // Construtor para hidratação de FKs
    public Motorista(int idMotorista) {
        this.idMotorista = idMotorista;
    }

    // Getters e Setters
    public int getIdMotorista() { return idMotorista; }
    public void setIdMotorista(int idMotorista) { this.idMotorista = idMotorista; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    @Override
    public String toString() {
        return "Motorista [id=" + idMotorista + ", nome=" + nome + "]";
    }
}