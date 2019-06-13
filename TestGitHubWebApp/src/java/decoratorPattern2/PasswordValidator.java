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
public interface PasswordValidator {
    
    public boolean isValid(String password);
    
    public Collection<String> getMessages();
    
}
