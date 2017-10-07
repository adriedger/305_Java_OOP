/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

/**
 *
 * @author Andre
 */
public enum Suit {
    HEARTS(true, '\u2665'),
    DIAMONDS(true, '\u2666'),
    SPADES(false, '\u2660'),
    CLUBS(false, '\u2663');
    
    private final boolean isRed;    
    private final char unicode;    
    
    Suit(boolean isRed, char unicode){       
        this.isRed = isRed;
        this.unicode = unicode;
    }
    
    public boolean isRed() {return isRed;}
    public char getSymbol() {return unicode;}
    
    public boolean isDiffColor(Card dest){
        return dest.getSuit().isRed() != this.isRed();
    }
    public boolean isSameSuit(Card compare){
        return this.equals(compare.getSuit());
    }
}
