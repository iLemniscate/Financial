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
public class BPPD implements Behavior,Serializable {

    @Override
    public String editP(String pass) {
        return pass;
    }

    @Override
    public void editA(Orang o, String nama, String username, String password) {
        System.out.println("Not Supported (PDEA)");
    }

    @Override
    public Orang createA(String nama, String username, String password, int type) {
        System.out.println("Not Supported (PDCA)");
        return null;
    }

    @Override
    public void deleteA(ArrayList o, int i) {
        System.out.println("Not Supported (PDDA)");
    }

    @Override
    public void editT(Transaksi t, String nama, double penerimaan, double pengeluaran, String keterangan) {
        System.out.println("Not Supported (PDET)");
    }

    @Override
    public Transaksi createT(String nama, double penerimaan, double pengeluaran, String keterangan, Orang o) {
        return (new Transaksi(nama,null,penerimaan,0,keterangan));
    }

    @Override
    public void deleteT(Transaksi t, Orang o) {
        System.out.println("Not Supported (PDDT)");
    }

    @Override
    public TutupBuku createTB(Orang o) {
        System.out.println("Not Supported (PDTB)");
        return null;
    }

    @Override
    public Laporan createL(Orang o) {
        System.out.println("Not Supported (PDCL)");
        return null;
    }
    
}
