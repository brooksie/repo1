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
public interface State {
    
    public void insertQuarter(SJBLog log);
    public void ejectQuarter(SJBLog log);
    public void turnCrank(SJBLog log);
    public void dispense(SJBLog log);
    
}
