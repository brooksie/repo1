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
public class GarageDoor {
    
    private String name;    // an identifier
    private boolean lightOn = false;
    private boolean doorOpen = false;

    public GarageDoor(String name) {
        this.name = name;
    }

    public void up() {
        doorOpen = true;
        System.out.println(name + ": garage door open");
    }
    public void down() {
        doorOpen = false;
        System.out.println(name + ": garage door closed");
    }
    public void stop() {
        // not capturing any intermediate state of the garage door at the moment
        System.out.println(name + ": stopped"); 
    }
    public void lightOn() {
        lightOn = true;
        System.out.println(name + ": garage light on");
    }
    public void lightOff() {
        lightOn = false;
        System.out.println(name + ": garage light off");
    }

    @Override
    public String toString() {
        return name + ": garage door is " + ((doorOpen)?"open":"closed") 
                + " and light is " + ((lightOn)?"on":"off");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
