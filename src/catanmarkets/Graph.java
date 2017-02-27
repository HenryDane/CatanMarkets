/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catanmarkets;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import static java.lang.Double.NaN;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Henry Danes
 */
public class Graph extends javax.swing.JPanel{
    public final int factor = 35;
    public ArrayList<Data> data;
    public Data compiled;
    public ArrayList<Data> parsed;
    public int x = 0;
    public int j = 0;
    public int ybrick = 0;
    public int ystone = 0;
    public int ywheat = 0;
    public int ysheep = 0;
    public int ywood = 0;
        
    public Graph(Data d){
        compiled = new Data(0.0,0.0,0.0,0.0,0.0);
        data = new ArrayList<>();
        data.add(d);
        parsed = new ArrayList<>();
        parsed.add(d);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(317,200));
        this.setMinimumSize(this.getPreferredSize());
    }
    
    @Override
    public void paintComponent(Graphics gg){
        //Pre draw code
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg.create();
        g.setStroke(new BasicStroke(3));
                
        // Draw
        if ((parsed.size() - 1) <= (factor - 1)){
            for (int i = 0; i < parsed.size() - 1; i++){
                g.setColor(Color.RED);
                g.drawLine((getSize().width/factor) * i, valueToVertical(parsed.get(i).brick()), (getSize().width/factor) * (i+1), valueToVertical(parsed.get(i + 1).brick()));
                g.setColor(Color.GREEN);
                g.drawLine((getSize().width/factor) * i, valueToVertical(parsed.get(i).sheep()), (getSize().width/factor) * (i+1), valueToVertical(parsed.get(i + 1).sheep()));
                g.setColor(Color.BLACK);
                g.drawLine((getSize().width/factor) * i, valueToVertical(parsed.get(i).stone()), (getSize().width/factor) * (i+1), valueToVertical(parsed.get(i + 1).stone()));
                g.setColor(Color.YELLOW);
                g.drawLine((getSize().width/factor) * i, valueToVertical(parsed.get(i).wheat()), (getSize().width/factor) * (i+1), valueToVertical(parsed.get(i + 1).wheat()));
                g.setColor(Color.ORANGE);
                g.drawLine((getSize().width/factor) * i, valueToVertical(parsed.get(i).wood()), (getSize().width/factor) * (i+1), valueToVertical(parsed.get(i + 1).wood()));
            }
        } else {
            j = 0;
            for (int i = parsed.size() - factor; i < parsed.size() - 1; i++){
                j++;
                
                System.out.println(j);
                g.setColor(Color.RED);
                g.drawLine((getSize().width/factor) * j, valueToVertical(parsed.get(i).brick()), (getSize().width/factor) * (j+1), valueToVertical(parsed.get(i + 1).brick()));
                g.setColor(Color.green);
                g.drawLine((getSize().width/factor) * j, valueToVertical(parsed.get(i).sheep()), (getSize().width/factor) * (j+1), valueToVertical(parsed.get(i + 1).sheep()));
                g.setColor(Color.BLACK);
                g.drawLine((getSize().width/factor) * j, valueToVertical(parsed.get(i).stone()), (getSize().width/factor) * (j+1), valueToVertical(parsed.get(i + 1).stone()));
                g.setColor(Color.YELLOW);
                g.drawLine((getSize().width/factor) * j, valueToVertical(parsed.get(i).wheat()), (getSize().width/factor) * (j+1), valueToVertical(parsed.get(i + 1).wheat()));
                g.setColor(Color.ORANGE);
                g.drawLine((getSize().width/factor) * j, valueToVertical(parsed.get(i).wood()), (getSize().width/factor) * (j+1), valueToVertical(parsed.get(i + 1).wood()));
            }
        }
        
        //End
        g.dispose();
    }
    
    public void addData(Data d){
        Data t = parsed.get(parsed.size() - 1);
//        System.out.println("{DATA} T: " + t.brick);
//        System.out.println("{DATA} D: " + d.brick);
        Data dx = new Data(0.0,0.0,0.0,0.0,0.0);
        parsed.add(dx._add(t,d));
//        System.out.println("{DATA} T: " + t.brick);

        repaint();
    }
    
    private int valueToVertical(double val){
        if (Double.isNaN(val)){
            val = 0;
        }
        int a = (int) (getSize().height - ((getSize().height * val)/100));
        if (Double.isInfinite(val)){
            return 0;
        }
        return a;
    }
    
    public ArrayList<Data> getData(){
//        System.out.println("=======================");
//        System.out.println("= GET DATA            =");
//        for(Data d : parsed){
//            System.out.println("====" + d.toString() + "====");
//            System.out.println("BRICK: " + d.brick + "  WORTH: " + d.brick());
//            System.out.println("WHEAT: " + d.wheat + "  WORTH: " + d.wheat());
//            System.out.println("STONE: " + d.stone + "  WORTH: " + d.stone());
//            System.out.println("SHEEP: " + d.sheep + "  WORTH: " + d.sheep());
//            System.out.println("WOOD: " + d.wood + "  WORTH: " + d.wood());
//        }
//        System.out.println();
        return parsed;
    }
    
    public Data getCompiled(){
        return compiled;
    }
}

