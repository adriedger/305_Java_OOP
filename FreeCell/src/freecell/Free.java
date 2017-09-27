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
public class Free extends Cell {
    
    public Free(String name){
       super(new ArrayList<>(), name);
    }
    
    @Override
    public boolean canMoveFrom(){
        return super.getSize() > 0;        
    }
    @Override
    public boolean canMoveTo(Card moving){
        return super.isEmpty();
    }
}
