package socketProgramming;

/**
 * Created by smit on 18/11/21.
 */

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class ReadWriteClient
{
    public static void main(String[] args)
    {
        try
        {
            Socket socket = new Socket("localhost", 8182);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            dataOutputStream.writeUTF(UUID.randomUUID().toString());

            dataOutputStream.flush();

            new Thread(() -> {
                // read
                try
                {
                    while (!Thread.currentThread().isInterrupted())
                    {
                        String input = dataInputStream.readUTF();

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


            while (!Thread.currentThread().isInterrupted())
            {
                String input = bufferedReader.readLine();

                dataOutputStream.writeUTF(input);

                dataOutputStream.flush();
            }

            dataOutputStream.close();

            socket.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}

