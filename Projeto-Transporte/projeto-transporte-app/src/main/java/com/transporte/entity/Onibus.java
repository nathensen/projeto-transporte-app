package com.transporte.entity;

public class Onibus {
    private int idOnibus;
    private String placa;
    private String modelo;

    public Onibus() {}
    
    // Construtor completo
    public Onibus(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }
    
    // Construtor para hidratação de FKs
    public Onibus(int idOnibus) {
        this.idOnibus = idOnibus;
    }

    // Getters e Setters
    public int getIdOnibus() { return idOnibus; }
    public void setIdOnibus(int idOnibus) { this.idOnibus = idOnibus; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
}