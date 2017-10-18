/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package freecell_undoredo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Andre Driedger
 * contains main function of game
 */
public class FreeCell {

    /**
     * deals cards into deck, initializes game state
     * while loop processes moves and checks for win condition
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
        Scanner console = new Scanner(System.in);
        while(!state.winCheck()){           
            System.out.printf("Your move <from to> | U to undo | R to redo: ");
            String line = console.nextLine();
            Scanner tokenizer = new Scanner(line);
            String str1 = tokenizer.next();
            if(tokenizer.hasNext()){
                String str2 = tokenizer.next();
                state.move(str1, str2);
            }
            else{
                if(str1.equals("U"))
                    state.undo();
                if(str1.equals("R"))
                    state.redo();
                if(str1.equals("0"))
                    break;
            }
            state.printState();
        }
        System.out.println("You Win!");
    }
}
