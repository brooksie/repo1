/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapterPattern;

import util.SJBLog;



/**
 *
 * @author Steve
 */
public class MallardDuck implements Duck {

    private SJBLog log;

    public MallardDuck(SJBLog log) {
        this.log = log;
    }
    
    @Override
    public void quack() {
        log.add("quack");
    }

    @Override
    public void fly() {
        log.add("I'm flying!");
    }

}
