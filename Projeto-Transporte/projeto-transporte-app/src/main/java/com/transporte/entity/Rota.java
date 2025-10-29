package com.transporte.entity;

public class Rota {
    private int idRota;
    private String origem;
    private String destino;
    private Motorista motorista; 
    private Onibus onibus;       

    public Rota() {}

    public Rota(String origem, String destino, Motorista motorista, Onibus onibus) {
        this.origem = origem;
        this.destino = destino;
        this.motorista = motorista;
        this.onibus = onibus;
    }

    // Getters e Setters
    public int getIdRota() { return idRota; }
    public void setIdRota(int idRota) { this.idRota = idRota; }
    public String getOrigem() { return origem; }
    public void setOrigem(String origem) { this.origem = origem; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    public Motorista getMotorista() { return motorista; }
    public void setMotorista(Motorista motorista) { this.motorista = motorista; }
    public Onibus getOnibus() { return onibus; }
    public void setOnibus(Onibus onibus) { this.onibus = onibus; }
    
    @Override
    public String toString() {
        return "Rota [id=" + idRota + ", origem=" + origem + 
               ", destino=" + destino + ", motorista=" + motorista.getNome() + 
               ", onibus=" + onibus.getPlaca() + "]";
    }
}