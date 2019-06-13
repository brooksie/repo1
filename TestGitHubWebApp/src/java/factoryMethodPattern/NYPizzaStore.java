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
public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        
        if ( "cheese".equals(type) ) {
            return new NYCheese();
        }
        if ( "pepperoni".equals(type) ) {
            return new NYPepperoni();
        }
        System.out.println("Sorry, " + type + " pizza is not available in this style");
        return null;
    }
    
}
