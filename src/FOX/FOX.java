/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FOX;
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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
/**
 *
 * @author VSHANRO
 */
public class FOX extends javax.swing.JFrame {
    public void DLL() throws IOException, InterruptedException {
        MainFrame g = new MainFrame();
        while (true) {
            URL url = null;
            url = new URL("http://www.foxnews.com/");

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            
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

                    for (Element headline : doc.select("h2.title")) {
                        g.jTextArea1.append(headline.text() + " -FOX " + "(" + dateFormat.format(date) + ")" + "\n");
                        
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
