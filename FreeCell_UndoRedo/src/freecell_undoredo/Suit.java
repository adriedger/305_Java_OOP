/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package freecell_undoredo;

/**
 *
 * @author Andre Driedger
 * Suit enum of playing card suits and their corresponding symbols
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
    
    /**
     * @param dest Card to check if it is a different color
     * @return true if different color
     */
    public boolean isDiffColor(Card dest){
        return dest.getSuit().isRed() != this.isRed();
    }
    
    /**
     * @param compare Card to check if it is the same suit
     * @return true if its the same suit;
     */
    public boolean isSameSuit(Card compare){
        return this.equals(compare.getSuit());
    }
}
