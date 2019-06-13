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
public class FlyWithWings implements FlyBehaviour {

    private final Duck duck ;

    public FlyWithWings(Duck duck) {
        this.duck = duck;
    }
    
    
    @Override
    public void fly() {
        //System.out.println("I'm flying!");
        duck.getLogger().add("I'm flying");
    }
    
}
