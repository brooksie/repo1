/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author Steve
 */
@Named
@ViewScoped
public class FactoryBean implements Serializable {

    private String pizzaStyle;
    private String pizzaType;

    /**
     * Creates a new instance of FactoryBean
     */
    public FactoryBean() {
    }

    @PostConstruct
    public void init() {
    }

    public String getPizzaStyle() {
        return pizzaStyle;
    }

    public void setPizzaStyle(String pizzaStyle) {
        this.pizzaStyle = pizzaStyle;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public void cook() {
        System.out.println("Style: " + pizzaStyle);
        System.out.println("Type: " + pizzaType);

        factoryMethodPattern.PizzaStore store;
        if ("NY".equals(pizzaStyle)) {
            store = new factoryMethodPattern.NYPizzaStore();
        } else if ("Chicago".equals(pizzaStyle)) {
            store = new factoryMethodPattern.ChicagoPizzaStore();
        } else {
            System.out.println("Not available in this style yet!");
            return;
        }

        store.orderPizza(pizzaType);

    }

    //*************************************************
    private String pizzaStyle2;
    private String pizzaType2;

    public String getPizzaStyle2() {
        return pizzaStyle2;
    }

    public void setPizzaStyle2(String pizzaStyle2) {
        this.pizzaStyle2 = pizzaStyle2;
    }

    public String getPizzaType2() {
        return pizzaType2;
    }

    public void setPizzaType2(String pizzaType2) {
        this.pizzaType2 = pizzaType2;
    }

    public void cook2() {
        System.out.println("Style2: " + pizzaStyle2);
        System.out.println("Type2: " + pizzaType2);

        abstractFactoryPattern.PizzaStore store;
        if ("NY".equals(pizzaStyle2)) {
            store = new abstractFactoryPattern.NYPizzaStore();
        } else if ("Chicago".equals(pizzaStyle2)) {
            store = new abstractFactoryPattern.ChicagoPizzaStore();
        } else {
            System.out.println("This style is not available: " + pizzaStyle2);
            return;
        }
        
        store.orderPizza(pizzaType2);
    }

}
