/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoratorPattern2;

import java.util.Collection;

/**
 *
 * @author Steve
 */
public abstract class PasswordRuleDecorator implements PasswordValidator {
    
    PasswordValidator passwordValidator;

    public PasswordRuleDecorator(PasswordValidator passwordValidator) {
        this.passwordValidator = passwordValidator;
    }
    
    public void addMessage( String message) {
        System.out.println("adding msg: " + message);
        getMessages().add(message);
    }

    @Override
    public Collection<String> getMessages() {
        return passwordValidator.getMessages();
    }

}
