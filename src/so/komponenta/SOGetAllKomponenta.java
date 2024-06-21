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
public class SOGetAllKomponenta extends AbstractSO {

    private ArrayList<Komponenta> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Komponenta)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Automobil!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> komponente = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Komponenta>) (ArrayList<?>) komponente;
    }

    public ArrayList<Komponenta> getLista() {
        return lista;
    }

}
