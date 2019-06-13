/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositePattern;

import java.util.Iterator;

/**
 *
 * @author Steve
 */
public class MenuItem extends MenuComponent {

    private final String name;
    private final String description;
    private final boolean vegetarian;
    private final double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print(StringBuilder sb) {
        sb.append("   ").append(getName());
        if (isVegetarian()) {
            sb.append("(v)");
        }
        sb.append(", ").append(getPrice()).append("\n");
        sb.append("    -- ").append(getDescription()).append("\n");
    }

    @Override
    public Iterator<MenuComponent> iterator() {
        return new NullMenuComponentIterator();
    }

    @Override
    public Iterator<MenuComponent> createLocalIterator() {
        return new NullMenuComponentIterator();
    }
}
