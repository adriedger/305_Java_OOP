/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package freecell_undoredo;

import java.util.ArrayList;
import java.util.List;

/**
 * *
 * @author Andre Driedger
 * Contains the game state -> all the cells and their methods 
 */
public class State {
    
    private List<Tableau> Tabs = new ArrayList<>();    
    private List<Free> Frees = new ArrayList<>();
    private List<Home> Homes = new ArrayList<>();
    
    /**
     * @param deck shuffled deck of 52 cards
     * All 8 Tableaus get dealt cards from deck
     */
    public State(List<Card> deck){
        Tabs.add(new Tableau(deck.subList(0, 7), "T0"));
        Tabs.add(new Tableau(deck.subList(7, 14), "T1"));
        Tabs.add(new Tableau(deck.subList(14, 21), "T2"));
        Tabs.add(new Tableau(deck.subList(21, 28), "T3"));
        Tabs.add(new Tableau(deck.subList(28, 34), "T4"));
        Tabs.add(new Tableau(deck.subList(34, 40), "T5"));
        Tabs.add(new Tableau(deck.subList(40, 46), "T6"));
        Tabs.add(new Tableau(deck.subList(46, 52), "T7"));
        Frees.add(new Free("F0"));
        Frees.add(new Free("F1"));
        Frees.add(new Free("F2"));
        Frees.add(new Free("F3"));
        Homes.add(new Home("H0"));
        Homes.add(new Home("H1"));
        Homes.add(new Home("H2"));
        Homes.add(new Home("H3"));
    }
    
    /**
     * @param name String to compare with Cell names
     * @return Cell which matches input string
     */
    private Cell getCell(String name){
        Cell cell = Homes.get(0);
        for(Tableau t: Tabs){
            if(name.equals(t.getName()))
                cell = t;        
        }
        for(Free f: Frees){
            if(name.equals(f.getName()))
                cell = f;           
        }
        for(Home h: Homes){
            if(name.equals(h.getName()))
                cell = h;            
        }
        return cell;
    }
        
    /**
     * @param origin Cell name of the move origin
     * @param dest Cell name of the destination of the move attempt
     */
    public void move(String origin, String dest){
        this.getCell(origin).move(this.getCell(dest));        
    }
    /**
     * Prints the contents of each Cell
     */
    public void printState(){       
        for(Tableau t: Tabs)
            System.out.println(t.toString());            
        for(Free f : Frees)
            System.out.println(f.toString());            
        for(Home h : Homes)
            System.out.println(h.toString());                       
    }
    /**
     * @return true if all FreeCell stacks are complete
     */
    public boolean winCheck(){
        return Homes.get(0).isComplete() && Homes.get(1).isComplete() &&
                Homes.get(2).isComplete() && Homes.get(3).isComplete();
    }
}
