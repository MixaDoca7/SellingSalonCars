/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.automobil;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Automobil;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SODeleteAutomobil extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Automobil)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Automobil!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }

}
