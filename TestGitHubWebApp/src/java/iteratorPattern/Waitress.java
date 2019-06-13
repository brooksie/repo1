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
public class Waitress {

    ObjectvilleMenu pancakeHouseMenu;
    ObjectvilleMenu dinerMenu;

    public Waitress(ObjectvilleMenu pancakeHouseMenu, ObjectvilleMenu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public String printMenu() {
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinerIterator = dinerMenu.createIterator();
        StringBuilder sb = new StringBuilder();

        sb.append("BREAKFAST MENU\n");
        sb.append(printMenu(pancakeIterator));
        sb.append("\nLUNCH MENU\n");
        sb.append(printMenu(dinerIterator));
        return sb.toString();
    }

    private String printMenu(Iterator iterator) {
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            MenuItem item = (MenuItem) iterator.next();
            sb.append(item.getName())
                    .append((item.isVegetarian()) ? "(v)" : "")
                    .append(" -- ").append(item.getDescription())
                    .append("\t").append(item.getPrice())
                    .append("\n");
        }
        return sb.toString();
    }

}
