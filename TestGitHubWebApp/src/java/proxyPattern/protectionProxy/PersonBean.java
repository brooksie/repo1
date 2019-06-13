/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxyPattern.protectionProxy;

/**
 *
 * @author Steve
 */
public interface PersonBean {
    
    public String getName();
    public String getGender();
    public String getInterests();
    public int getHotOrNotRating();
    public int getRatingCount();
    
    public void setName ( String name );
    public void setGender ( String gender );
    public void setInterests ( String interests );
    public void setHotOrNotRating ( int rating );
    
}
