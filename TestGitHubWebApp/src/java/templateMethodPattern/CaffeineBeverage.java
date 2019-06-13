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
public abstract class CaffeineBeverage {

    SJBLog log;
    String condiment;

    public CaffeineBeverage(SJBLog log, String condiment) {
        this.log = log;
        this.condiment = condiment;
    }

    // final means the subclasses cannot amend the recipe (= template)
    // *** this is the template method ***
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        log.add("boiling the water");
    }

    void pourInCup() {
        log.add("pouring beverage in cup");
    }
    
    boolean customerWantsCondiments() {
        return condiment.equals("yes");
    }
}
