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
public class TheatreLights {
    
    private int brightness = 100;   // between 0 and 100
    private boolean systemOn = false;
    
    
    public void on() { this.systemOn = true;}
    public void off() { this.systemOn = false;}
    public void dim() { this.setBrightness( 10 ); }
    
    public void setBrightness( int brightness ) {
        this.brightness = Math.max(0, Math.min( 100, brightness));
    }

    public int getBrightness() {
        return brightness;
    }

    public boolean isSystemOn() {
        return systemOn;
    }

}
