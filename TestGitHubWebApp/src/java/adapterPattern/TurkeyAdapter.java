/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapterPattern;

/**
 *
 * @author Steve
 */
public class TurkeyAdapter implements Duck {

    // adapts a Turkey to the duck interface
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }
    
    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        // ducks fly a long way. Turkeys only in short hops, so do it 5 times 
        // to simulate the long distance
        for ( int i = 0; i < 5; i++ ) {
            turkey.fly();
        }
    }
    
}
