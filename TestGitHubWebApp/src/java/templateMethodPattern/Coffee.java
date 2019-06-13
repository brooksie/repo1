/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templateMethodPattern;

import util.SJBLog;

/**
 *
 * @author Steve
 */
public class Coffee extends CaffeineBeverage {

    public Coffee(SJBLog log, String condiment) {
        super(log, condiment);
    }
    
    @Override
    void brew() {
        log.add("brewing the coffee");
    }

    @Override
    void addCondiments() {
        log.add("adding milk and sugar");
    }
    
}
