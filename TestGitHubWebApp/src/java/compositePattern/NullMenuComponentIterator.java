/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositePattern;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Steve
 */
public class NullMenuComponentIterator implements Iterator<MenuComponent> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public MenuComponent next() {
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Iterator.remove() not supported."); //To change body of generated methods, choose Tools | Templates.
    }

}
