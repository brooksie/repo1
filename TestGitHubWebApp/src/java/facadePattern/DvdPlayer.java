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
public class DvdPlayer {
    
    private Amplifier amplifier;
    private boolean systemOn = false;
    private SoundMode soundMode = SoundMode.STEREO;
    private boolean empty = true;
    private boolean playing = false;
    private boolean paused = false;
    private String movie;

    public DvdPlayer(Amplifier amplifier) {
        this.amplifier = amplifier;
    }
    
    public void on() { systemOn = true; };
    public void off() { systemOn = false; };
    public void setSurroundAudio() { soundMode = SoundMode.SURROUND;}
    public void setTwoChannelAudio() { soundMode = SoundMode.STEREO; }
    public void play() { play(null); }
    public void play( String movie ) { 
        playing = true; paused = false; empty = false; this.movie = movie;
    }
    public void pause() { if (playing) { paused = !paused; }}
    public void stop() { if (playing) { playing = false; paused = false; movie = null;}}
    public void eject() { 
        if (playing) { stop(); }
        empty = true;
    }
 
    public enum SoundMode {
        STEREO, SURROUND;
    }

    public boolean isSystemOn() {
        return systemOn;
    }

    public SoundMode getSoundMode() {
        return soundMode;
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

    public String getMovie() {
        return movie;
    }

}
