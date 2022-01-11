// package simpledatabasefx.connectdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnector {
    private static Connection connect;
    public static Connection tryConnect()
    {
            if(connect == null)
        {
            try {
                String url  ="jdbc:mysql://localhost:3306/dbgamingjoki";
                String user = "root";
                String pass = "";
           
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connect = DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
            //Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Koneksi Gagal");
            }
        }
         return connect;
   
    }
}