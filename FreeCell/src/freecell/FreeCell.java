/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Andre
 */
public class FreeCell {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();
        for(Rank r : Rank.values()){
            for(Suit s : Suit.values()){
                Card current = new Card(r, s);
                deck.add(current);
            }
        }
        Collections.shuffle(deck);
//        for(Card c : deck){
//            c.print();            
//        }
        List<Tableau> Tabs = new ArrayList<>();
        Tabs.add(new Tableau(deck.subList(0, 7), "T0"));
        Tabs.add(new Tableau(deck.subList(7, 14), "T1"));
        Tabs.add(new Tableau(deck.subList(14, 21), "T2"));
        Tabs.add(new Tableau(deck.subList(21, 28), "T3"));
        Tabs.add(new Tableau(deck.subList(28, 34), "T4"));
        Tabs.add(new Tableau(deck.subList(34, 40), "T5"));
        Tabs.add(new Tableau(deck.subList(40, 46), "T6"));
        Tabs.add(new Tableau(deck.subList(46, 52), "T7"));
        
        List<Free> Frees = new ArrayList<>();
        Frees.add(new Free("F0"));
        Frees.add(new Free("F1"));
        Frees.add(new Free("F2"));
        Frees.add(new Free("F3"));
        
        for(Tableau t : Tabs){
            System.out.println(t.getName() + "----" + t.getSize()); 
            t.printStack();                      
        }
        for(Free f : Frees){
            System.out.println(f.getName() + "----" + f.getSize()); 
            f.printStack();                      
        }        
    }
}
