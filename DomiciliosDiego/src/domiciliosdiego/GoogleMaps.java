/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domiciliosdiego;

/**
 *
 * @author Diego
 */
import java.awt.Desktop;
import java.net.*;
import java.io.IOException;

public class GoogleMaps {
    // Código para abrir un navegador y un URL desde Java
    // Cuando midan tiempo, no pongan esto porque les sale muy mal la medición.
    public static void open(String url)
    {
        if (Desktop.isDesktopSupported()) {
        Desktop desktop = Desktop.getDesktop();
        if (desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(new URI(url));
            }
            catch(IOException ioe) {
                ioe.printStackTrace();
            }
            catch(URISyntaxException use) {
                use.printStackTrace();
            }
        }
    }
    }
}