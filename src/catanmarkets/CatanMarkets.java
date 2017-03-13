package catanmarkets;

import catanmarkets.board.BoardGeneratorInterface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Henry Danes
 */
public class CatanMarkets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CatanMarketsUI cmui = new CatanMarketsUI();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                cmui.setVisible(true);
            }
        });
        System.out.println(javax.swing.UIManager.getSystemLookAndFeelClassName());
    }
    
}
