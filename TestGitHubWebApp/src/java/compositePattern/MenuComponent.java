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
public abstract class MenuComponent implements Iterable<MenuComponent> {

    public void add( MenuComponent menuComponent ) {
        throw new UnsupportedOperationException();
    }

    public void remove( MenuComponent menuComponent ) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild( int i ) {
        throw new UnsupportedOperationException();
    }


    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    
    public void print( StringBuilder sb ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<MenuComponent> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<MenuComponent> createLocalIterator() {
        throw new UnsupportedOperationException();
    }
}
