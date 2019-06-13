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
public class NYPepperoni extends Pizza {

    public NYPepperoni() {
        name = "NY Style Pepperoni Pizza";
        dough = "Thin crust dough";
        sauce = "Marinara sauce";
        toppings.add("Pepperoni");
        toppings.add("Grated Reggiano Cheese");
    }
    
}
