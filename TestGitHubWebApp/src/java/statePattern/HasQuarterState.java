/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statePattern;

import java.util.Random;
import util.SJBLog;

/**
 *
 * @author Steve
 */
public class HasQuarterState implements State {

    Random randomWinner = new Random ( System.currentTimeMillis() );
    GumballMachine machine;

    public HasQuarterState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter(SJBLog log) {
        log.add("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter(SJBLog log) {
        log.add("Quarter returned");
        machine.setState(machine.getNoQuarterState());
    }

    @Override
    public void turnCrank(SJBLog log) {
        log.add("You turned...");
        int winner = randomWinner.nextInt(10); // 0 <= x < 10
        if (( winner == 0 ) && ( machine.getInventory() > 1 )) {
            machine.setState(machine.getWinnerState());
        } else {
            machine.setState(machine.getSoldState());
        }
    }

    @Override
    public void dispense(SJBLog log) {
        log.add("No gumball dispansed");
    }

}
