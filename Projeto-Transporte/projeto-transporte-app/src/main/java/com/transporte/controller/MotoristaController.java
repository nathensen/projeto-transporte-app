package com.transporte.controller;

import java.util.List;

import com.transporte.entity.Motorista;
import com.transporte.service.MotoristaService;

// Intermediário entre a View e o Service
public class MotoristaController {

    private final MotoristaService service = new MotoristaService();

    public void salvar(String nome, String cpf) {
        service.salvarMotorista(nome, cpf); 
    }

    public List<Motorista> listarTodos() {
        return service.buscarTodos();
    }
}