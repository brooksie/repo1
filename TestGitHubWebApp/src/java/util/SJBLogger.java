/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Steve
 */
public class SJBLogger implements Serializable, SJBLog {
    
    private final StringBuffer messages = new StringBuffer();
    
    // add a new line to the log
    @Override
    public void add ( String str) {
        String s = str + " \\ ";
        messages.append( s );
        //System.out.println( "SJBLog: " + s );
    }
    
    public String get() {
        String s = messages.toString();
        clear();
        return s;
    } 
    
    public String peek() {
        return messages.toString();
    } 
    
    public void clear() {
        messages.delete(0, messages.length());
    } 
    
    // determine the number of rows in the current log
    public int size() {
        return messages.length();
    }
    
}
