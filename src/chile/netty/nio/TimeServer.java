package chile.netty.nio;

/**
 * Title : chile.netty.nio
 * Description :
 *  - Time server use Java NIO
 *  -  
 *
 * @author chile
 * @version 1.0
 * @date 2017/4/5 19:02
 */

public class TimeServer {

    public static void main(String[] args) {
        int port = 1090;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // use port 8080
            }
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
