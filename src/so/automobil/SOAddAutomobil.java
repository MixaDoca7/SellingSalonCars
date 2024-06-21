/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.automobil;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Automobil;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOAddAutomobil extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Automobil)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Automobil!");
        }

        Automobil auto = (Automobil) ado;

        if (auto.getCena() < 20000 || auto.getCena() > 1000000) {
            throw new Exception("Cena mora biti izmedju 20000€ i 1000000€!");
        }

        ArrayList<Automobil> automobili = (ArrayList<Automobil>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Automobil automobil : automobili) {
            if (automobil.getBoja().equals(auto.getBoja())
                    && automobil.getModel().equals(auto.getModel())) {
                throw new Exception("Automobil tog modela i te boje vec postoji!");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }

}
