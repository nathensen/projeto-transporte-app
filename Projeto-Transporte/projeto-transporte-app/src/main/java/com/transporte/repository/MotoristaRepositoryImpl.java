package com.transporte.repository;

import java.util.List;

import com.transporte.dao.MotoristaDAO;
import com.transporte.entity.Motorista;

// Implementação que usa o DAO
public class MotoristaRepositoryImpl implements MotoristaRepository{
    
    private final MotoristaDAO motoristaDAO = new MotoristaDAO();

    @Override
    public void salvar(Motorista motorista) {
        motoristaDAO.inserir(motorista); 
    }

    @Override
    public List<Motorista> buscarTodos() {
        return motoristaDAO.buscarTodos(); 
    }

    @Override
    public Motorista buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
