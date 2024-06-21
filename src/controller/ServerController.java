/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Administrator;
import domain.Automobil;
import domain.Klijent;
import domain.Komponenta;
import domain.Marka;
import domain.Narudzbina;
import domain.Paket;
import domain.StavkaNarudzbine;
import java.util.ArrayList;
import so.automobil.SOAddAutomobil;
import so.automobil.SODeleteAutomobil;
import so.automobil.SOGetAllAutomobil;
import so.automobil.SOUpdateAutomobil;
import so.klijent.SOGetAllKlijent;
import so.komponenta.SOAddKomponenta;
import so.komponenta.SODeleteKomponenta;
import so.komponenta.SOGetAllKomponenta;
import so.komponenta.SOUpdateKomponenta;
import so.login.SOLogin;
import so.marka.SOGetAllMarka;
import so.narudzbina.SOAddNarudzbina;
import so.narudzbina.SODeleteNarudzbina;
import so.narudzbina.SOGetAllNarudzbina;
import so.narudzbina.SOUpdateNarudzbina;
import so.paket.SOGetAllPaket;
import so.stavkaNarudzbine.SOGetAllStavkaNarudzbine;

/**
 *
 * @author PC
 */
public class ServerController {

    private static ServerController instance;

    private ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(administrator);
        return so.getUlogovani();
    }

    public void addAutomobil(Automobil automobil) throws Exception {
        (new SOAddAutomobil()).templateExecute(automobil);
    }

    public void addNarudzbina(Narudzbina narudzbina) throws Exception {
        (new SOAddNarudzbina()).templateExecute(narudzbina);
    }

    public void deleteAutomobil(Automobil automobil) throws Exception {
        (new SODeleteAutomobil()).templateExecute(automobil);
    }

    public void deleteNarudzbina(Narudzbina narudzbina) throws Exception {
        (new SODeleteNarudzbina()).templateExecute(narudzbina);
    }

    public void updateAutomobil(Automobil automobil) throws Exception {
        (new SOUpdateAutomobil()).templateExecute(automobil);
    }

    public void updateNarudzbina(Narudzbina narudzbina) throws Exception {
        (new SOUpdateNarudzbina()).templateExecute(narudzbina);
    }

    public ArrayList<Automobil> getAllAutomobil() throws Exception {
        SOGetAllAutomobil so = new SOGetAllAutomobil();
        so.templateExecute(new Automobil());
        return so.getLista();
    }

    public ArrayList<Narudzbina> getAllNarudzbina() throws Exception {
        SOGetAllNarudzbina so = new SOGetAllNarudzbina();
        so.templateExecute(new Narudzbina());
        return so.getLista();
    }

    public ArrayList<Paket> getAllPaket() throws Exception {
        SOGetAllPaket so = new SOGetAllPaket();
        so.templateExecute(new Paket());
        return so.getLista();
    }

    public ArrayList<Marka> getAllMarka() throws Exception {
        SOGetAllMarka so = new SOGetAllMarka();
        so.templateExecute(new Marka());
        return so.getLista();
    }

    public ArrayList<Klijent> getAllKlijent() throws Exception {
        SOGetAllKlijent so = new SOGetAllKlijent();
        so.templateExecute(new Klijent());
        return so.getLista();
    }

    public ArrayList<StavkaNarudzbine> getAllStavkaNarudzbine() throws Exception {
        SOGetAllStavkaNarudzbine so = new SOGetAllStavkaNarudzbine();
        so.templateExecute(new StavkaNarudzbine());
        return so.getLista();
    }

    public void addKomponenta(Komponenta komponenta) throws Exception {
        (new SOAddKomponenta()).templateExecute(komponenta);
    }

    public void deleteKomponenta(Komponenta komponenta) throws Exception {
        (new SODeleteKomponenta()).templateExecute(komponenta);
    }

    public void updateKomponenta(Komponenta komponenta) throws Exception {
        (new SOUpdateKomponenta()).templateExecute(komponenta);
    }

    public Object getAllKomponenta() throws Exception {
        SOGetAllKomponenta so = new SOGetAllKomponenta();
        so.templateExecute(new Komponenta());
        return so.getLista();
    }

}
