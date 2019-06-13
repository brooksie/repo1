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
public class CommandStereoOff implements Command {

    Stereo stereo;

    boolean canUndo = false;
    Stereo.Mode prevMode;
    int prevVolume;
    boolean prevStereoOn;

    public CommandStereoOff(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        prevMode = stereo.getCurrentMode();
        prevVolume = stereo.getVolume();
        prevStereoOn = stereo.isStereoOn();
        stereo.off();
        canUndo = true;
    }

    @Override
    public void undo() {
        if (!canUndo) {
            return;
        }

        if (prevStereoOn) {
            stereo.on();
        } else {
            stereo.off();
        }

        if (null != prevMode) switch (prevMode) {
            case CD:
                stereo.setCd();
                break;
            case DVD:
                stereo.setDvd();
                break;
            case RADIO:
                stereo.setRadio();
                break;
            default:
                break;
        }
        
        stereo.setVolume(prevVolume);
        canUndo = false;
    }

}