/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandPattern;

import java.util.List;

/**
 *
 * @author Steve
 */
public class MacroCommand implements Command {

    private List<Command> commands;

    public MacroCommand(List<Command> commands) {
        this.commands = commands;
    }
    
    @Override
    public void execute() {
        commands.forEach((c) -> {
            c.execute();
        });
    }

    @Override
    public void undo() {
        commands.forEach((c) -> {
            c.undo();
        });
    }
    
}
