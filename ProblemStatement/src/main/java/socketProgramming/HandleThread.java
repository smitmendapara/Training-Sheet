package socketProgramming;

/**
 * Created by smit on 18/11/21.
 */

import java.io.*;
import java.net.Socket;

public class HandleThread extends Thread
{
    private final Socket client;

//    private final DataInputStream reader;
//    private final DataOutputStream writer;

    HandleThread(Socket inSocket)
    {
        client = inSocket;
    }

    @Override
    public void run()
    {
        try
        {
            DataInputStream dataInputStream = new DataInputStream(client.getInputStream());

            DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String clientId = dataInputStream.readUTF();

            System.out.println(clientId + " has connected to the server");

            dataOutputStream.writeUTF("Hello " + clientId + " !! Welcome to the Hell..!!!");

            dataOutputStream.flush();

            new Thread(() -> {
                // read
                while (!Thread.currentThread().isInterrupted())
                {
                    try
                    {
                        String input = dataInputStream.readUTF();

                        if ("exit".equalsIgnoreCase(input))
                        {
                            disconnect();
                        }

                        System.out.println(clientId + " > " + input);

                    }
                    catch (IOException exception)
                    {
                        exception.printStackTrace();
                    }
                }

            }).start();

            // write
            while (!Thread.currentThread().isInterrupted())
            {
                String input = bufferedReader.readLine();

                dataOutputStream.writeUTF(input);

                dataOutputStream.flush();
            }

            dataInputStream.close();
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void disconnect() throws IOException {
        client.close();
    }

    public void send(String data) {

    }
}
