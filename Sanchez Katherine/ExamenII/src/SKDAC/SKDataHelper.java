package SKDAC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SKDataHelper {
    private static String SKDBPathConnection = "jdbc:sqlite:DataBase//KSAQQ.sqlite";
    private static Connection SKconn= null;
    protected static synchronized Connection openConnection() throws Exception{
        try {
            if(SKconn == null)
            SKconn = DriverManager.getConnection(SKDBPathConnection);
        } catch (SQLException e) {
            throw e;
        }
        return SKconn;
    }

    protected static void closeConnection() throws Exception{
        try {
            //si exite una conccion abierta
            if(SKconn!= null)
                SKconn.close();
        }catch(Exception e){
            throw e;
        }
    }
}
