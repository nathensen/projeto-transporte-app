package com.transporte.repository;


import java.util.List;

import com.transporte.entity.Motorista;

// Define o contrato de domínio
public interface MotoristaRepository {
    void salvar(Motorista motorista);
    List<Motorista> buscarTodos();
    Motorista buscarPorId (int id); //obs: vai retornar motorista, listar por id: método para fazer update
}

