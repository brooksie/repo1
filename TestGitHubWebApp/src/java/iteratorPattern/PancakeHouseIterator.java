/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorPattern;

import java.util.ArrayList;

/**
 *
 * @author Steve
 */
public class PancakeHouseIterator implements MyIterator {

    ArrayList menuItems;
    int position = 0; 

    public PancakeHouseIterator(ArrayList menuItems) {
        this.menuItems = menuItems;
    }
    
    @Override
    public boolean hasNext() {
        return position < menuItems.size();
    }

    @Override
    public Object next() {
        MenuItem item = (MenuItem) menuItems.get(position);
        position++;
        return item;
    }
    
    
}
