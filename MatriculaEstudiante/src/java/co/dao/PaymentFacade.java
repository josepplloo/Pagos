/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dao;

import co.model.Payment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author josepplloo
 */
@Stateless
public class PaymentFacade extends AbstractFacade<Payment> implements PaymentFacadeLocal {

    @PersistenceContext(unitName = "MatriculaEstudiantePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaymentFacade() {
        super(Payment.class);
    }
    
}
