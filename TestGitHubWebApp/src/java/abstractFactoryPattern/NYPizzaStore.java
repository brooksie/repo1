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
public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory 
                = new NYPizzaIngredientFactory();
        
        if (null == type) {
            System.out.println("Sorry, NY style " + type + " pizza is not available");
        } else switch (type) {
            case "cheese":
                pizza = new PizzaCheese(ingredientFactory);
                pizza.setName("NY Style Cheese pizza");
                break;
            case "pepperoni":
                pizza = new PizzaPepperoni(ingredientFactory);
                pizza.setName("NY Style Pepperoni pizza");
                break;
            case "clam":
                pizza = new PizzaClam(ingredientFactory);
                pizza.setName("NY Style Clam pizza");
                break;
            case "veggie":
                pizza = new PizzaVeggie(ingredientFactory);
                pizza.setName("NY Style Veggie pizza");
                break;
            default:
                System.out.println("Sorry, NY style " + type + " pizza is not available");
                break;
        }
        return pizza;
    }
    
}
