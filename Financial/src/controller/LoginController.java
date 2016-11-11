/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.Application;
import view.Login;

/**
 *
 * @author Novak
 */
public class LoginController implements ActionListener {
    Application app;
    Login login;

    public LoginController() throws IOException {
        app = new Application();
        login = new Login();
        login.setResizable(false);
        login.getbLogin().addActionListener(this);
        login.getUsername().addActionListener(this);
        login.getPassword().addActionListener(this);
        login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object x = e.getSource();
        if (x.equals(login.getbLogin())) {
            String username = login.getUsername().getText();
            String password = login.getPassword().getText();
            int ketemu = -1;
            boolean pass = false;
            for (int i = 0; i<app.getO().size();i++) {
                if (app.getO().get(i).getUsername().equals(username)) {
                    if (app.getO().get(i).getPassword().equals(password)) {
                        ketemu = i;
                    } else {
                        pass = true;
                    }
                }
            }
            if (ketemu == -1 && pass) {
                JOptionPane.showMessageDialog(null, "Wrong password!");
            } else if (ketemu == -1 && pass == false) {
                JOptionPane.showMessageDialog(null, "Wrong Username!");
            } else {
                JOptionPane.showMessageDialog(null, "YOU WIN!"); //temporary
            }
        }
    }
    
}
