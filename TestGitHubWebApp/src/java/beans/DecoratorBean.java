/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import decoratorPattern.Beverage;
import decoratorPattern.DarkRoastBeverage;
import decoratorPattern.DecafBeverage;
import decoratorPattern.EspressoBeverage;
import decoratorPattern.HouseBlendBeverage;
import decoratorPattern.Milk;
import decoratorPattern.Mocha;
import decoratorPattern.Soy;
import decoratorPattern.Whip;
import decoratorPattern2.Password;
import decoratorPattern2.PasswordValidator;
import decoratorPattern2.RuleAtLeastOneCapital;
import decoratorPattern2.RuleAtLeastOneNumber;
import decoratorPattern2.RuleMinLength;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Steve
 */
@Named
@ViewScoped
public class DecoratorBean implements Serializable {

    private float beverageCost = 0;
    private String beverageDesc = "";

    private String coffeeType;
    private boolean addMilk = false;
    private boolean addMocha = false;
    private boolean addSoy = false;
    private boolean addWhip = false;

    private String pwd;
    private boolean ruleLength = true;
    private boolean ruleNumber = true;
    private boolean ruleCapital = true;

    /**
     * Creates a new instance of DecoratorBean
     */
    public DecoratorBean() {
    }

    @PostConstruct
    public void init() {
    }

    public void barista() {
        Beverage beverage;
        beverage = ("0".equals(coffeeType)) ? new HouseBlendBeverage()
                : ("1".equals(coffeeType)) ? new DarkRoastBeverage()
                : ("2".equals(coffeeType)) ? new DecafBeverage()
                : ("3".equals(coffeeType)) ? new EspressoBeverage() : null;

        if (addMilk) {
            beverage = new Milk(beverage);
        }
        if (addMocha) {
            beverage = new Mocha(beverage);
        }
        if (addSoy) {
            beverage = new Soy(beverage);
        }
        if (addWhip) {
            beverage = new Whip(beverage);
        }
        beverageDesc = beverage.getDescription();
        beverageCost = (float) beverage.cost();
    }

    public float getBeverageCost() {
        return beverageCost;
    }

    public String getBeverageDesc() {
        return beverageDesc;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public boolean isAddMilk() {
        return addMilk;
    }

    public void setAddMilk(boolean addMilk) {
        this.addMilk = addMilk;
    }

    public boolean isAddMocha() {
        return addMocha;
    }

    public void setAddMocha(boolean addMocha) {
        this.addMocha = addMocha;
    }

    public boolean isAddSoy() {
        return addSoy;
    }

    public void setAddSoy(boolean addSoy) {
        this.addSoy = addSoy;
    }

    public boolean isAddWhip() {
        return addWhip;
    }

    public void setAddWhip(boolean addWhip) {
        this.addWhip = addWhip;
    }

    //*********************************
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void validatePwd(javax.faces.context.FacesContext context,
            javax.faces.component.UIComponent toValidate, java.lang.Object obj) {
        System.out.println("validating " + obj);
        PasswordValidator pV = new Password();
        System.out.println("building : Length:" + isRuleLength() + " Capital:" + isRuleCapital() + " Number:" + isRuleNumber());
        if (isRuleLength())  {pV = new RuleMinLength(pV); }
        if (isRuleCapital()) {pV = new RuleAtLeastOneCapital(pV); }
        if (isRuleNumber())  {pV = new RuleAtLeastOneNumber(pV); }
        String pass = (String) obj;
        if (!pV.isValid(pass)) {
            System.out.println("not valid");
            ((UIInput) toValidate).setValid(false);
            Collection<String> msgs = pV.getMessages();
            for (String msg : msgs) {
                System.out.println("Error: " + msg);
                FacesMessage message = new FacesMessage(msg);
                context.addMessage(toValidate.getClientId(context), message);
            }
        } else {
            System.out.println("IsValid (" + pass + ")");
        }
    }

    public boolean isRuleLength() {
        return ruleLength;
    }

    public void setRuleLength(boolean ruleLength) {
        this.ruleLength = ruleLength;
    }

    public boolean isRuleNumber() {
        return ruleNumber;
    }

    public void setRuleNumber(boolean ruleNumber) {
        this.ruleNumber = ruleNumber;
    }

    public boolean isRuleCapital() {
        return ruleCapital;
    }

    public void setRuleCapital(boolean ruleCapital) {
        this.ruleCapital = ruleCapital;
    }
    
    

}
