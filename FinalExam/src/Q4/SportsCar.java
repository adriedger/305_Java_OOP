/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package Q4;

import java.math.BigDecimal;

/**
 *
 * @author adriedger
 */
public class SportsCar extends Model{
    
    public SportsCar(){
        setDescription("Sports Car");
    }

    @Override
    public BigDecimal cost() {
        return super.base.add(new BigDecimal(15000));
    }
    
}