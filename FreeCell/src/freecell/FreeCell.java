/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
        while(!state.winCheck()){
            Scanner console = new Scanner(System.in);
            System.out.printf("Your move <from to>: ");
            String str1, str2;
            str1 = console.next();
            str2 = console.next();
            state.move(str1, str2);
            state.printState();
        }
       
    }
    
    
}
