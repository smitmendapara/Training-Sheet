package socketProgramming;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class Main
{
    public static void main(String args[]) throws SocketException
    {
        try
        {
            Enumeration<NetworkInterface> network = NetworkInterface.getNetworkInterfaces();

            for (NetworkInterface networkInterface : Collections.list(network))
            {
                displayInterfaceInformation(networkInterface);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private static void displayInterfaceInformation(NetworkInterface networkInterface) throws SocketException
    {
        System.out.println("Display Name: " + networkInterface.getDisplayName());

        System.out.println("Name: " + networkInterface.getName());

        Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();

        for (InetAddress inetAddress : Collections.list(inetAddresses))
        {
            System.out.println("InetAddress: " + inetAddress);
        }

        System.out.println();
    }
}

