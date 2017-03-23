/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catanmarkets;

/**
 *
 * @author Henry Danes
 */
public class Data {
    public double stone, wheat, brick, sheep, wood;
    private double total;
    
    public Data(double stone, double wheat, double brick, double sheep, double wood) {
        this.stone = stone;
        this.wheat = wheat;
        this.brick = brick;
        this.sheep = sheep;
        this.wood = wood;
        this.total = stone + wheat + brick + sheep + wood;
    }
    
    public double stone(){
        return (1 - stone/total) * 100.00;
    }
    
    public double wheat(){
        return (1 - wheat/total) * 100.00;
    }
    
    public double brick(){
        return (1 - brick/total) * 100.00;
    }
    
    public double wood(){
        return (1 - wood/total) * 100.00;
    }
    
    public double sheep(){
        return (1 - sheep/total) * 100.00;
    }
    
    public void add(Data d){
        this.brick = this.brick + d.brick;
        this.stone = this.stone + d.stone;
        this.wheat = this.wheat + d.wheat;
        this.wood = this.wood + d.wood;
        this.sheep = this.sheep + d.sheep;
        this.total = this.total + d.total;
    }
    
    public Data _add(Data a, Data b){
        Data c = new Data(0.0,0.0,0.0,0.0,0.0);
        c.brick = a.brick + b.brick;
        c.stone = a.stone + b.stone;
        c.wheat = a.wheat + b.wheat;
        c.wood = a.wood + b.wood;
        c.sheep = a.sheep + b.sheep;
        c.total = a.total + b.total;
        return c;
    }
    
    public Data _sub(Data a, Data b){
        Data c = new Data(0.0,0.0,0.0,0.0,0.0);
        c.brick = a.brick - b.brick;
        c.stone = a.stone - b.stone;
        c.wheat = a.wheat - b.wheat;
        c.wood = a.wood - b.wood;
        c.sheep = a.sheep - b.sheep;
        c.total = a.total - b.total;
        return c;
    }
}
