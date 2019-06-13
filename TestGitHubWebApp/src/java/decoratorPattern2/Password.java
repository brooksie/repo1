/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoratorPattern2;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Steve
 */
public class Password implements PasswordValidator {

    //private String password;
    private Collection<String> messages = new ArrayList();

    public Password() {
        //this.password = password;
    }

    @Override
    public boolean isValid(String password) {
        System.out.println("Password.isValid for " + password);
        return password != null;
    }

    @Override
    public Collection<String> getMessages() {
        return messages;
    }

}
