package com.transporte;

import javax.swing.SwingUtilities;

import com.transporte.view.MotoristaCadastroView;

public class Main {
    
    public static void main(String[] args) {
        // Garante que a interface gráfica seja inicializada na thread de Event Dispatch (EDT)
        SwingUtilities.invokeLater(() -> {
            MotoristaCadastroView view = new MotoristaCadastroView();
            view.setVisible(true);
        });
    }
}