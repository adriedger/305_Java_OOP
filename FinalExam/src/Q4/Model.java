/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package Q4;

import java.math.BigDecimal;

/**
 *
 * @author adriedger
 */
public abstract class Model{
    private String description = "Unknown model";
    public BigDecimal base = new BigDecimal(15000);
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String in){
        description = in;
    }
    
    public abstract BigDecimal cost();
    
}
