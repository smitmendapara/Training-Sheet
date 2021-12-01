package socketProgramming;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramReceiver
{
    public static void main(String[] args)
    {
        DatagramSocket datagramSocket = null;

        try
        {
            byte[] byteArray = new byte[1024];

            datagramSocket = new DatagramSocket(3000); // create socket at another end point and listen with port number

            DatagramPacket datagramPacket = new DatagramPacket(byteArray, 1024); // for receive packet

            datagramSocket.receive(datagramPacket);

            String string = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

            System.out.println(string);

             // resource leak
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            if (datagramSocket != null) datagramSocket.close();
        }
    }
}
