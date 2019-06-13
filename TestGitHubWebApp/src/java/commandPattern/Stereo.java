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
public class Stereo {
    
    private String name = null;
    private Mode currentMode = Mode.RADIO;
    private int volume = 10;
    private boolean stereoOn = false;

    public Stereo(String name) {
        this.name = name;
    }
    
    public void on() {
        stereoOn = true;
    }
    public void off() {
        stereoOn = false;
    }
    public void setCd() {
        currentMode = Mode.CD;
    }
    public void setDvd() {
        currentMode = Mode.DVD;
    }
    public void  setRadio() {
        currentMode = Mode.RADIO;
    }
    public void setVolume( int level ) {
        volume = level;
    }
    
    public enum Mode {
        CD, DVD, RADIO;
    }

    @Override
    public String toString() {
        return "Stereo{" + "name=" + name + ", currentMode=" + currentMode + ", volume=" + volume + ", stereoOn=" + stereoOn + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mode getCurrentMode() {
        return currentMode;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isStereoOn() {
        return stereoOn;
    }

}
