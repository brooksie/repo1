/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import strategyPattern.Duck;
import strategyPattern.MallardDuck;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import strategyPattern.FlyRocketPowered;
import strategyPattern.ModelDuck;
import util.SJBLogger;

/**
 *
 * @author Steve
 */
@Named
@RequestScoped
public class StrategyBean implements Serializable {

    private String chapter1Output;
    private SJBLogger log;
    
    /**
     * Creates a new instance of DesignPatterrnsBean
     */
    public StrategyBean() {
    }

    @PostConstruct
    public void init() {
        chapter1Output = "postconstruct";
        log = new SJBLogger();
    }
    
    public String getChapter1Output() {
        return chapter1Output;
    }

    public void setChapter1Output(String chapter1Output) {
        this.chapter1Output = chapter1Output;
    }
    
    public void miniDuckSimulator() {
        Duck mallard = new MallardDuck( log );
        mallard.display();
        mallard.performFly();
        mallard.performQuack();
        
        //String msg1 = mallard.readLog();
        String msg1 = log.get();
        chapter1Output = msg1;
        
        Duck model = new ModelDuck( log );
        model.display();
        model.performFly();
        model.setFlyBehaviour( new FlyRocketPowered(model) );
        model.performFly();
        
        //String msg2 = model.readLog();
        String msg2 = log.get();
        
        chapter1Output = msg1 + " // " + msg2;
    }
    
}
