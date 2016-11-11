/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Novak
 */
public class Transaksi implements Serializable {
    
    private static int idTransaksi;
    private String id;
    private String nama;
    private Date tanggal;
    private Orang input;
    private double pengeluaran;
    private double penerimaan;
    private boolean status;
    private String keterangan;
    private Orang konfirmasi;
    private Orang edit;
    private Orang delete;
    private boolean laporan;

    public Transaksi(String nama, Orang input, double penerimaan, double pengeluaran, String keterangan) {
        if (pengeluaran == 0) {
            if (idTransaksi < 10) {
                id = "T100" + idTransaksi;
            } else if (idTransaksi < 100) {
                id = "T10" + idTransaksi;
            } else {
                id = "T1" + idTransaksi;
            }
        } else {
            if (idTransaksi < 10) {
                id = "T000" + idTransaksi;
            } else if (idTransaksi < 100) {
                id = "T00" + idTransaksi;
            } else {
                id = "T0" + idTransaksi;
            }
        }
        
        this.nama = nama;
        this.input = input;
        this.pengeluaran = pengeluaran;
        this.penerimaan = penerimaan;
        this.keterangan = keterangan;
        tanggal = new Date();
        if (pengeluaran == 0) {
            status = false;
            konfirmasi = null;
        } else {
            status = true;
            konfirmasi = input;
        }
        edit = null;
        delete = null;
        laporan = false;
        idTransaksi++;
        
    }
    
    public void konfirmasiT(Orang konfirmasi) {
        this.konfirmasi = konfirmasi;
        status = true;
    }

    public void editT(Orang edit, String nama, double pengeluaran, double penerimaan, String keterangan) {
        this.edit = edit;
        laporan = false;
        this.nama = nama;
        if (this.pengeluaran == 0)
            this.penerimaan = penerimaan;
        else
            this.pengeluaran = pengeluaran;
        this.keterangan = keterangan;
    }
    
    public void deleteT(Orang delete) {
        this.delete = delete;
    }
    
    public static int getIdTransaksi() {
        return idTransaksi;
    }

    public static void setIdTransaksi(int idTransaksi) {
        Transaksi.idTransaksi = idTransaksi;
    }
    
    public String getId() {
        return id;
    }
    
    public String getNama() {
        return nama;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public Orang getInput() {
        return input;
    }

    public double getPengeluaran() {
        return pengeluaran;
    }

    public double getPenerimaan() {
        return penerimaan;
    }

    public boolean isStatus() {
        return status;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public Orang getKonfirmasi() {
        return konfirmasi;
    }

    public Orang getEdit() {
        return edit;
    }

    public Orang getDelete() {
        return delete;
    }

    public boolean isLaporan() {
        return laporan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setInput(Orang input) {
        this.input = input;
    }

    public void setPengeluaran(double pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

    public void setPenerimaan(double penerimaan) {
        this.penerimaan = penerimaan;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setKonfirmasi(Orang konfirmasi) {
        this.konfirmasi = konfirmasi;
    }

    public void setEdit(Orang edit) {
        this.edit = edit;
    }

    public void setDelete(Orang delete) {
        this.delete = delete;
    }

    public void setLaporan(boolean laporan) {
        this.laporan = laporan;
    }
    
    
}
