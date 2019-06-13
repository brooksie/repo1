/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactoryPattern;

/**
 *
 * @author Steve
 */
public class PizzaVeggie extends Pizza {
    
    PizzaIngredientFactory ingredientFactory;

    public PizzaVeggie(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    
    @Override
    void prepare() {
        System.out.println("Preparing " + name );
        
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        //clams = ingredientFactory.createClams();
        //pepperoni = ingredientFactory.createPepperoni();
        veggies = ingredientFactory.createVeggies();
    }
    
}
