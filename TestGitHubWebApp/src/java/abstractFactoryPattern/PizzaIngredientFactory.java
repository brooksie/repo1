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
public interface PizzaIngredientFactory {
    
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Collection<Veggies> createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClams();
    
}
