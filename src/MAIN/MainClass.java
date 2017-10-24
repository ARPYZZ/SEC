/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VSHANRO
 */
public class MainClass {
    
    public static void main(String args[]) throws InterruptedException, InvocationTargetException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
//        System.out.println("List Of Plugins Available");
//        for(Package p : Package.getPackages()) {
//                System.out.println(p.getName());
//        }
        /* Create and display the form */
        
        MainFrame g ;
        
        try {
            g = new MainFrame();
        } catch (Exception e) {
            
        }
        
        
        java.awt.EventQueue.invokeAndWait(new Runnable() {
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new MainFrame().showClock();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    MyRun r = new MyRun(new MainFrame());
                    Thread thr1 = new Thread(r);
                    thr1.start();
                } catch (Exception e) {
                }

                
                
//                SwingWorker worker2 = new SwingWorker() {
//                    @Override
//                    protected Object doInBackground() throws Exception {
//                        DLNYT m = new DLNYT();
//                        m.DLL();
////               new MainFrame().revalidate();
////               new MainFrame().repaint();
//                        return null;
//                    }
//                };
//
//                worker2.execute();                 
        
            }
            
            
        });
    
    
}
}
