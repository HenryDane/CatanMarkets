/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catanmarkets.board;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JPanel;

/**
 *
 * @author Henry Danes
 */
public class Board extends JPanel{
    private int zorth, width;
    private HexagonalGrid board;
    
    public Board(int z, int w){
        this.zorth = z;
        this.width = w;
        board = new HexagonalGrid(width, zorth, 50);
    }
    
    public void generateBoard(){
        for (HexTile h : board.tiles){
            
        }
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics gx){
        super.paintComponent(gx);
        Graphics2D g = (Graphics2D) gx.create();

        HexTile[] pgs = board.getBoard();
        for (int i = 0; i < pgs.length; i++){
            g.setColor(Color.BLACK);
            g.draw(pgs[i].p);
            switch(pgs[i].terrain){
                case CLOUD:
                    g.setColor(Color.WHITE);
                    break;
                case OCEAN:
                    g.setColor(Color.BLUE);
                    break;
            }
            g.fill(pgs[i].p);
        }
        
        g.dispose();
    }
    
    private void drawHexagon(int x, int y, int r, Graphics2D g){
        Polygon hexagon = new Polygon();
        for (int i=0; i < 7; i++)
        {
           double a = (Math.PI / 3.0 * i);
           hexagon.addPoint((int)(Math.round(x + Math.sin(a) * (r / 2))), (int)(Math.round(y + Math.cos(a) * (r / 2))));
        }
        g.drawPolygon(hexagon);
    }
}
