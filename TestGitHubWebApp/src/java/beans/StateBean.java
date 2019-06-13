/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import statePattern.GumballMachine;
import util.SJBLogger;

/**
 *
 * @author Steve
 */
@Named
@ViewScoped
public class StateBean implements Serializable {

    private GumballMachine machine;
    private SJBLogger log;
    
    /** Creates a new instance of StateBean */
    public StateBean() {
    }

    @PostConstruct
    public void init() {
        log = new SJBLogger();
        machine = new GumballMachine(log, 0);
    }
    
    public int getInventory() {
        return machine.getInventory();
    }
    
    public void setInventory(int inventory) {
        machine.setInventory(inventory);
    }
    
    public String getLogs () {
        return log.peek();
    }
    
    public void insertedQuarter() {
        machine.insertQuarter();
    }
    
    public void pressedEject() {
        machine.ejectQuarter();
    }
    
    public void turnedCrank() {
        machine.turnCrank();
    }
    
    public void replenish() {
        machine.addInventory( 5 );
    }

    public void clearLogs () {
        log.clear();
    }
    
}
