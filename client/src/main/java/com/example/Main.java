package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {

        Socket mySocket = new Socket("localhost", 3000);

        System.out.println("Il Client si è collegato");

        BufferedReader in = new BufferedReader (new InputStreamReader(mySocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());

        String stringaInviata;
        String stringaRicevuta;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("Inserire una stringa per terminare l'esecuzione");
            stringaInviata = scanner.nextLine();
            out.writeBytes(stringaInviata + "\n");
            stringaRicevuta = in.readLine();
        } while (stringaInviata.equals("0"));


        out.writeBytes("Sono il client" + '\n');

        System.out.println("La stringa ricevuta " + stringaRicevuta);

        mySocket.close();

    }
}