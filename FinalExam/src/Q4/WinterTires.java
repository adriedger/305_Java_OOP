/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package Q4;

import java.math.BigDecimal;

/**
 *
 * @author adriedger
 */
public class WinterTires extends Extras{
    private Model model;
    
    public WinterTires(Model model){
        this.model = model;
    }

    @Override
    public String getDescription() {
        return model.getDescription() + ", Winter Tires";       
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal(250).add(model.cost());
    }
    
}
