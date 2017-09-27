/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

import java.util.List;

/**
 *
 * @author Andre
 */
public class Tableau extends Cell {
    
    public Tableau(List<Card> start, String name) {
        super(start, name);
    }
    
    private Card getSubstackTop() {
        int count = super.getSize() - 1;
        Card current = super.getCard(count);
        Card next = super.getCard(count - 1);
        while(current.getRank().isNextLess(next) && current.getSuit().isDiffColor(next) && count!=0){
            count --;
            current = super.getCard(count);
            next = super.getCard(count - 1);                  
        }
        return current;       
    }
    
    @Override
    public boolean canMoveFrom(){
        return super.getSize() > 0;        
    }
    @Override
    public boolean canMoveTo(Card moving){
        if(super.isEmpty())
            return true;
        else if(moving.getRank().isNextLess(super.getTop()) && moving.getSuit().isDiffColor(super.getTop())){
            return true;
        }
        return false;    
    }
}
