/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.marka;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Marka;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOGetAllMarka extends AbstractSO {

    private ArrayList<Marka> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Marka)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Marka!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> marke = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Marka>) (ArrayList<?>) marke;
    }

    public ArrayList<Marka> getLista() {
        return lista;
    }

}
