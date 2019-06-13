/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerPattern;

/**
 *
 * @author Steve
 */
public interface Subject {
    
    public boolean registerObserver (Observer observer);
    
    public boolean removeObserver (Observer observer);
    
    public void notifyObservers (float temp, float humidity, float pressure);
    
}
