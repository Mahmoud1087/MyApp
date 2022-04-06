package com.example.myapplication;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Sender extends AsyncTask<String,Void,Void> {

    Socket s;
    DataOutputStream d;
    PrintWriter p;

    @Override
    protected Void doInBackground(String... voids){

        String msg = voids[0];

        try{
            s = new Socket("10.0.2.16",4541);
            p = new PrintWriter(s.getOutputStream());
            p.write(msg);
            p.flush();
            p.close();
            s.close();

        }catch(IOException e){
            e.printStackTrace();
        }




        return null;
    }

}
