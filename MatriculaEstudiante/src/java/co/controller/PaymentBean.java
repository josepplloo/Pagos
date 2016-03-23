/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.controller;

import co.dao.PaymentFacadeLocal;
import co.model.Payment;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class PaymentBean implements Serializable {

@EJB
private PaymentFacadeLocal paymentFacade;
private UIComponent mybutton;
public UIComponent getMybutton() {
return mybutton;
}

public void setMybutton(UIComponent mybutton) {
this.mybutton = mybutton;
}

private int id;
private String name;
private String institution;
private double amount;
private BigInteger card;
private Date date = new Date();
private int cvvNo;
private String contrasenia;
private String txtContraseniaRepita;
boolean disable=true;

public boolean isDisable() {
return disable;
}

public void setDisable(boolean disable) {
this.disable = disable;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }



String sSubCadena;
String mensajecard;
String m;

public String getM() {return m;}

public void setM(String m) {this.m = m;}

public String getMensajecard() { return mensajecard;}

public void setMensajecard(String mensajecard) {this.mensajecard = mensajecard;}

public String getsSubCadena() {return sSubCadena;}

public void setsSubCadena(String sSubCadena) {this.sSubCadena = sSubCadena;}

public String getContrasenia() {return contrasenia;}

public void setContrasenia(String contrasenia) {this.contrasenia = contrasenia;}

public String getTxtContraseniaRepita() {return txtContraseniaRepita;}

public void setTxtContraseniaRepita(String txtContraseniaRepita) {this.txtContraseniaRepita =

txtContraseniaRepita;}

public int getId() {return id;}

public void setId(int id) {this.id = id;}

public double getAmount() {return amount;}

public void setAmount(double amount) {this.amount = amount;}

public BigInteger getCard() {return card;}

public void setCard(BigInteger card) {this.card = card;}

public Date getDate() {return date;}

public void setDate(Date date) {this.date = date;}

public int getCvvNo() {return cvvNo;}

public void setCvvNo(int cvvNo) {this.cvvNo = cvvNo;}

public PaymentBean() { }

//Acción para insertar el registro en la BD.

public String guardar(){



Payment p = new Payment();

p.setId(id);

p.setAmount(amount);

p.setCard(card);

p.setCvvno(cvvNo);

p.setDate(date);

this.paymentFacade.create(p);

m=this.getMensajecard();

return "PaymentCreate";}

//Permite Validar el tipo de tarjeta de crédito

//Validad el rango de los primeros 4 digitos según el tipo de Tarjeta Visa o Mastercard. Si esta en algún rango se activa el boton



public String validar() {

String sCadena;

sCadena=String.valueOf(card);

sSubCadena = sCadena.substring(0,4);

int val=Integer.parseInt(sSubCadena);

if(val>=0000 && val<=5555) {

FacesMessage message = new FacesMessage("TARJETA VISA");

FacesContext context = FacesContext.getCurrentInstance();

context.addMessage(mybutton.getClientId(context), message);

mensajecard="Es VISA";

disable=false;

this.setMensajecard(mensajecard);

return this.getMensajecard();

} else if(val>=8000 && val<=9999) { System.out.println("El valor es MASTERCARD ");

FacesMessage message = new FacesMessage("TARJETA MASTERCARD");

FacesContext context = FacesContext.getCurrentInstance();

context.addMessage(mybutton.getClientId(context), message);

mensajecard="Es MASTER CARD";

disable=false;

this.setMensajecard(mensajecard);

return this.getMensajecard();

}else {

FacesMessage message = new FacesMessage("Invalid card");

FacesContext context = FacesContext.getCurrentInstance();

context.addMessage(mybutton.getClientId(context), message);

}

return null;

}

//Para Internacionalización

private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

public Locale getLocale() {

return locale;

}

public String getLanguage() {

return locale.getLanguage();

}

public void changeLanguage(String language) {

locale = new Locale(language);

FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));

}

}
