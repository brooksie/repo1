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
public class ChicagoPepperoni extends Pizza {

    public ChicagoPepperoni() {
        name = "Chicago Style Pepperoni Pizza";
        dough = "Extra thick crust dough";
        sauce = "Plum tomato sauce";
        toppings.add("Shredded Mozzarella Cheese");
        toppings.add("Pepperoni");
    }

    @Override
    void cut() {
        System.out.println("Cut the pizza into square slices");
    }
    
}
