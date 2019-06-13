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
public class FlyRocketPowered implements FlyBehaviour {

    private final Duck duck ;

    public FlyRocketPowered(Duck duck) {
        this.duck = duck;
    }
    
    @Override
    public void fly() {
        duck.getLogger().add("I'm flying with a rocket!");
    }
    
}
