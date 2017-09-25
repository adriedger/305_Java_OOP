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
public class Card {
    private Rank rank;
    private Suit suit;
    
    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }
    
    public void print() {
        System.out.println(rank.getSymbol() + " " + suit.getSymbol());      
    }
    public Rank getRank() {return rank;}
    public Suit getSuit() {return suit;}
    
}
