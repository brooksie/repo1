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
public class Projector {
    
    private DvdPlayer dvdPlayer;
    private boolean systemOn = false;
    private Mode mode = Mode.TV;

    public Projector(DvdPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }
    
    public void on() { systemOn = true; }
    public void off() { systemOn = false; }
    public void tvMode() { mode = Mode.TV; }
    public void wideScreenMode() { mode = Mode.WIDE; }

    public boolean isSystemOn() {
        return systemOn;
    }
    public Mode getMode() {
        return mode;
    }
    
    public enum Mode {
        TV, WIDE;
    }
}
