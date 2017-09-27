/*
 * Macewan University CMPT 305 Professor:Brian Brookwell
 */
package freecell;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adriedger
 */
public class State {
    
    private List<Tableau> Tabs = new ArrayList<>();    
    private List<Free> Frees = new ArrayList<>();
    private List<Home> Homes = new ArrayList<>();
    
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
    
    
    public void move(String origin, String dest){
        Tabs.get(0).move(Frees.get(0));
//        Tabs.get(0).printStack();
//        System.out.println("-----");
//        Frees.get(0).printStack();
        
    }
    
    public void printState(){
        
        for(Tableau t: Tabs){
            System.out.println(t.toString());            
        }
        for(Free f : Frees){
            System.out.println(f.toString());            
        }
        for(Home h : Homes){
            System.out.println(h.toString());            
        } 
        
//        List<Tableau> TabsCopy = new ArrayList<>(Tabs);
//        System.out.println(Tabs.get(0).toString());
//        System.out.println(Tabs.get(1).toString()); 
//        System.out.println(Tabs.get(2).toString()); 
//        System.out.println(Tabs.get(3).toString()); 
//        System.out.println(Tabs.get(4).toString()); 
//        System.out.println(Tabs.get(5).toString()); 
//        System.out.println(Tabs.get(6).toString());
//        System.out.println(Tabs.get(7).toString()); 
//        System.out.println(Frees.get(0).toString());
//        System.out.println(Frees.get(1).toString()); 
//        System.out.println(Frees.get(2).toString()); 
//        System.out.println(Frees.get(3).toString());
//        System.out.println(Homes.get(0).toString());
//        System.out.println(Homes.get(1).toString());
//        System.out.println(Homes.get(2).toString());
//        System.out.println(Homes.get(3).toString());      
    }    
}
