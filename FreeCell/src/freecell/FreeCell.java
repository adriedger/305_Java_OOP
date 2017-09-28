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
        State state = new State(deck);
        state.printState();        
        state.move("T0", "H0");
        state.printState();
        state.move("T0", "H0");
        state.printState();

        

//        Tabs.get(0).move(Frees.get(0));
//        Tabs.get(0).printStack();
//        System.out.println("-----");
//        Frees.get(0).printStack();
//        List<Tableau> oldTabs = Tabs;
//        List<Free> oldFrees = Frees;
//        Tabs.clear();
//        Tabs = new ArrayList<>(oldTabs);
//        Frees = new ArrayList<>(oldFrees);
//        System.out.println(Tabs.get(0).getClass());
//        Tableau origin = Tabs.get(0);
//        Free dest = Frees.get(0);
//        origin.move(dest);
//        Tabs.remove(0);
//        Tabs.set(0, Tabs.get(0));
//        Frees.set(0, Frees.get(0));
//        origin.printStack();
//        System.out.println("-----");
//        dest.printStack();
       
    }
    
    
}
