/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WASH;
import MAIN.*;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
/**
 *
 * @author VSHANRO
 */
public class DLWASH extends javax.swing.JFrame {

    public void DLL() throws IOException, InterruptedException {
        MainFrame g = new MainFrame();
        while (true) {
            URL url = null;
            url = new URL("https://www.washingtonpost.com/");
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            //System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

            try (ReadableByteChannel chan = Channels.newChannel(url.openStream())) {
                ByteBuffer buf = ByteBuffer.allocate(90000);
                byte[] array = buf.array();

                int bytesRead = chan.read(buf); // Read a chunk of data.
                while (bytesRead != -1) {
                    buf.clear();
                    bytesRead = chan.read(buf);
                    String s = new String(array);
                    //System.out.println(s);
                    Document doc = Jsoup.parse(s);

                    for (Element headline : doc.select("div.headline")) {
                        g.jTextArea1.append(headline.text() + " -WASH " + "(" + dateFormat.format(date) + ")" + "\n");
                        
                    }
                    Thread.sleep(500);
                }
                buf.clear();
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            g.setVisible(true);
        }

//        g.revalidate();
//        g.repaint();
//
        
    }
}
