package top.locoli.demo.netty.bio.client;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 客户端
 */
public class BioClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 10001);
            System.out.println("bio client start done");
            BioClientHandler bioClientHandler = new BioClientHandler(socket, StandardCharsets.UTF_8);
            bioClientHandler.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
