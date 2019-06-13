/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import iteratorPattern.DinerMenu;
import iteratorPattern.ObjectvilleMenu;
import iteratorPattern.PancakeHouseMenu;
import iteratorPattern.Waitress;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

import java.io.Serializable;
import javax.annotation.PostConstruct;


/**
 *
 * @author Steve
 */
@Named(value="iteratorBean")
@ViewScoped
public class IteratorBean implements Serializable {

    private ObjectvilleMenu dinerMenu;
    private ObjectvilleMenu pancakeMenu;
    private Waitress waitress;
    
    /** Creates a new instance of IteratorBean */
    public IteratorBean() {
    }

    @PostConstruct
    public void init() {
        dinerMenu = new DinerMenu();
        pancakeMenu = new PancakeHouseMenu();
        waitress = new Waitress(pancakeMenu, dinerMenu);
    }
    
    public String getMenu() {
        return waitress.printMenu();
    }
}
