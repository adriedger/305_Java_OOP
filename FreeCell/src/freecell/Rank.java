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
public enum Rank {
    ACE('A', 1),
    TWO('2', 2),
    THREE('3', 3),
    FOUR('4', 4),
    FIVE('5', 5),
    SIX('6', 6),
    SEVEN('7', 7),
    EIGHT('8', 8),
    NINE('9', 9),
    TEN('T', 10),
    JACK('J', 11),
    QUEEN('Q', 12),
    KING('K', 13);
        
    private final char symbol;
    private final int value;
    
    Rank(char symbol, int value){
        this.symbol = symbol;
        this.value = value;
    }
    
    public char getSymbol() {return symbol;}
    public int getValue() {return value;}
    public boolean isNextLess(Card dest) {
        return dest.getRank().getValue() == (value-1);
    }
//    public boolean isNextGreater(Card dest) {
//        return dest.getRank().getValue() == (value+1);
//    }     
}
