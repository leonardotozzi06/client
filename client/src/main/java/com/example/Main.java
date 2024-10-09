package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Il Client è partito");

        Socket mySocket = new Socket("localhost", 3000);

        System.out.println("Il Client si è collegato");

        BufferedReader in = new BufferedReader (new InputStreamReader(mySocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());

        out.writeBytes("Ti sei collegato '\n'");

        String stringaCambiata = in.readLine();

        System.out.println("Nuova stringa: " + stringaCambiata);

        mySocket.close();

    }
}