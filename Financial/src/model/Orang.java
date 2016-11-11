/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import java.util.ArrayList;
import model.strategy.*;
import model.Laporan;
import model.Transaksi;
import model.TutupBuku;
/**
 *
 * @author Novak
 */
public abstract class Orang implements Serializable {
    private Behavior b;
    private String nama;
    private String username;
    private String password;

    public Orang(String nama, String username, String password) {
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public Behavior getB() {
        return b;
    }
    
    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setB(Behavior b) {
        this.b = b;
    }
    
    public void editP(String pass) {
        this.password = pass;
    }
    
    public void editA(Orang o, String nama, String username, String password) {
        b.editA(o, nama, username, password);
    }
    
    public Orang createA(String nama, String username, String password, int type) {
        return b.createA(nama, username, password, type);
    }
    
    public void deleteA(ArrayList o, int i) {
        b.deleteA(o,i);
    }
    
    public void editT(Transaksi t, String nama, double penerimaan, double pengeluaran, String keterangan) {
        if (this instanceof BKeuangan) {
            b.editT(t, nama, penerimaan, pengeluaran, keterangan);
            t.setEdit(this);
        }
    }
    
    public Transaksi createT(String nama, double penerimaan, double pengeluaran, String keterangan) {
        Transaksi t = b.createT(nama, penerimaan, pengeluaran, keterangan,this);
        return t;
    }
    
    public void deleteT(Transaksi t) {
        if (this instanceof BKeuangan) {
            b.deleteT(t,this);
        }
        
    }
    
    public TutupBuku createTB(ArrayList<Transaksi> t) {
        TutupBuku tb = b.createTB(this);
        return tb;
    }
    
    public Laporan createL(ArrayList<Transaksi> t) {
        Laporan l = b.createL(this);
        return l;
    }
    
    @Override
    public String toString() {
        return (nama+" "+username+" "+password);
    }
}
