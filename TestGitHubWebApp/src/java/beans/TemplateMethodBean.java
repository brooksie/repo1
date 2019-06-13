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
import templateMethodPattern.CaffeineBeverage;
import templateMethodPattern.Coffee;
import templateMethodPattern.Tea;
import util.SJBLogger;


/**
 *
 * @author Steve
 */
@Named
@ViewScoped
public class TemplateMethodBean implements Serializable {

    private String beverage;
    private String condiment;
    private SJBLogger log;
    private String logText;
    /** Creates a new instance of TemplateMethodBean */
    public TemplateMethodBean() {
    }

    @PostConstruct
    public void init() {
        log = new SJBLogger();
    }

    public void makeDrink() {
        CaffeineBeverage drink;
        if ( null == beverage) {
            return;
        } else switch (beverage) {
            case "coffee":
                drink = new Coffee(log, condiment);
                break;
            case "tea":
                drink = new Tea(log, condiment);
                break;
            default:
                return;
        }
        drink.prepareRecipe();
        logText = log.get();
    }

    public String getBeverage() {
        return beverage;
    }

    public void setBeverage(String beverage) {
        this.beverage = beverage;
    }

    public String getCondiment() {
        return condiment;
    }

    public void setCondiment(String condiment) {
        this.condiment = condiment;
    }

    public String getLogText() {
        return logText;
    }
    
}
