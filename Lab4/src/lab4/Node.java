/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package lab4;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author adriedger
 */
public class Node {
    private String word;
    private Set<String> list;
    private int distance;
    
    public Node(String word){
        this.word = word;
        this.list = new HashSet<>();
        this.distance = 1000000;
    }
    
    public void add(String word){this.list.add(word);}
    
    @Override
    public String toString(){
        String output = " [";
        for(String s : this.list){
            output += s + ", ";
        }
        return output + "]";
    }
    
    public void setDistance(int dist){this.distance = dist;}
    
    public int getDistance(){return this.distance;}

    public String getWord(){return this.word;}
    
    public Set<String> getList(){return this.list;}
}
