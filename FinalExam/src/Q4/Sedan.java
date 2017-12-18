/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package Q4;

import java.math.BigDecimal;

/**
 *
 * @author adriedger
 */
public class Sedan extends Model{
    
    public Sedan(){
        setDescription("Sedan");
    }

    @Override
    public BigDecimal cost() {
        return super.base.add(new BigDecimal(5000));
    }
    
}
