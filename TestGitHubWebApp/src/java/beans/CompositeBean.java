/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import compositePattern.Menu;
import compositePattern.MenuComponent;
import compositePattern.MenuItem;
import compositePattern.Waitress;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

import java.io.Serializable;
import javax.annotation.PostConstruct;


/**
 *
 * @author Steve
 */
@Named
@ViewScoped
public class CompositeBean implements Serializable {

    private Waitress waitress;
    private String printMenu = "";
    
    /** Creates a new instance of CompositeBean */
    public CompositeBean() {
    }

    @PostConstruct
    public void init() {
        MenuComponent pancakeMenu = new Menu( "PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu = new Menu( "DINER MENU", "Lunch");
        MenuComponent dessertMenu = new Menu( "DESSERT MENU", "Dessert, of course!");
        MenuComponent cafeMenu = new Menu( "CAFE MENU", "Dinner");
        MenuComponent allMenus = new Menu( "ALL MENUS", "All menus combined");
        
        allMenus.add(pancakeMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);
        
        pancakeMenu.add( new MenuItem( "Pancake Egg Breakfast", "Pancakes w/scrambled eggs & toast", true, 2.99));
        pancakeMenu.add( new MenuItem( "Pancake Regular Breakfast", "Pancakes w/scrambled eggs & sausage", false, 2.99));
        pancakeMenu.add( new MenuItem( "Blueberry Pancakes", "2 Pancakes w/blueberries", true, 3.49));
        pancakeMenu.add( new MenuItem( "Waffles", "2 Waffles w/choice of toppings", true, 3.59));
        
        dinerMenu.add( new MenuItem( "Vegi BLT", "[Fakin'] BLT on wheat", true, 2.99));
        dinerMenu.add( new MenuItem( "BLT", "BLT on wheat", false, 2.99));
        dinerMenu.add( new MenuItem( "Soup of the day", "Soup of the day w/side", false, 3.99));
        dinerMenu.add( new MenuItem( "Hot dog", "Hot Dog w/fries & toppings", false, 3.05));
        dinerMenu.add( dessertMenu );
        
        dessertMenu.add( new MenuItem( "Ice cream", "choice of flavours", true, 2.99));
        dessertMenu.add( new MenuItem( "Apple Pie", "warm, w/cream or custard", true, 3.99));
        dessertMenu.add( new MenuItem( "Sticky Toffee Pudding", "warm, w/cream or custard", false, 3.99));
        dessertMenu.add( new MenuItem( "Cheese", "locally sourced w/biscuits", true, 4.29));

        cafeMenu.add( new MenuItem( "Soup of the day", "Soup with a side salad", false, 3.69));
        cafeMenu.add( new MenuItem( "Burrito", "Burrito etc.", false, 4.29));
        cafeMenu.add( new MenuItem( "Veggie Burger and fries", "Veggie burger and stuff", true, 3.99));
        
        waitress = new Waitress(allMenus);
    }
    
    public void allMenusRequested() {
        this.printMenu = waitress.printMenu();
    }

    public void veggieMenusRequested() {
        this.printMenu = waitress.printVegitarianMenu();
    }

    public void veggieMenusRequested2() {
        this.printMenu = waitress.printVegitarianMenu2();
    }

    public String getPrintMenu() {
        return printMenu;
    }

    
}
