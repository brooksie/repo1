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
public class WildTurkey implements Turkey {

    private SJBLog log;

    public WildTurkey(SJBLog log) {
        this.log = log;
    }
    
    @Override
    public void gobble() {
        log.add("Goggle, gobble!");
    }

    @Override
    public void fly() {
        log.add("I'm flying a short distance");
    }
    
}
