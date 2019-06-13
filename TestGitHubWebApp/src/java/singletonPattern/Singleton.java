/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonPattern;

/**
 *
 * @author Steve
 */
public class Singleton {
    
    // volatile ensure multiple threads handle the variable correctly
    // static so that it belongs to the class, not the object
    private volatile static Singleton uniqueInstance = null;
    
    // use private constructor to force the use of getInstance()
    private Singleton() {
    };
    
    // static method to get the singleton - uses lazy instantiation
    public static Singleton getInstance() {
        if ( uniqueInstance == null ) {
            // use double-checked locking to
            // ensure single threading through the creation code
            // but minimize the overhead of synchronization
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();   // create the instance
                }
            }
        }
        
        return uniqueInstance;
    }
    
    // add other methods here!
    private int counter = 0;
    public int getCounter() {
        return counter;
    }
    public int incrementCounter() {
        counter++;
        return counter;
    }
    
}
