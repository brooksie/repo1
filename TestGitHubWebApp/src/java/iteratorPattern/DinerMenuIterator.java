/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorPattern;

import java.util.Iterator;

/**
 *
 * @author Steve
 */
public class DinerMenuIterator implements Iterator {

    private final MenuItem[] menuItems;
    private int position = 0;

    public DinerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }
    
    @Override
    public boolean hasNext() {
        return !(position >= menuItems.length || menuItems[position] == null);
    }

    @Override
    public Object next() {
        MenuItem item = menuItems[position];
        position++;
        return item;
    }

    @Override
    public void remove() {
        if ( position <= 0 ) {
            throw new IllegalStateException
                    ("You can't remove an item until at least one next() has been done");
        }
        if ( menuItems[position - 1] != null ) {
            for ( int i = position -1; i < (menuItems.length - 1); i++ ) {
                menuItems[i] = menuItems[i+1];
            }
            menuItems[menuItems.length -1] = null;
        }
    }
    
}
