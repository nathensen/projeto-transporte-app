package com.transporte.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.transporte.controller.MotoristaController;
import com.transporte.entity.Motorista;

public class MotoristaCadastroView extends JFrame {

    private final MotoristaController controller = new MotoristaController();
    
    // Componentes para Cadastro
    private JTextField txtNome;
    private JTextField txtCpf;
    private JButton btnSalvar;
    
    // Componentes para Listagem
    private JTable tblMotoristas;
    private DefaultTableModel tableModel;

    public MotoristaCadastroView() {
        super("Cadastro de Motoristas - Transporte App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Configuração do Painel de Cadastro (Norte)
        setupCadastroPanel();
        
        // Configuração do Painel de Listagem (Centro)
        setupListagemPanel();

        pack(); // Ajusta o tamanho da janela aos componentes
        setLocationRelativeTo(null); // Centraliza a janela
    }
    
    private void setupCadastroPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        
        txtNome = new JTextField(20);
        txtCpf = new JTextField(11);
        btnSalvar = new JButton("Salvar Motorista");
        
        panel.add(new JLabel("Nome:"));
        panel.add(txtNome);
        panel.add(new JLabel("CPF (11 dígitos):"));
        panel.add(txtCpf);
        panel.add(new JLabel()); // Espaço vazio para alinhar
        panel.add(btnSalvar);
        
        add(panel, BorderLayout.NORTH);
        
        // Ação do Botão
        btnSalvar.addActionListener(e -> salvarMotorista());
    }
    
    private void setupListagemPanel() {
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "CPF"}, 0);
        tblMotoristas = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tblMotoristas);
        
        add(new JLabel("Motoristas Cadastrados:"), BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
        
        carregarTabelaMotoristas();
    }
    
    private void salvarMotorista() {
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        
        try {
            // Chama o Controller, que chama o Service, que chama o Repository/DAO
            controller.salvar(nome, cpf);
            JOptionPane.showMessageDialog(this, "Motorista salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
            // Limpar campos
            txtNome.setText("");
            txtCpf.setText("");
            
            // Recarregar lista
            carregarTabelaMotoristas();
            
        } catch (IllegalArgumentException ex) {
            // Erros de validação do Service
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de Validação", JOptionPane.WARNING_MESSAGE);
        } catch (RuntimeException ex) {
            // Outros erros (ex: falha de conexão no DAO)
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getCause().getMessage(), "Erro de Persistência", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    private void carregarTabelaMotoristas() {
        // Limpa a tabela
        tableModel.setRowCount(0); 
        
        try {
            List<Motorista> motoristas = controller.listarTodos();
            for (Motorista m : motoristas) {
                tableModel.addRow(new Object[]{m.getIdMotorista(), m.getNome(), m.getCpf()});
            }
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar lista: " + ex.getCause().getMessage(), "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
        }
    }
}