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
public class Laporan implements Serializable {
    ArrayList<Transaksi> listTransaksi;
    Date tanggal;
    double totalPenerimaan;
    double totalPengeluaran;
    Orang create;

    public Laporan(Orang create) {
        listTransaksi = new ArrayList<>();
        this.create = create;
        this.tanggal = new Date();
    }

    public void addTransaksi (Transaksi t) {
        listTransaksi.add(t);
    }
    
    public void setTotal() {
        for(int i=0; i<listTransaksi.size(); i++) {
            totalPenerimaan = totalPenerimaan+listTransaksi.get(i).getPenerimaan();
            totalPengeluaran = totalPengeluaran+listTransaksi.get(i).getPengeluaran();
        }
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

    public Orang getCreate() {
        return create;
    }
    
    
    
}
