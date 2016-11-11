/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.strategy;

import java.util.ArrayList;
import model.Laporan;
import model.Orang;
import model.Transaksi;
import model.TutupBuku;

/**
 *
 * @author Novak
 */
public interface Behavior {
    public String editP(String pass);
    public void editA(Orang o, String nama, String username, String password);
    public Orang createA(String nama, String username, String password, int type);
    public void deleteA(ArrayList o, int i);
    public void editT(Transaksi t, String nama, double penerimaan, double pengeluaran, String keterangan);
    public Transaksi createT(String nama, double penerimaan, double pengeluaran, String keterangan, Orang o);
    public void deleteT(Transaksi t, Orang o);
    public TutupBuku createTB(Orang o);
    public Laporan createL(Orang o);
}
