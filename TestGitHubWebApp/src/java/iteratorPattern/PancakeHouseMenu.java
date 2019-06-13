/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Steve
 */
public class PancakeHouseMenu implements ObjectvilleMenu {
    
    ArrayList menuItems;
    
    public PancakeHouseMenu() {
        menuItems = new ArrayList();
        
        addItem( "Pancake Egg Breakfast", "Pancakes w/scrambled eggs & toast", true, 2.99);
        addItem( "Pancake Regular Breakfast", "Pancakes w/scrambled eggs & sausage", false, 2.99);
        addItem( "Blueberry Pancakes", "2 Pancakes w/blueberries", true, 3.49);
        addItem( "Waffles", "2 Waffles w/choice of toppings", true, 3.59);
    }
    
    public final void addItem ( String name, String desc, boolean vegi, double price) {
        MenuItem item = new MenuItem( name, desc, vegi, price);
        menuItems.add(item);
    }

//    public ArrayList getMenuItems() {
//        return menuItems;
//    }
    
    @Override
    public Iterator createIterator() {
        return menuItems.iterator();
    }
    //... add as necessary

}
