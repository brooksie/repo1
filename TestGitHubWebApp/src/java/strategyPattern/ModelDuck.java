/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategyPattern;

import util.SJBLog;

/**
 *
 * @author Steve
 */
public class ModelDuck extends Duck {

    public ModelDuck(SJBLog log) {
        super(log);
        flyBehaviour = new FlyNoWay(this);
        quackBehaviour = new Quack(this);
    }
    
    @Override
    public void display() {
        this.getLogger().add("I'm a model duck");
    }
    
}
