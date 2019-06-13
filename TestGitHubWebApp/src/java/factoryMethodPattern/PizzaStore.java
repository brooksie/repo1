/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryMethodPattern;

/**
 *
 * @author Steve
 */
public abstract class PizzaStore {
    
    public Pizza orderPizza( String type) {
        Pizza pizza;
        
        pizza = createPizza ( type ) ;  // factory to create pizza objects
        
        if (pizza == null) {
            return null; // no point in continuing
        }
        
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        
        return pizza;
    }
    
    protected abstract Pizza createPizza ( String type );
    
}
