package socketProgramming;

import java.net.ServerSocket;
import java.net.Socket;

public class ReadWriteServer
{


    public static void main(String[] args)
    {
        new ReadWriteServer().start();

    }

    private void start() {
        try
        {
            ServerSocket serverSocket = new ServerSocket(8182);

            while (true)
            {
                Socket client = serverSocket.accept();

                System.out.println("Client Port : " + client);

                HandleThread handler = new HandleThread(client);

                handler.start();


//                handler.send();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}