/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;

import java.io.Serializable;
import java.lang.reflect.Proxy;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import proxyPattern.protectionProxy.NonOwnerInvocationHandler;
import proxyPattern.protectionProxy.OwnerInvocationHandler;
import proxyPattern.protectionProxy.PersonBean;
import proxyPattern.protectionProxy.PersonBeanImpl;
import proxyPattern.protectionProxy.PersonDatabaseImpl;

/**
 *
 * @author Steve
 */
@Named
@ViewScoped
public class ProxyBean implements Serializable {

    private PersonBean person1;
    private PersonBean person2;
    private String person1Name;
    private String person2Name;

    @Inject
    private PersonDatabaseImpl peopleDB;

    /**
     * Creates a new instance of ProxyBean
     */
    public ProxyBean() {
    }

    @PostConstruct
    public void init() {
        //people = new ArrayList<>();
    }

    public PersonBean getPerson1() {
        return person1;
    }

    public void setPerson1(PersonBean person1) {
        this.person1 = person1;
        System.out.println("Person1 updated");
        doDebug();
    }

    public PersonBean getPerson2() {
        return person2;
    }

    public void setPerson2(PersonBean person2) {
        this.person2 = person2;
    }

    public String getPerson1Name() {
        return person1Name;
    }

    public void setPerson1Name(String person1Name) {
        this.person1Name = person1Name;
        System.out.println("Person1Name updated - " + person1Name);
        PersonBean person = peopleDB.get(person1Name);
        if (person == null) {
            person1 = new PersonBeanImpl();
            person1.setName(person1Name);
            peopleDB.add(person1);
        } else {
            person1 = person;
        }
        doDebug();
    }

    public String getPerson2Name() {
        return person2Name;
    }

    public void setPerson2Name(String person2Name) {
        this.person2Name = person2Name;
        System.out.println("**Person2Name updated - " + person2Name);
        PersonBean person = peopleDB.get(person2Name);
        if (person == null) {
            throw new RuntimeException("Person2 does not exist");
        } else {
            person2 = person;
        }
        doDebug();
        PersonBean proxy;
        if (this.person1Name.equals(this.person2Name)) {
            proxy = getOwnerProxy(person);
        } else {
            proxy = getNonOwnerProxy(person);
        }
        person2 = proxy;
    }

    public void validateName(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        if (value == null || !(value instanceof String) || "".equals((String) value) ) {
            return;
        }
        if (!peopleDB.contains((String) value)) {
            FacesMessage msg = new FacesMessage("Name does not exist");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        //return;
    }

    public void validateInterests(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        if (value == null || !(value instanceof String) ) {
            return;
        }
        String oldInterests = person2.getInterests();
        String newInterests = (String) value;
        try {
            person2.setInterests(newInterests);
            person2.setInterests(oldInterests);
        } catch ( Exception ex ) {
            FacesMessage msg = new FacesMessage("Update not available");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        //return;
    }

    PersonBean getOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
    }

    PersonBean getNonOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person));
    }

    private void doDebug() {
        System.out.println("PEOPLE:");
        for (PersonBean person : peopleDB) {
            System.out.println(person.getName() + "; " + person.getGender() + "; " + person.getInterests()
                    + "; " + person.getHotOrNotRating() + " (from " + person.getRatingCount() + ")");
        }
        System.out.println("--------");
    }
}
