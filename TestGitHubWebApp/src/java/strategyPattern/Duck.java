/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategyPattern;

import util.SJBLog;
import util.SJBLogger;

/**
 *
 * @author Steve
 */
public abstract class Duck {
    
    protected FlyBehaviour flyBehaviour;
    protected QuackBehaviour quackBehaviour;
    private final SJBLog log;
    
    public Duck( SJBLog log) {
        this.log = log;
    }
    
    public abstract void display(); 
    
    public void performFly() {
        flyBehaviour.fly();
    }
    
    public void performQuack() {
        quackBehaviour.quack();
    }
    
    public void swim() {
        log.add("All ducks float, even decoys");
    }
    
    public SJBLog getLogger () {
        return log;
    }
    
//    public String readLog() {
//        return log.get();
//    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }
    
}
