package socketProgramming;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class HandleThread extends Thread
{
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));;

    private Socket client;

    private static List<Socket> listOfClient = new ArrayList<>(); //todo: this list doesn't belong here; it belongs to server class

    private static DataInputStream reader;

    private static DataOutputStream writer;

    HandleThread() //todo: what is the purpose? if not needed can we remove?
    {}

    HandleThread(Socket inSocket) //todo why package private?
    {
        client = inSocket;
    }

    @Override
    public void run()
    {
        try
        {
            listOfClient.add(client); // contain list of client

            reader = new DataInputStream(client.getInputStream());

            writer = new DataOutputStream(client.getOutputStream());

            String clientId = reader.readUTF();

            System.out.println(clientId + " has connected to the server!");

            writer.writeUTF("Hello " + clientId + " !! Welcome to the Hell..!!!"); // send message to client at a connection time...

            writer.flush();

            // read data

            new Thread(() -> {

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

            // write data

            writeData();

            reader.close();
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static void writeData() throws IOException
    {
        while (!Thread.currentThread().isInterrupted())
        {
            String input = bufferedReader.readLine();

//            send(input);
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
