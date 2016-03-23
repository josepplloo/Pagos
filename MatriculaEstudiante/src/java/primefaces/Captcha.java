/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primefaces;


import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author josepplloo
 */
@Named(value = "captcha")
@Dependent
public class Captcha {

    /**
     * Creates a new instance of Captcha
     */
    public Captcha() {
    }
    
    public void check(ActionEvent e){
        FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Your code is wrong", null));
    }
}
