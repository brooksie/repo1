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
public class CdPlayer {
    
    private Amplifier amplifier;
    private boolean systemOn = false;
    private boolean empty = true;
    private boolean playing = false;
    private boolean paused = false;

    public CdPlayer(Amplifier amplifier) {
        this.amplifier = amplifier;
    }
    
    public void on() { systemOn = true; };
    public void off() { systemOn = false; };
    public void play() { playing = true; paused = false; empty = false;}
    public void pause() { if (playing) { paused = !paused; }}
    public void stop() { if (playing) { playing = false; paused = false;}}
    public void eject() { 
        if (playing) { stop(); }
        empty = true;
    }

    public boolean isSystemOn() {
        return systemOn;
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isPlaying() {
        return playing;
    }

    public boolean isPaused() {
        return paused;
    }
    
    

}