/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandPattern;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steve
 */
public class RemoteControl {

    private List<Slot> slots;
    private Command prevCommand;
    private final Command noCommand;

    public RemoteControl() {

        noCommand = new CommandNoOp();

        slots = new ArrayList<>(7);
        Slot s = new Slot( noCommand, noCommand);
        for (int i = 0; i < 7; i++) {
            slots.add(s);
        }
        prevCommand = noCommand;
    }

    public void setCommand(int slotNumber, Command onCommand, Command offCommand) {
        Slot s = new Slot();
        s.onCommand = ((onCommand == null) ? noCommand : onCommand);
        s.offCommand = ((offCommand == null) ? noCommand : offCommand);
        slots.set(slotNumber, s);
    }

    public void onButtonWasPressed(int slot) {
        Command cmd = slots.get(slot).onCommand;
        cmd.execute();
        prevCommand = cmd;
    }

    public void offButtonWasPressed(int slot) {
        Command cmd = slots.get(slot).offCommand;
        cmd.execute();
        prevCommand = cmd;
    }

    public void undoButtonWasPressed() {
        System.out.println("PrevCmd: " + prevCommand);
        prevCommand.undo();
        prevCommand = noCommand;
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();
        buff.append("\n--- Remote Control ---\n");
        int i = 0;
        for (Slot s : slots) {
            buff.append(i + ": " + s.onCommand.getClass().getName() + " / "
                    + s.offCommand.getClass().getName() + "\n");
            i++;
        }
        buff.append("Undo: " + prevCommand.getClass().getName());
        return buff.toString();
    }

    protected class Slot {

        Command onCommand;
        Command offCommand;

        public Slot(Command onCommand, Command offCommand) {
            this.onCommand = onCommand;
            this.offCommand = offCommand;
        }

        public Slot() {
        }

    }
}
