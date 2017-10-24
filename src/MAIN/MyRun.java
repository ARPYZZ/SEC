/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;
import WASH.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VSHANRO
 */
public class MyRun implements Runnable{

    MainFrame x;
    DLWASH k = new DLWASH();

    public MyRun(MainFrame) {
       
    }

    @Override
    public void run() {

        try {
            k.DLL(x);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
