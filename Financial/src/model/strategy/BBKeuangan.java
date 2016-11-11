/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.strategy;

import java.io.Serializable;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author Novak
 */
public class BBKeuangan implements Behavior,Serializable {

    @Override
    public String editP(String pass) {
        return pass;
    }

    @Override
    public void editA(Orang o, String nama, String username, String password) {
        System.out.println("Not Supported (BKEA)");
    }

    @Override
    public Orang createA(String nama, String username, String password, int type) {
        System.out.println("Not Supported (BKCA)");
        return null;
    }

    @Override
    public void deleteA(ArrayList o, int i) {
        System.out.println("Not Supported (BKDA)");
    }

    @Override
    public void editT(Transaksi t, String nama, double penerimaan, double pengeluaran, String keterangan) {
        t.editT(null, nama, pengeluaran, penerimaan, keterangan);
    }

    @Override
    public Transaksi createT(String nama, double penerimaan, double pengeluaran, String keterangan, Orang o) {
        return (new Transaksi(nama,o,0,pengeluaran,keterangan));
    }

    @Override
    public void deleteT(Transaksi t, Orang o) {
        t.deleteT(o);
    }

    @Override
    public TutupBuku createTB(Orang o) {
        return(new TutupBuku(o));
    }

    @Override
    public Laporan createL(Orang o) {
        return(new Laporan(o));
    }
    
}
