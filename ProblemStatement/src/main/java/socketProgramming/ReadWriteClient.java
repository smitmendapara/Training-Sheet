package socketProgramming;

import java.io.*;
import java.net.Socket;

public class ReadWriteClient
{
    public static void main(String[] args)
    {
        try
        {
            Socket socket = new Socket("localhost", 8182);

            DataInputStream reader = new DataInputStream(socket.getInputStream());

            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            writer.writeUTF(String.valueOf((int)(Math.random() * 100)));

            writer.flush();

            // read data

            new Thread(() -> {

                try
                {
                    while (true)
                    {
                        String input = reader.readUTF();

                        if (input.isEmpty())
                        {
                            continue;
                        }

                        System.out.println("Server > " + input);
                    }
                }
                catch (IOException exception)
                {
                    exception.printStackTrace();
                }

            }).start();

            // write data

            while (!Thread.currentThread().isInterrupted())
            {
                String input = bufferedReader.readLine();

                writer.writeUTF(input);

                writer.flush();
            }

            bufferedReader.close();

            writer.close();

            socket.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}

