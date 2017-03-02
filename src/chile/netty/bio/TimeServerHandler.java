package chile.netty.bio;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by chile on 2017/2/28.
 *
 */

public class TimeServerHandler implements Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
    }
}
