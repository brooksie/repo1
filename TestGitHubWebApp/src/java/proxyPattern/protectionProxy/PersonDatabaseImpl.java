/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxyPattern.protectionProxy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Steve
 */
@Named
@SessionScoped
public class PersonDatabaseImpl implements Serializable, Iterable<PersonBean> {
    
    private ArrayList<PersonBean> people;
    
    @PostConstruct
    public void init() {
        people = new ArrayList<>();
    }
    
    public PersonBean get( String name ) {
        for ( PersonBean person : people ) {
            if ( name.equals(person.getName()) ) {
                return person;
            }
        }
        return null;
    }
    
    public void add( PersonBean person ) {
        // check if the person already exists
        if ( person == null ) {
            throw new NullPointerException("null not allowed");
        }
        if (this.contains(person) )  {
            throw new IllegalArgumentException("Person already exists");
        }
        people.add(person);
    }
    
//    public void modify( PersonBean person ) {
//        // check if the person already exists
//        if ( person == null ) {
//            throw new NullPointerException("null not allowed");
//        }
//        PersonBean pb = this.get(person.name);
//        if ( pb == null ) {
//            throw new IllegalArgumentException("Person doesn't exist");
//        }
//        people.
//    }
    
    public boolean contains ( String name ) {
        PersonBean pb = this.get(name);
        return ( pb != null );
    }

    public boolean contains ( PersonBean pb ) {
        return ( pb == null ) ? false : this.contains( pb.getName() );
    }

    @Override
    public Iterator iterator() {
        return people.iterator();
    }
    
}
