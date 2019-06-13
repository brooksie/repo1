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
public class DecafBeverage extends Beverage{

    public DecafBeverage() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 1.05;
    }
    
}
