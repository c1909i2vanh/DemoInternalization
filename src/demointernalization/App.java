/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demointernalization;

import demointernalization.controller.LoginController;
import demointernalization.view.LoginView;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author GIANG
 */
public class App {

   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Khởi tạo LoginController
                LoginView loginView = new LoginView(new Locale("vi","VN"));
                LoginController mainController = new LoginController(loginView);
                // CHạy phương thức showLoginView
                mainController.showLoginView();
               
            }

        });
    }
    
}
