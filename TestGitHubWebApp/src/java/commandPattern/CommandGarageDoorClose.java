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
public class CommandGarageDoorClose implements Command {

    private final GarageDoor garageDoor; 

    public CommandGarageDoorClose(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }
    
    @Override
    public void execute() {
        garageDoor.down();
    }
    
    @Override
    public void undo() {
        garageDoor.up();
    }
    
}
