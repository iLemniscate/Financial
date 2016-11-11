/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Novak
 */
public class TutupBuku implements Serializable {
    ArrayList<Transaksi> listTransaksi;
    Date tanggal;
    double totalPenerimaan;
    double totalPengeluaran;
    double labaRugi;
    Orang create;

    public TutupBuku(Orang create) {
        listTransaksi = new ArrayList<>();
        this.create = create;
        this.tanggal = new Date();
        totalPenerimaan = 0;
        totalPengeluaran = 0;
        
    }

    public void addTransaksi(Transaksi t) {
        listTransaksi.add(t);
    }
    
    public void setTotal(){
        for(int i=0; i<listTransaksi.size(); i++) {
            totalPenerimaan = totalPenerimaan+listTransaksi.get(i).getPenerimaan();
            totalPengeluaran = totalPengeluaran+listTransaksi.get(i).getPengeluaran();
        }
        labaRugi = totalPenerimaan-totalPengeluaran;
    }
    
    public void setCreate(Orang create) {
        this.create = create;
    }

    public ArrayList<Transaksi> getListTransaksi() {
        return listTransaksi;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public double getTotalPenerimaan() {
        return totalPenerimaan;
    }

    public double getTotalPengeluaran() {
        return totalPengeluaran;
    }

    public double getLabaRugi() {
        return labaRugi;
    }

    public Orang getCreate() {
        return create;
    }
    
    
    
}
