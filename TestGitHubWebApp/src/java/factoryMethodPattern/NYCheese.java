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
public class NYCheese extends Pizza {

    public NYCheese() {
        name = "NY Style Cheese Pizza";
        dough = "Thin crust dough";
        sauce = "Marinara sauce";
        toppings.add("Grated Reggiano Cheese");
    }
    
}
