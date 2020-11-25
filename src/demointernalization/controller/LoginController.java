/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demointernalization.controller;

import demointernalization.view.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author GIANG
 */
public class LoginController {

    private static LoginView loginView;

    public LoginController() {
        loginView = new LoginView();
    }

    public void showLoginView() {
        loginView.showLoginView();
        loginView.addMyLocaleStateChanged(new MyLocaleStateChanged());
    }

    private class MyLocaleStateChanged implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String y = loginView.getMyLocaleInCombobox();
            System.out.println(y);
        }
    }
}
