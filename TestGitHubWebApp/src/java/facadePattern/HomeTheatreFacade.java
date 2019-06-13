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
public class HomeTheatreFacade {
    
    private Amplifier amplifier;
    private Tuner tuner;
    private DvdPlayer dvdPlayer;
    private CdPlayer cdPlayer;
    private Projector projector;
    private TheatreLights theatreLights;
    private Screen screen;
    private PopcornPopper popcornPopper;
    private boolean systemOn = false;

    public HomeTheatreFacade(Amplifier amplifier, Tuner tuner, DvdPlayer dvdPlayer, CdPlayer cdPlayer, Projector projector, TheatreLights theatreLights, Screen screen, PopcornPopper popcornPopper) {
        this.amplifier = amplifier;
        this.tuner = tuner;
        this.dvdPlayer = dvdPlayer;
        this.cdPlayer = cdPlayer;
        this.projector = projector;
        this.theatreLights = theatreLights;
        this.screen = screen;
        this.popcornPopper = popcornPopper;
    }

    public void On() { systemOn = true; }
    public void Off() { systemOn = false; }
    
    public void watchMovie(String movie) {
        System.out.println("Getting ready to watch a great movie: " + movie);
        
        if (popcornPopper != null ) {
            popcornPopper.on();
            popcornPopper.pop();
        }
        if (theatreLights != null) {
            theatreLights.on();
            theatreLights.dim();
        }
        if (screen != null) {
            screen.down();
        }
        if (projector != null) {
            projector.on();
            projector.wideScreenMode();
        }
        if (amplifier != null) {
            amplifier.on();
            amplifier.setSurroundSoud();
            amplifier.setVolume(35);
            amplifier.setDvd();
        }
        if ( dvdPlayer != null ) {
            dvdPlayer.on();
            dvdPlayer.play(movie);
        }
    }
    
    public void endMovie() {
        System.out.println("Shutting down the movie theatre");
        
        if (popcornPopper != null ) {
            popcornPopper.off();
        }
        if (theatreLights != null) {
            theatreLights.off();
        }
        if (screen != null) {
            screen.up();
        }
        if (projector != null) {
            projector.off();
        }
        if (amplifier != null) {
            amplifier.off();
        }
        if ( dvdPlayer != null ) {
            dvdPlayer.eject();
            dvdPlayer.off();
        }
    }
    
    
    
    

    public Amplifier getAmplifier() {
        return amplifier;
    }

    public void setAmplifier(Amplifier amplifier) {
        this.amplifier = amplifier;
    }

    public Tuner getTuner() {
        return tuner;
    }

    public void setTuner(Tuner tuner) {
        this.tuner = tuner;
    }

    public DvdPlayer getDvdPlayer() {
        return dvdPlayer;
    }

    public void setDvdPlayer(DvdPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }

    public CdPlayer getCdPlayer() {
        return cdPlayer;
    }

    public void setCdPlayer(CdPlayer cdPlayer) {
        this.cdPlayer = cdPlayer;
    }

    public Projector getProjector() {
        return projector;
    }

    public void setProjector(Projector projector) {
        this.projector = projector;
    }

    public TheatreLights getTheatreLights() {
        return theatreLights;
    }

    public void setTheatreLights(TheatreLights theatreLights) {
        this.theatreLights = theatreLights;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public PopcornPopper getPopcornPopper() {
        return popcornPopper;
    }

    public void setPopcornPopper(PopcornPopper popcornPopper) {
        this.popcornPopper = popcornPopper;
    }
    
    public boolean isSystemOn() {
        return systemOn;
    }

    
}
