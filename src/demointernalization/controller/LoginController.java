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
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIANG
 */
public class LoginController {

    private static LoginView loginView;

    public LoginController(LoginView view) {
        //Khởi tạo thực thể LoginView khi LoginController được khởi tạo
        loginView = view;
    }

    public void showLoginView() {
        // Vì login view ko có hàm main nên phải setVisible  true cho Login View
        //  Chạy method showLoginView  để hiện Login VIew 
        loginView.showView();
        //Truyền sự kiện được triển khai từ interface ActionListener sang bên Login View
        loginView.addMyLocaleStateChanged(new MyLocaleStateChanged());
    }

    private class MyLocaleStateChanged implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String y = loginView.getMyLocaleInCombobox();
            Properties pro = new Properties();
            pro.setProperty("lang", "en");
            pro.setProperty("country", "US");
            // write properties to a file
            String configFile = System.getProperty("user.dir");

            try {
                pro.store(new FileWriter(configFile + "/src/demointernalization/config/config.properties"), "Comment here");
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("sua xong");
            loginView.closeLoginView();

            LoginView newView = new LoginView(new Locale("en", "US"));
            LoginController newController = new LoginController(newView);
            newController.showLoginView();

        }
    }
}
