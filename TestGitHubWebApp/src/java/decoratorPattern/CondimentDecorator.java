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
public abstract class CondimentDecorator extends Beverage {
    
    //protected Beverage beverage;
    
    // require that all decorators reimplement the getDescription method again.
    @Override
    public abstract String getDescription();
    
}
