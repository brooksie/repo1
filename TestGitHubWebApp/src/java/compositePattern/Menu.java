/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositePattern;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Steve
 */
public class Menu extends MenuComponent {

    private final ArrayList<MenuComponent> menuComponents = new ArrayList<>();
    private final String name;
    private final String description;
    private Iterator iterator = null;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
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
    public void print( StringBuilder sb) {
        sb.append("\n").append(name);
        sb.append(", ").append(description).append("\n");
        for ( int i = 0; i < name.length(); i++) {
            sb.append("=");
        }
        sb.append("\n");
        
        // iterate through all the memnbers and print them too!
        for ( MenuComponent mc : menuComponents ) {
            mc.print( sb );
        }
    }

    // standard iterator to iterate over the whole tree (except the parent node)
    // Supports advances for loop
    @Override
    public Iterator<MenuComponent> iterator() {
        return new MenuComponentIterator( menuComponents.iterator() );
    }

    // local iterator that just iterates over the local Arraylist 
    // that forms the next level down. This is used by the composite iterator
    @Override
    public Iterator<MenuComponent> createLocalIterator() {
        return menuComponents.iterator();
    }

    
}
