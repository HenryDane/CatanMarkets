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
public enum ValueIndicator {
    UP      ("UP"),
    DOWN    ("DOWN"),
    FLAT    ("FLAT")
    ;
    
    private final String s;
    
    private ValueIndicator(String si) {
        s = si;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : s.equals(otherName);
    }

    public String toString() {
       return this.s;
    }
}
