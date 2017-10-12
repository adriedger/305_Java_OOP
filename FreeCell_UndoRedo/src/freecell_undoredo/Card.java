/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package freecell_undoredo;

/**
 *
 * @author Andre Driedger
 * Card class has a Rank and a Suit
 */
public class Card {
    private Rank rank;
    private Suit suit;
    
    /**
     * @param suit Suit of card
     * @param rank Rank of card
     */
    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }
    
    @Override
    public String toString() {
        return rank.getSymbol() + "" + suit.getSymbol();      
    }
    public Rank getRank() {return rank;}
    public Suit getSuit() {return suit;}
    
}
