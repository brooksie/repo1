/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactoryPattern;

import java.util.Collection;

/**
 *
 * @author Steve
 */
public abstract class Pizza {

    String name;
    Dough dough;
    Sauce sauce;
    Collection<Veggies> veggies;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;
    
    abstract void prepare();
    
//    void prepare() {
//        System.out.println("Preparing " + name);
//        System.out.println("Toss the " + dough);
//        System.out.println("Add the " + sauce);
//        System.out.println("Add the toppings:");
//        for (String topping : toppings) {
//            System.out.println("    " + topping);
//        }
//    }
    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }
    void cut() {
        System.out.println("Cut the pizza into diagonal slices");
    }
    void box() {
        System.out.println("Place pizza into official PizzaStore box");
    }
    
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        // add code to print pizza
        return "pizza";
    }
    
}
