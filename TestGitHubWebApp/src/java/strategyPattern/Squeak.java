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
public class Squeak implements QuackBehaviour {

    private final Duck duck;

    public Squeak(Duck duck) {
        this.duck = duck;
    }
    
    @Override
    public void quack() {
        duck.getLogger().add("Squeak");
    }
    
}
