/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryMethodPattern;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Steve
 */
public abstract class Pizza {

    String name;
    String dough;
    String sauce;
    Collection<String> toppings = new ArrayList();
    
    void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Toss the " + dough);
        System.out.println("Add the " + sauce);
        System.out.println("Add the toppings:");
        for (String topping : toppings) {
            System.out.println("    " + topping);
        }
    }
    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }
    void cut() {
        System.out.println("Cut the pizza into diagonal slices");
    }
    void box() {
        System.out.println("Place pizza into official PizzaStore box");
    }
    
    public String getName() {
        return name;
    }
}
