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
public class WinnerState implements State {

    GumballMachine machine;

    public WinnerState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter(SJBLog log) {
        log.add("Please wait until your gumball is dispensed");
    }

    @Override
    public void ejectQuarter(SJBLog log) {
        log.add("Sorry, you've already turned the crank");
    }

    @Override
    public void turnCrank(SJBLog log) {
        log.add("turning twice doesn't get you another gumball");
    }

    @Override
    public void dispense(SJBLog log) {
        log.add("You're a WINNER! You get two gumballs for your quarter");
        machine.releaseBall();
        if (machine.getInventory() <= 0) {
            log.add("Oops, out of gumballs!");
            machine.setState(machine.getSoldOutState());
        } else {
            machine.releaseBall();
            if (machine.getInventory() <= 0) {
                log.add("Oops, out of gumballs!");
                machine.setState(machine.getSoldOutState());
            } else {
                machine.setState(machine.getNoQuarterState());
            }
        }
    }

}
