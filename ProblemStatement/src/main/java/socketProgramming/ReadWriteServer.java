package socketProgramming;

/**
 * Created by smit on 18/11/21.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ReadWriteServer
{
//    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(8182);

            while (true) {

//                socket.accept()

                Socket client = serverSocket.accept();

//                new Thread(() -> {
//                    new HandleThread(client).handle();
//                }).start();

                new HandleThread(client).start();

//                serverSocket.close();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
