/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactoryPattern;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Steve
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new DoughThickCrust();
    }

    @Override
    public Sauce createSauce() {
        return new Sauce() {
            @Override
            public String getName() {
                return "Plum Tomato sauce";
            }
        };
    }

    @Override
    public Cheese createCheese() {
        return new Cheese() {
            @Override
            public String getName() {
                return "Mozzarella cheese";
            }
        };
    }

    @Override
    public Collection<Veggies> createVeggies() {
        Collection<Veggies> veggies = new ArrayList();
        veggies.add(new VeggiesGarlic());
        veggies.add(new VeggiesOnion());
        veggies.add(new VeggiesMushroom());
        veggies.add(new VeggiesRedPepper());
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new PepperoniSliced();
    }

    @Override
    public Clams createClams() {
        return new Clams() {
            @Override
            public String getName() {
                return "frozen Clams";
            }
        };
    }

}
