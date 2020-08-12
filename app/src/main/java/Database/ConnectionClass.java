package Database;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

    public static Connection connection;
    public void setConnection(){
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String ip ="";
            String ConnURL = "jdbc:jtds:sqlserver://"+ip+";intace=;user=;password=;datasername=;";
            Class.forName("net.sourceforge..jtds.jdbc.Drive").newInstance();
            connection = DriverManager.getConnection(ConnURL);
            Log.e("ASK", "Connection Called");
        }catch (Exception e){
            Log.e("ASK","Exception"+e.getMessage());

        }
    }
}
