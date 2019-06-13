/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statePattern;

import util.SJBLog;

/**
 *
 * @author Steve
 */
public class SoldOutState implements State {
    
    GumballMachine machine;

    public SoldOutState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter(SJBLog log) {
        log.add("You can't insert a quarter - the machine is sold out");
    }

    @Override
    public void ejectQuarter(SJBLog log) {
        log.add("You can't eject - you haven't inserted a quarter");
    }

    @Override
    public void turnCrank(SJBLog log) {
        log.add("You turned, but there are no gumballs (you should never see this message)");
    }

    @Override
    public void dispense(SJBLog log) {
        log.add("No gumball dispensed (you should never see this message)");
    }
    
    
}
