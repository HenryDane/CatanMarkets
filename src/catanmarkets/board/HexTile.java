/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catanmarkets.board;

import java.awt.Polygon;

/**
 *
 * @author Henry Danes
 */
public class HexTile {
    public int radius;
    public Terrain terrain;
    /*
       0 1
      2 X 3
       4 5 
    */
    private int[] neighbors;
    public Polygon p;
    int x, y;
    
    public HexTile(int r, Terrain t, int index, int xp, int zp){
        this.radius = r;
        this.terrain = t;
        this.neighbors = null;
        
        this.x = xp;
        this.y = zp;
        
        p = new Polygon();
        for (int i=0; i < 7; i++)
        {
           double a = (Math.PI / 3.0 * i);
           p.addPoint((int)(Math.round(x + Math.sin(a) * (radius / 2))), (int)(Math.round(y + Math.cos(a) * (radius / 2))));
        }
    }
    
    public HexTile(int r, Terrain t, int[] n){
        this.terrain = t;
        this.neighbors = n;
        this.radius = r;
    }
}
