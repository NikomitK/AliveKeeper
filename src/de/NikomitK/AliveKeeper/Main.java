package de.NikomitK.AliveKeeper;

import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String [] args) throws IOException, InterruptedException {

        while(true) {
            ping(5000);
            Thread.sleep(20000);
        }
    }

    public static void ping(int port) throws IOException {
        String FromServer;
        try {
            Socket clientSocket = new Socket("localhost", port);

            PrintWriter outToServer = new PrintWriter(
                clientSocket.getOutputStream(), true);

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));

            outToServer.println("How are you?");

            FromServer = inFromServer.readLine();
            System.out.println(FromServer);
        }
        catch(Exception e){
            Runtime.getRuntime().exec("java -jar RaspiOpener.jar");
            System.out.println("Server is offline :/");
            System.out.println("Restarting the server :)");
        }
    }

}
