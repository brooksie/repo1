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
public class DinerMenu implements ObjectvilleMenu {
    
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;
    
    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        
        addItem( "Vegi BLT", "[Fakin'] BLT on wheat", true, 2.99);
        addItem( "BLT", "BLT on wheat", false, 2.99);
        addItem( "Soup of the day", "Soup of the day w/side", false, 3.99);
        addItem( "Hot dog", "Hot Dog w/fries & toppings", false, 3.05);
    }
    
    public final void addItem ( String name, String desc, boolean vegi, double price) {
        MenuItem item = new MenuItem( name, desc, vegi, price);
        if (numberOfItems >= MAX_ITEMS ) {
            System.out.println("Sorry, menu is full!");
        } else {
            menuItems[numberOfItems] = item;
            numberOfItems++;
        }
    }

//    public MenuItem[] getMenuItems() {
//        return menuItems;
//    }
//
//    public int getNumberOfItems() {
//        return numberOfItems;
//    }
    
    @Override
    public Iterator createIterator() {
        return new DinerMenuIterator(menuItems);
    }
    
    //... add as necessary
}
