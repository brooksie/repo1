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
public class NoQuarterState implements State {
    
    GumballMachine machine;

    public NoQuarterState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter(SJBLog log) {
        log.add("You've inserted a quarter");
        machine.setState(machine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter(SJBLog log) {
        log.add("You haven't inserted a quarter");
    }

    @Override
    public void turnCrank(SJBLog log) {
        log.add("You turned, but there's no quarter");
    }

    @Override
    public void dispense(SJBLog log) {
        log.add("You need to pay first");
    }
    
}
