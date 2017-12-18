/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package Q4;

import java.math.BigDecimal;

/**
 *
 * @author adriedger
 */
public class Security extends Extras{
    private Model model;
    
    public Security(Model model){
        this.model = model;
    }

    @Override
    public String getDescription() {
        return model.getDescription() + ", Security Package";        
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal(500).add(model.cost());
    }
    
}

