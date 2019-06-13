/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoratorPattern;

/**
 *
 * @author Steve
 */
public class DarkRoastBeverage extends Beverage {

    public DarkRoastBeverage() {
        description = "Most Excellent Dark Roast";
    }

    @Override
    public double cost() {
        return 0.99;
    }
    
}
