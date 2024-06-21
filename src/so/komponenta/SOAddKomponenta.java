/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.komponenta;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Komponenta;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOAddKomponenta extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Komponenta)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Komponenta!");
        }

        Komponenta komp = (Komponenta) ado;


        ArrayList<Komponenta> komponente = (ArrayList<Komponenta>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Komponenta komponenta : komponente) {
            if (komponenta.getNazivKomponente().equals(komp.getNazivKomponente()))
            {
                throw new Exception("Komponenta vec postoji!");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }

}
