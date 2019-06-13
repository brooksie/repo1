/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadePattern;

/**
 *
 * @author Steve
 */
public class PopcornPopper {
    
    private boolean systemOn = false;
    private boolean popping = false;
    
    public void on()  { systemOn = true; }
    public void pop() { popping = true; }
    public void off() { systemOn = false; popping = false; }
    
    public boolean isSystemOn() {
        return systemOn;
    }

    public boolean isPopping() {
        return popping;
    }
    
}
