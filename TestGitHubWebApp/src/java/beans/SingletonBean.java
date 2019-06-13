/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import singletonPattern.Singleton;

/**
 *
 * @author Steve
 */
@Named
@RequestScoped
public class SingletonBean implements Serializable {

    private int counter = 0;
    
    /** Creates a new instance of SingletonBean */
    public SingletonBean() {
    }

    public int getCounter() {
        counter = (Singleton.getInstance()).getCounter();
        return counter;
    }

    public void incrementCounter() {
        counter = (Singleton.getInstance()).incrementCounter();
    }
    
}