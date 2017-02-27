/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catanmarkets.board;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import catanmarkets.board.*;

/**
 *
 * @author Henry Danes
 */
public class HexagonalGrid {
    public ArrayList<HexTile> tiles;
    private int width, zorth, radius;
    
    public HexagonalGrid(int width, int zorth, int radius){
        this.width = width;
        this.zorth = zorth;
        tiles = new ArrayList<>();
        int k = 0;
        int j = 0;
        for (int i = 0; i < (width * zorth); i++){
            if ((i % width) == 0){
                j = j + radius;
            }
            k = (i % width) * radius;
            if (( k & 1) == 0){
                j = j + radius / 2;
            }
            tiles.add(new HexTile(radius, Terrain.CLOUD, i, j, k));
            if (( k & 1) == 0){
                j = j - radius / 2;
            }
        }
        this.radius = radius;
    }
    
    public Polygon getShape(int width, int zorth){
        Polygon hexagon = new Polygon();
        for (int i=0; i < 7; i++)
        {
           double a = (Math.PI / 3.0 * i);
           hexagon.addPoint((int)(Math.round(width + Math.sin(a) * (radius / 2))), (int)(Math.round(zorth + Math.cos(a) * (radius / 2))));
        }
        return hexagon;
    }
    
    public HexTile[] getBoard(){
        int size = (width * zorth);
        HexTile[] hextiles = new HexTile[size];
        for (int i = 0; i < size; i++){
            hextiles[i] = tiles.get(i);
        }
        return hextiles;
    }
    
    public void putTileAt(int width, int zorth){
        
    }
    
    public HexTile getTileByPoint(Point p){
        return null;
    }
}
