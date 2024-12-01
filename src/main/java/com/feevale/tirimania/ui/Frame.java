/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.feevale.tirimania.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author vitoria
 */
public class Frame extends JFrame {

    private JPanel paginaAtual = new Home();
    
    public Frame() {
        paginaAtual = new Home();
        paginaAtual.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(new Home());
        this.pack();
        this.setVisible(true);
    }
    
    public void trocarPaginaAtual(JPanel novaPagina) {
        setContentPane(novaPagina);
        paginaAtual = novaPagina;  
        revalidate();             
        repaint();              
    }
}
