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
public class Screen {
    
    private boolean screenDown = false;
    
    public void up() { screenDown = false; }
    public void down() { screenDown = true; }

    public boolean isScreenDown() {
        return screenDown;
    }
    
    
}
