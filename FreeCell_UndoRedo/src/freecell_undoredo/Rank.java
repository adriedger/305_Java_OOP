/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package freecell_undoredo;

/**
 *
 * @author Andre Driedger
 * Rank enum of playing card ranks and their corresponding symbols
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
    
    /**
     * @param compare Card to check if it is the next less rank
     * @return true if next less rank
     */
    public boolean isNextLess(Card compare) {
        return this.getValue() == (compare.getRank().getValue()-1);
    }  
}
