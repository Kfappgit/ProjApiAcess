package com.example.projapiacess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Database.ConnectionClass;

public class MainActivity extends AppCompatActivity {

    Button btn_cadastrar;
    EditText edt_password,edt_email;
    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void CheckConnection(View view){
        try {
            if(ConnectionClass.connection == null){

                new ConnectionClass().setConnection();
            }
            if (ConnectionClass.connection != null){
                Statement statement = ConnectionClass.connection.createStatement();
                String sql ="SELECT * FROM *";
                ResultSet res = statement.executeQuery(sql);
                Log.e("ASK" , "---------------------");
                while(res.next()){
                    Log.e("ASK",res.getString ("id"));

                }
                Log.e ("ASK","----------------------");
                Toast.makeText(getApplicationContext(), "Query executed sucessfully", Toast.LENGTH_SHORT).show();


            }else{
                Toast.makeText(getApplicationContext(),"Query to server failed ",Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                Log.e("ASK",e.getMessage());
        }
    }
}
