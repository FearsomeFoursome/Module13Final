/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

import java.io.IOException;

/**
 *
 * @author Gregory
 */
public class main_class {

    public static void main(String[] argv) throws IOException
    {
        Msg_Displays.Menu_Show main_menu = new Msg_Displays.Menu_Show();
        
        main_menu.get_selection();
        
    }
}
