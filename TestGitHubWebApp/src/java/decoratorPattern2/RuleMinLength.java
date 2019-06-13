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
public class RuleMinLength extends PasswordRuleDecorator {

    public RuleMinLength(PasswordValidator passwordValidator) {
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
        if (password.length() < 6) {
            addMessage("Password must be at least 6 characters long");
            System.out.println("Failed on length check");
            return false;
        }
        System.out.println("OK on length check");
        return true;
    }
    
}
