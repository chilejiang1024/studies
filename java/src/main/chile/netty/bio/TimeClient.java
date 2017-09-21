package main.chile.netty.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created on 2017/3/2.
 * by main.chile.
 * function :
 *      同步阻塞的 time client.
 */

public class TimeClient {

    public static void main(String[] args) {
        int port = 1090;
        if ( args != null && args.length == 1 ) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        try (
                Socket socket = new Socket("127.0.0.1", port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            out.println("QUERY TIME ORDER");
            System.out.println("Send order to time server succeed !");
            String resp = in.readLine();
            System.out.println("Now is " + resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
