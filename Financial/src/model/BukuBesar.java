/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Novak
 */
public class BukuBesar implements Serializable {
    ArrayList<TutupBuku> listTB;

    public BukuBesar(ArrayList<TutupBuku> listTB) {
        this.listTB = listTB;
    }

    public ArrayList<TutupBuku> getListTB() {
        return listTB;
    }
    
    
}
