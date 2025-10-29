package com.transporte.service;

import java.util.List;

import com.transporte.entity.Motorista;
import com.transporte.repository.MotoristaRepository;
import com.transporte.repository.MotoristaRepositoryImpl;

// Contém as Regras de Negócio e Validações
public class MotoristaService {
    
    private final MotoristaRepository repository = new MotoristaRepositoryImpl();

    public void salvarMotorista(String nome, String cpf) {
        // Validação da Regra de Negócio
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do motorista é obrigatório.");
        }
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("O CPF deve conter 11 dígitos.");
        }
        
        // Pode haver lógica para formatar ou validar CPF no banco
        Motorista motorista = new Motorista(nome, cpf);
        
        repository.salvar(motorista); 
    }

    public List<Motorista> buscarTodos() {
        // Lógica de negócio (ex: ordenar, filtrar, etc.)
        return repository.buscarTodos();
    }
}