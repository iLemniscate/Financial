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
public class BAdmin implements Behavior, Serializable {

    @Override
    public String editP(String pass) {
        System.out.println("Not Supported (ADEP)");
        return null;
    }

    @Override
    public void editA(Orang o, String nama, String username, String password) {
        o.setNama(nama);
        o.setUsername(username);
        o.setPassword(password);
    }

    @Override
    public Orang createA(String nama, String username, String password, int type) {
        if (type == 0)
            return (new Admin(nama,username,password));
        else if (type == 1)
            return (new BKeuangan(nama,username,password));
        else
            return (new PPD(nama,username,password));
    }

    @Override
    public void deleteA(ArrayList o, int i) {
        o.remove(i);
    }

    @Override
    public void editT(Transaksi t, String nama, double penerimaan, double pengeluaran, String keterangan) {
        System.out.println("Not Supported (ADET)");
    }

    @Override
    public Transaksi createT(String nama, double penerimaan, double pengeluaran, String keterangan, Orang o) {
        System.out.println("Not Supported (ADCT)");
        return null;
    }

    @Override
    public void deleteT(Transaksi t, Orang o) {
        System.out.println("Not Supported (ADDT)");
    }

    @Override
    public TutupBuku createTB(Orang o) {
        System.out.println("Not Supported (ADTB)");
        return null;
    }

    @Override
    public Laporan createL(Orang o) {
        System.out.println("Not Supported (ADCL)");
        return null;
    }
    
}
