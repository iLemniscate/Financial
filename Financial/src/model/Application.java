/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import IOPackage.*;
import model.strategy.*;
import java.io.IOException;
import java.lang.Integer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Novak
 */
public class Application {
    IOFile file;
    DateFormat dateFormat;
    ArrayList<Orang> o;
    ArrayList<Transaksi> t;
    ArrayList<Laporan> l;
    TutupBuku tb;
    BukuBesar bb;
    Orang login = null;
    boolean simulation = false;
    
    public Application() throws IOException {
        file = new IOFile();
        Object f = file.loadFile("id.dat");
        if (f == null) {
            Transaksi.setIdTransaksi(0);
        } else {
            Integer id = (Integer) f ;
            Transaksi.setIdTransaksi(id);
        }
        f = file.loadFile("orang.dat");
        if (f == null) {
            o = new ArrayList<>();
        } else {
            o = (ArrayList<Orang>) f;
        }
        f = file.loadFile("transaksi.dat");
        if (f == null) {
            t = new ArrayList<>();
        } else {
            t = (ArrayList<Transaksi>) f;
        }
        f = file.loadFile("laporan.dat");
        if (f == null) {
            l = new ArrayList<>();
        } else {
            l = (ArrayList<Laporan>) f;
        }
        f = file.loadFile("bukubesar.dat");
        if (f == null) {
            bb = new BukuBesar(new ArrayList());
        } else {
            bb = (BukuBesar) f;
        }
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (o.isEmpty()){
            o.add(new Admin("Admin","admin","admin"));
            file.saveFile(o, "orang.dat");
        }
    }
    
    public boolean login(String username, String password) {
        for (int i=0;i<o.size();i++) {
            if (o.get(i).getUsername().equals(username)){
                if (o.get(i).getPassword().equals(password)) {
                    login = o.get(i);
                    return true;
                }
            }
        }
        return false;
    }
    
    public void logout() {
        login = null;
    }
    
    public void editPassword(String password) throws IOException {
        login.editP(password);
        file.saveFile(o, "orang.dat");
    }
    
    public void addOrang(String nama, String username, String password, int type) throws IOException {
        boolean tersedia = true;
        for (int i=0;i<o.size();i++) {
            if (o.get(i).getUsername().equals(username)){
                tersedia = false;
            }
        }
        if (tersedia == true) {
            o.add(login.createA(nama, username, password, type));
            file.saveFile(o, "orang.dat");
        }
    }
    
    public void editOrang(String nama, String username, String password, String ue) throws IOException {
        for (int i =0;i<o.size();i++) {
            if (o.get(i).getUsername().equals(ue)) {
                login.editA(o.get(i), nama, username, password);
                file.saveFile(o, "orang.dat");
            }
        }
    }
    
    public void deleteOrang(String username) throws IOException {
        for(int i=0;i<o.size();i++) {
            if (o.get(i).getUsername().equals(username)) {
                login.deleteA(o,i);
                file.saveFile(o, "orang.dat");
            }
        }
    }
    
    public void addT(String nama, double penerimaan, double pengeluaran, String keterangan) {
        Transaksi transaksi = login.createT(nama, penerimaan, pengeluaran, keterangan);
        t.add(transaksi);
    }
    
    public void editT(String id, String nama, double penerimaan, double pengeluaran, String keterangan) {
        boolean ketemu = false;
        int idt = 0;
        for (int i=0;i<t.size();i++) {
            if (t.get(i).getId().equals(id)) {
                ketemu = true;
                idt =i;
            }
        }
        if (ketemu) {
            login.editT(t.get(idt), nama, penerimaan, pengeluaran, keterangan);
        }
    }
    
    public void deleteT(String id) {
        boolean ketemu = false;
        int idt = 0;
        for (int i=0;i<t.size();i++) {
            if (t.get(i).getId().equals(id)) {
                ketemu = true;
                idt = i;
            }
        }
        if (ketemu) {
            login.deleteT(t.get(idt));
        }
    }

    public ArrayList<Orang> getO() {
        return o;
    }

    public ArrayList<Transaksi> getT() {
        return t;
    }

    public ArrayList<Laporan> getL() {
        return l;
    }

    public TutupBuku getTb() {
        return tb;
    }

    public BukuBesar getBb() {
        return bb;
    }

    public Orang getLogin() {
        return login;
    }
    
    
    
}
