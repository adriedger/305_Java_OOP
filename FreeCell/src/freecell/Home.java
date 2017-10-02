/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class Home extends Cell {
    
    public Home(String name){
       super(new ArrayList<>(), name);
    }
    
    public boolean isComplete(){
        return super.getSize() == 13;
    }
    @Override
    public boolean canMoveTo(Card moving){
        if(super.isEmpty()){
            return moving.getRank().getValue() == 1;
        }
        return super.getTop().getRank().isNextLess(moving) && super.getTop().getSuit().isSameSuit(moving);
    }
}
