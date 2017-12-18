/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package Q4;

import java.math.BigDecimal;

/**
 *
 * @author adriedger
 */
public class Warranty extends Extras{
    private Model model;
    
    public Warranty(Model model){
        this.model = model;
    }

    @Override
    public String getDescription() {
        return model.getDescription() + ", Extended Warranty";       
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal(1000).add(model.cost());
    }
    
}
