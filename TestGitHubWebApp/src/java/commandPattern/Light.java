/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandPattern;

/**
 *
 * @author Steve
 */
public class Light {
    
    private String name = null;
    private boolean on = false;

    public Light(String name) {
        this.name = name;
    }
    public Light() {
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
        System.out.println("Light is now " + ((on)?"on":"off") );
    }
    
    public void on() {
        setOn(true);
    }
    public void off() {
        setOn(false);
    }

    @Override
    public String toString() {
        return ((name == null)?"Light":name) + ": Light is " + ((on)?"on":"off");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
