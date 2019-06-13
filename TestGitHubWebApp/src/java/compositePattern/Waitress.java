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
public class Waitress {

    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public String printMenu() {
        StringBuilder sb = new StringBuilder();
        allMenus.print(sb);
        return sb.toString();
    }

    public String printVegitarianMenu() {
        // using generics and the advanced FOR-loop 
        StringBuilder sb = new StringBuilder();
        for (MenuComponent menuComponent : allMenus) {
            if (menuComponent instanceof MenuItem) {
                if (menuComponent.isVegetarian()) {
                    menuComponent.print(sb);
                }
            } else {
                sb.append( menuComponent.getName()).append("\n");
            }
        }
        return sb.toString();
    }

    public String printVegitarianMenu2() {
        // using the iterator explicitly
        StringBuilder sb = new StringBuilder();
        
        Iterator iterator = allMenus.iterator();
        
        while (iterator.hasNext() ) {
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            if (menuComponent instanceof MenuItem) {
                if (menuComponent.isVegetarian()) {
                    menuComponent.print(sb);
                }
            } else {
                sb.append( menuComponent.getName()).append("\n");
            }
        }
        return sb.toString();
    }

}
