/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.komponenta;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Komponenta;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOUpdateKomponenta extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Komponenta)) {
            throw new Exception("Prosledjeni objekat nije instanca klase komponente!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }

}
