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
        
        List<Home> Homes = new ArrayList<>();
        Homes.add(new Home("H0"));
        Homes.add(new Home("H1"));
        Homes.add(new Home("H2"));
        Homes.add(new Home("H3"));
        
        for(Tableau t : Tabs){
            System.out.println(t.getName() + "----" + t.getSize()); 
            t.printStack();                      
        }
        for(Free f : Frees){
            System.out.println(f.getName() + "----" + f.getSize()); 
            f.printStack();                      
        }
        for(Home h : Homes){
            System.out.println(h.getName() + "----" + h.getSize()); 
            h.printStack();                      
        }
        Tabs.get(0).move(Frees.get(0));
        Tabs.get(0).printStack();
        System.out.println("-----");
        Frees.get(0).printStack();
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
       
        /*
        for(Tableau t : Tabs){
            System.out.println(t.getName() + "----" + t.getSize()); 
            t.printStack();                      
        }
        for(Free f : Frees){
            System.out.println(f.getName() + "----" + f.getSize()); 
            f.printStack();                      
        }
        for(Home h : Homes){
            System.out.println(h.getName() + "----" + h.getSize()); 
            h.printStack();                      
        }
        */
    }
}
