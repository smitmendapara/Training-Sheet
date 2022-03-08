package socketProgramming;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramSender
{
    public static void main(String[] args)
    {
        try
        {
            DatagramSocket datagramSocket = new DatagramSocket();

            String string = "Welcome java";

            InetAddress ipAddress = InetAddress.getByName("127.0.0.1");

            DatagramPacket datagramPacket = new DatagramPacket(string.getBytes(), string.length(), ipAddress, 3000);

            datagramSocket.send(datagramPacket);

            datagramSocket.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
