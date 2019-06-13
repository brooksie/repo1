/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import adapterPattern.Duck;
import adapterPattern.MallardDuck;
import adapterPattern.Turkey;
import adapterPattern.TurkeyAdapter;
import adapterPattern.WildTurkey;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import util.SJBLogger;

/**
 *
 * @author Steve
 */
@Named
@ViewScoped
public class AdapterBean implements Serializable {

    private SJBLogger log;
    private String logText = "";

    private Duck mallard;
    private Turkey wildTurkey;
    private TurkeyAdapter wildTurkeyAdapter;

    private Duck currentDuck = null;
    private List<SelectItem> ducks;

    private Converter duckConverter;
    /**
     * Creates a new instance of adapterBean
     */
    public AdapterBean() {
    }

    @PostConstruct
    public void init() {
        log = new SJBLogger();
        mallard = new MallardDuck(log);
        wildTurkey = new WildTurkey(log);
        wildTurkeyAdapter = new TurkeyAdapter(wildTurkey);

        currentDuck = mallard;

        ducks = new ArrayList<>();
        ducks.add(new SelectItem(mallard, "Mallard"));
        ducks.add(new SelectItem(wildTurkeyAdapter, "Turkey"));
        
        duckConverter = new DuckConverter(ducks);

    }

    public void performQuack() {
        if ( currentDuck != null) {
            currentDuck.quack();
        }
        checkMessages();
    }

    public void performFly() {
        if ( currentDuck != null ) { 
            currentDuck.fly();
        }
        checkMessages();
    }

    private void checkMessages() {
        String s = log.get();
        logText = s + "\n" + logText;
    }

    public String getLogText() {
        return logText;
    }

    public Duck getCurrentDuck() {
        return currentDuck;
    }

    public void setCurrentDuck(Duck currentDuck) {
        this.currentDuck = currentDuck;
        //System.out.println("currentDuck has been set to " + this.currentDuck);
    }

    public List<SelectItem> getDucks() {
        return ducks;
    }

    private class DuckConverter implements Converter {

        List<SelectItem> selectItems;

        public DuckConverter(List<SelectItem> selectItems) {
            this.selectItems = selectItems;
        }
        
        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            //System.out.println("Converter GetAsObject - string value is " + value);
            for (SelectItem si : selectItems) {
                if (value.equals(si.getLabel()))  {
                    return si.getValue();
                }
            }
            return null;    // this should not occur [unless field is cleared]
        }

        @Override
        public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
            //System.out.println("Converter GetAsString - object value is " + arg2);
            for ( SelectItem si : selectItems ) {
                if (si.getValue().equals(arg2)) {
                    return si.getLabel();
                }
            }
            return arg2.toString();    // this should not occur
        }
    }

    public Converter getDuckConverter() {
        return duckConverter;
    }

}
