/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import facadePattern.Amplifier;
import facadePattern.CdPlayer;
import facadePattern.DvdPlayer;
import facadePattern.HomeTheatreFacade;
import facadePattern.PopcornPopper;
import facadePattern.Projector;
import facadePattern.Screen;
import facadePattern.TheatreLights;
import facadePattern.Tuner;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;


/**
 *
 * @author Steve
 */
@Named
@ViewScoped
public class FacadeBean implements Serializable {
    
    private Amplifier amplifier;
    private DvdPlayer dvdPlayer;
    private Projector projector;
    private Screen screen;
    private PopcornPopper popcornPopper;
    private TheatreLights theatreLights;
    private Tuner tuner;
    private CdPlayer cdPlayer;
    private HomeTheatreFacade homeTheatre;
    private String movie;

    /** Creates a new instance of FacadeBean */
    public FacadeBean() {
    }

    @PostConstruct
    public void init() {
        amplifier = new Amplifier();
        dvdPlayer = new DvdPlayer(amplifier);
        cdPlayer = new CdPlayer(amplifier);
        projector = new Projector(dvdPlayer);
        screen = new Screen(); 
        theatreLights = new TheatreLights();
     
        homeTheatre = new HomeTheatreFacade(amplifier, tuner, dvdPlayer, cdPlayer, projector, theatreLights, screen, popcornPopper);
        
    }
    
    public void watchMovie() {
        homeTheatre.watchMovie(movie);
    }
    public void endMovie() {
        homeTheatre.endMovie();
    }
    public String getMovie() {
        return movie;
    }
    public void setMovie(String movie) {
        this.movie = movie;
    }
    

    public Amplifier getAmplifier() {
        return amplifier;
    }

    public DvdPlayer getDvdPlayer() {
        return dvdPlayer;
    }

    public Projector getProjector() {
        return projector;
    }

    public Screen getScreen() {
        return screen;
    }

    public PopcornPopper getPopcornPopper() {
        return popcornPopper;
    }

    public TheatreLights getTheatreLights() {
        return theatreLights;
    }

    public Tuner getTuner() {
        return tuner;
    }

    public CdPlayer getCdPlayer() {
        return cdPlayer;
    }

    
    
}
