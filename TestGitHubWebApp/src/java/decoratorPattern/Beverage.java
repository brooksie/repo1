/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoratorPattern;

/**
 *
 * @author Steve
 */
public abstract class Beverage {
    
    protected String description = "undefined beverage";

    public abstract double cost();
    

    public String getDescription() {
        return description;
    }

}
