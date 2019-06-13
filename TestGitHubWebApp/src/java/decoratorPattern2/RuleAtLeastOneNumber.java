/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoratorPattern2;

/**
 *
 * @author Steve
 */
public class RuleAtLeastOneNumber extends PasswordRuleDecorator {

    public RuleAtLeastOneNumber(PasswordValidator passwordValidator) {
        super(passwordValidator);
    }
    
    @Override
    public boolean isValid(String password) {
        System.out.println("isValid for " + password);
        boolean bool1 = myValidation(password);
        boolean bool2 = passwordValidator.isValid(password);
        return bool1 && bool2 ;
    }

    private boolean myValidation (String password) {
        // add your validation here
        
        boolean match = password.matches(".*\\d.*");
  
        if (!match) {
            addMessage("Password must contain at least 1 number");
            System.out.println("Failed on number check");
            return false;
        }
        System.out.println("OK on number check");
        return true;
    }
    
}
