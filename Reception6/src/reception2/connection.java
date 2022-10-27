/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reception2;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MALOBA
 */
public class connection {

static Statement createStatement() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    private String url;
    private String user;
    private String pswd;
    public  static  Connection conn;
    public connection() throws SQLException{
         this.url="jdbc:mysql://192.168.85.2:3306/ce2";
         this.user="reception";
         this.pswd="Simms2007";
        /* this.url="jdbc:mysql://localhost:3306/ce2";
         this.user="root";
         this.pswd="";*/
          conn = (Connection) DriverManager.getConnection(url, user, pswd);
    System.out.println("Connexion réussie");
    }



     public static Connection getInstance() throws SQLException
    {
        if(conn==null)
            new connection();
        return conn;
    }

 static void con()
         {

         }
}
