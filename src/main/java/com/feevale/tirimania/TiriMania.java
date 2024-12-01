/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.feevale.tirimania;

import com.feevale.tirimania.ui.Frame;
import javax.swing.JPanel;

/**
 *
 * @author vitoria
 */
public class TiriMania {    
    private static Frame frame ;

    public static void main(String[] args) {
        frame = new Frame();
    }
    
    public static void trocarTela(JPanel novaTela){
        frame.trocarPaginaAtual(novaTela);
    }
}
