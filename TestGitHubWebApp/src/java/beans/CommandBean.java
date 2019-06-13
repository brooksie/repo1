/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import commandPattern.Command;
import commandPattern.CommandGarageDoorClose;
import commandPattern.CommandGarageDoorOpen;
import commandPattern.CommandLightOff;
import commandPattern.CommandLightOn;
import commandPattern.CommandStereoOff;
import commandPattern.CommandStereoOnCD;
import commandPattern.CommandStereoOnRadio;
import commandPattern.GarageDoor;
import commandPattern.Light;
import commandPattern.MacroCommand;
import commandPattern.RemoteControl;
import commandPattern.Stereo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;


/**
 *
 * @author Steve
 */
@Named
@ViewScoped
public class CommandBean implements Serializable {

    //SimpleRemoteControl remoteControl;
    RemoteControl remoteControl;
    Light mainLight;
    GarageDoor garageDoor;
    Stereo stereo;
    Light partyLights;
    
    List<DisplaySlot> slots;
    DisplaySlot selectedSlot = null;
            
    /** Creates a new instance of CommandBean */
    public CommandBean() {
    }
    
    @PostConstruct
    public void init() {
        mainLight = new Light("main light");
        garageDoor = new GarageDoor("Garage");
        stereo = new Stereo("Kitchen Stereo");
        partyLights = new Light("party lights");
        
        slots = new ArrayList<>(7);
        for ( int i = 0; i<7; i++) {
            DisplaySlot s = new DisplaySlot(i,"<>");
            slots.add(s);
        }

        remoteControl = new RemoteControl();
        
        setSlot( 1, mainLight.getName(),
                new CommandLightOn(mainLight), 
                new CommandLightOff(mainLight)
        );
        setSlot( 2, garageDoor.getName(),
                new CommandGarageDoorOpen(garageDoor), 
                new CommandGarageDoorClose(garageDoor)
        );
        setSlot( 4, stereo.getName() + " CD",
                new CommandStereoOnCD(stereo), 
                new CommandStereoOff(stereo)
        );
        setSlot( 5, stereo.getName() + " Radio",
                new CommandStereoOnRadio(stereo), 
                new CommandStereoOff(stereo)
        );
        setSlot( 6, "Party mode",
                new MacroCommand ( partyOn() ), 
                new MacroCommand ( partyOff() )
        );
        
        
    }

    private void setSlot ( int slot, String name, Command on, Command off) {
        remoteControl.setCommand(slot, on, off);
        DisplaySlot s = slots.get(slot);
        s.name = name;
    }
    private List<Command> partyOn() {
        List<Command> on = new ArrayList<>();
        on.add(new CommandLightOff(mainLight));
        on.add(new CommandLightOn(partyLights));
        on.add(new CommandStereoOnCD(stereo));
        return on;
    }
    private List<Command> partyOff() {
        List<Command> off = new ArrayList<>();
        off.add(new CommandLightOn(mainLight));
        off.add(new CommandLightOff(partyLights));
        off.add(new CommandStereoOff(stereo));
        return off;
    }

    public void pressedOn() {
        remoteControl.onButtonWasPressed(selectedSlot.slot);
    }
    public void pressedOff() {
        remoteControl.offButtonWasPressed(selectedSlot.slot);
    }
    public void pressedUndo() {
        remoteControl.undoButtonWasPressed();
    }

    public List<DisplaySlot> getSlots() {
        return slots;
    }

    public DisplaySlot getSelectedSlot() {
        return selectedSlot;
    }

    public void setSelectedSlot(DisplaySlot selectedSlot) {
        this.selectedSlot = selectedSlot;
    }
    
    

    public class DisplaySlot {
        int slot;
        String name;

        public DisplaySlot(int slot, String name) {
            this.slot = slot;
            this.name = name;
        }

        public int getSlot() {
            return slot;
        }

        public void setSlot(int slot) {
            this.slot = slot;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
    }


    public Light getMainLight() {
        return mainLight;
    }

    public GarageDoor getGarageDoor() {
        return garageDoor;
    }

    public Stereo getStereo() {
        return stereo;
    }

    public Light getPartyLights() {
        return partyLights;
    }

    public RemoteControl getRemoteControl() {
        return remoteControl;
    }
    
}
