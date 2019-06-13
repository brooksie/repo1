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
public class Tuner {
    
    private Amplifier amplifier;
    private boolean systemOn = false;
    private Band band = Band.FM;
    private double frequency = 100;

    public Tuner(Amplifier amplifier) {
        this.amplifier = amplifier;
    }
    
    public void on() { systemOn = true; }
    public void off() { systemOn = false; };
    public void setAM() { band = Band.AM; };
    public void setFM() { band = Band.FM; }
    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
    
    public enum Band {
        LONGWAVE, AM, FM, DAB, SHORTWAVE;
    }

    public boolean isSystemOn() {
        return systemOn;
    }

    public Band getBand() {
        return band;
    }

    public double getFrequency() {
        return frequency;
    }
    
}
