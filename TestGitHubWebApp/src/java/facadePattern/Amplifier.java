/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadePattern;

import java.util.logging.Logger;

/**
 *
 * @author Steve
 */
public class Amplifier {
 
    private Tuner tuner;
    private DvdPlayer dvdPlayer;
    private CdPlayer cdPlayer;
    private boolean systemOn = false;
    private InputMode inputMode = InputMode.TUNER;
    private SoundMode soundMode = SoundMode.STEREO;
    private int volume = 20; // between 0 and 100

    public Amplifier() {
    }
    
    public Amplifier(Tuner tuner, DvdPlayer dvdPlayer, CdPlayer cdPlayer) {
        this.tuner = tuner;
        this.dvdPlayer = dvdPlayer;
        this.cdPlayer = cdPlayer;
    }

    public void setTuner(Tuner tuner) {
        this.tuner = tuner;
    }

    public void setDvdPlayer(DvdPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }

    public void setCdPlayer(CdPlayer cdPlayer) {
        this.cdPlayer = cdPlayer;
    }
           
    public void on() { systemOn = true; };
    public void off() { systemOn = false; };
    public void setCd() { inputMode = InputMode.CD; };
    public void setDvd() { inputMode = InputMode.DVD; };
    public void setTuner() { inputMode = InputMode.TUNER; };
    public void setMonoSound() { soundMode = SoundMode.MONO; }
    public void setStereoSound() { soundMode = SoundMode.STEREO; }
    public void setSurroundSoud() { soundMode = SoundMode.SURROUND;}
    public void setVolume(int volume) {
        this.volume = Math.min(100, Math.max(0, volume));
    }

    public enum InputMode {
        TUNER, CD, DVD;
    }
    public enum SoundMode {
        MONO, STEREO, SURROUND;
    }

    public boolean isSystemOn() {
        return systemOn;
    }

    public InputMode getInputMode() {
        return inputMode;
    }

    public SoundMode getSoundMode() {
        return soundMode;
    }

    public int getVolume() {
        return volume;
    }
    
    
}
