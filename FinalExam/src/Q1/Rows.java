/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package Q1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adriedger
 */
public class Rows {
    private List<Integer> numbers;
    private int id;

    public Rows(int id) {
        this.numbers = new ArrayList<>();
        this.id = id - 1;
        calculateRows();        
    }
    
    private void calculateRows(){
        List<Integer> start = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        for(int i = 0; i < id; i++){ // each row            
            temp = new ArrayList<>();
            temp.add(1);
            for(int j = 0; j < i; j++){ //each entry        
                temp.add(start.get(j) + start.get(j+1));
            }
            temp.add(1);
            start = temp;
//            System.out.println(i+ " " + start);          
        }
        numbers = temp;        
    }
    
    public List<Integer> getNumbers(){
        return numbers;
    }
    
}
