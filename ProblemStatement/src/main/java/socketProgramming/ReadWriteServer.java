package socketProgramming;

import java.net.ServerSocket;
import java.net.Socket;

public class ReadWriteServer
{
    public static void main(String[] args)
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(8182);

            while (true)
            {
                Socket client = serverSocket.accept();

                new HandleThread(client).start();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}