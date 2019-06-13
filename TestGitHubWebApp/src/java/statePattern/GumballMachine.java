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
public class GumballMachine {
    
    private final State soldOutState;
    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldState;
    private final State winnerState;

    private final SJBLog log;
    
    private State state;
    private int inventory = 0;

    public GumballMachine(SJBLog log, int inventory) {
        this.log = log;
        soldOutState    = new SoldOutState(this);
        soldState       = new SoldState(this);
        noQuarterState  = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        winnerState    = new WinnerState(this);
        this.inventory = inventory;
        if (this.inventory >0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }
    
    public void insertQuarter() {
        state.insertQuarter(log);
    }
    public void ejectQuarter() {
        state.ejectQuarter(log);
    }
    public void turnCrank() {
        state.turnCrank(log);
        state.dispense(log);
    }
    
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void releaseBall() {
        log.add("A gumball comes rolling out of the slot...");
        if (inventory > 0) { inventory--; }
    }
        
    public State getHasQuarterState() {
        return hasQuarterState;
    }
    
    public State getNoQuarterState() {
        return noQuarterState;
    }
    
    public State getSoldState() {
        return soldState;
    }
    
    public State getSoldOutState() {
        return soldOutState;
    }
    
    public State getWinnerState() {
        return winnerState;
    }
    
    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inv) {
        this.inventory = inv;
        if ( this.inventory >0 && state.equals(soldOutState) ) {
            state = noQuarterState;
        }
    }
    public void addInventory(int inv) {
        setInventory( this.inventory + Math.max(0, inv) );
    }

    public int decrementInventory() {
        this.inventory = this.inventory - 1;
        return this.inventory;
    }

}
