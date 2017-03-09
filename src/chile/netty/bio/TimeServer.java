package chile.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chile on 2017/2/28.
 * 同步阻塞式的 time server
 */

public class TimeServer {

    // port that server run on.
    private static int port = 0;

    public static void main(String[] args) throws Exception {

        port = 1090;
        // if assign the port manually
        if (args != null && args.length == 1) {
            int p = Integer.valueOf(args[0]);
            if (p > 0 && p <= 65535) {
                try {
                    port= p;
                } catch (NumberFormatException e) {
                    // do nothing
                }
            } else {
                System.out.println("The port is illegal ...");
            }
        }

        createServerInAIOMode();



    }

    /**
     * create a time server in bio mode.
     *
     * @throws IOException
     */
    private static void createServerInAIOMode() throws IOException {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is strat in port : " + port);
            Socket socket = null;
            while (true) {
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (Exception e) {
            // do nothing
        } finally {
            if (server != null) {
                System.out.println("Closing the time server ...");
                server.close();
                server = null;
            }
        }
    }

    /**
     * create server with a thread pool.
     *
     * @throws IOException
     */
    private static void createServerWithThreadPool() throws IOException {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is strat in port : " + port);
            Socket socket = null;
            // create IO thread pool
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 10000);

            while (true) {
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }

        } catch (Exception e) {
            // do nothing.
        } finally {
            if (server != null) {
                System.out.println("Closing the time server ...");
                server.close();
                server = null;
            }
        }

    }


}
