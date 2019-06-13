/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositePattern;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 *
 * @author Steve
 */
public class MenuComponentIterator implements Iterator<MenuComponent> {

    Stack<Iterator> stack = new Stack<>();

    public MenuComponentIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    @Override
    public MenuComponent next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Iterator iterator = stack.peek();
        MenuComponent menuComponent = (MenuComponent) iterator.next();
        //if (menuComponent instanceof Menu) {
            // important - get the local iterator (next level down only)
            stack.push(menuComponent.createLocalIterator());
        //}
        return menuComponent;
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        }
        Iterator iterator = stack.peek();
        if (iterator.hasNext()) {
            return true;
        }
        stack.pop();
        return hasNext();  // recursive call for the next level up of the stack
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Iterator.remove() not supported"); //To change body of generated methods, choose Tools | Templates.
    }
}
