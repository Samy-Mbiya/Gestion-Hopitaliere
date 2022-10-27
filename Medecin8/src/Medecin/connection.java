/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Medecin;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author MALOBA
 */
public class connection {

static Statement createStatement() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    static PreparedStatement prepareStatement() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /*static PreparedStatement prepareStatement(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }*/
    private String url;
    private String user;
    private String pswd;
    public  static  Connection conn;
    public connection() throws SQLException{
        //Local Host 
         /* this.url="jdbc:mysql://localhost:3306/ce2";
        this.user="root";
        this.pswd="";*/
    
         // IP
        this.url="jdbc:mysql://192.168.85.2:3306/ce2";
         this.user="medecin";
         this.pswd="Simms2007";
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
