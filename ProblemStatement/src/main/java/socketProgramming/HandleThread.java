package socketProgramming;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class HandleThread extends Thread
{
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));;

    private Socket client;

    private static List<Socket> listOfClient = new ArrayList<>();

    private static DataInputStream reader;

    private static DataOutputStream writer;

    HandleThread()
    {}

    HandleThread(Socket inSocket)
    {
        client = inSocket;
    }

    @Override
    public void run()
    {
        try
        {
            listOfClient.add(client);

            reader = new DataInputStream(client.getInputStream());

            writer = new DataOutputStream(client.getOutputStream());

            String clientId = reader.readUTF();

            System.out.println(clientId + " has connected to the server");

            writer.writeUTF("Hello " + clientId + " !! Welcome to the Hell..!!!");

            writer.flush();

            new Thread(() -> {
                // read
                while (!Thread.currentThread().isInterrupted())
                {
                    try
                    {
                        String input = reader.readUTF();

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
            while (bufferedReader.readLine() != null)
            {
                String input = bufferedReader.readLine();

//                writer.writeUTF(input);
//
//                writer.flush();

                send(input);
            }

            reader.close();
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void disconnect() throws IOException
    {
        client.close();
    }

    public void send(String data)
    {
        for (Socket other : listOfClient)
        {
            try
            {
                DataOutputStream output = new DataOutputStream(other.getOutputStream());

                output.writeUTF(data);

                output.flush();

            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }

    }
}
