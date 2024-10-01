package top.locoli.demo.netty.bio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 服务端
 */
public class BioServer implements Runnable {

    private ServerSocket serverSocket = null;

    public static void main(String[] args) {
        BioServer bioServer = new BioServer();
        bioServer.run();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(10001));
            System.out.println("bio server start done");
            while (true) {
                Socket socket = serverSocket.accept();

                BioServerHandler handler = new BioServerHandler(socket, StandardCharsets.UTF_8);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
