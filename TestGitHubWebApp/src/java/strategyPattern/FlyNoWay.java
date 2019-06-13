/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategyPattern;

/**
 *
 * @author Steve
 */
public class FlyNoWay implements FlyBehaviour {
    
    private final Duck duck;

    public FlyNoWay(Duck duck) {
        this.duck = duck;
    }
    
    @Override
    public void fly() {
        //System.out.println("I can't fly");
        duck.getLogger().add("I can't fly :(");
    }
    
}
