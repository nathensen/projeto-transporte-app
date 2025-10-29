package com.transporte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.transporte.config.ConnectionFactory;
import com.transporte.entity.Motorista;

public class MotoristaDAO {

    /**
     * Insere um novo Motorista no banco de dados.
     * Operação CREAT-CRUD
     */
    public void inserir(Motorista motorista) {
        String sql = "INSERT INTO Motorista (nome, cpf) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionFactory.getConnection(); // 🌟 Obtém a conexão
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, motorista.getNome());
            stmt.setString(2, motorista.getCpf());
            stmt.executeUpdate(); // Executa a inserção
            System.out.println("Motorista inserido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Motorista.", e);
        } finally {
            // Garante o fechamento dos recursos
            ConnectionFactory.closeConnection(conn);
        }
    }

    /**
     * Busca todos os Motoristas.
     */
    public List<Motorista> buscarTodos() {
        String sql = "SELECT id_motorista, nome, cpf FROM Motorista";
        List<Motorista> motoristas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(); // Executa a consulta

            while (rs.next()) {
                Motorista m = new Motorista();
                m.setIdMotorista(rs.getInt("id_motorista"));
                m.setNome(rs.getString("nome"));
                m.setCpf(rs.getString("cpf"));
                motoristas.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Motoristas.", e);
        } finally {
            // Fechar RS, STMT, CONN (boas práticas)
            ConnectionFactory.closeConnection(conn);
        }
        return motoristas;
    }
    // Exercício:
    // Implementar buscarPorId, atualizar, deletar
}