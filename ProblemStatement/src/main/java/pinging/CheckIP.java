package pinging;

import java.net.InetAddress;

/**
 * Created by smit on 30/11/21.
 */
public class CheckIP extends Thread
{
    private int packetTime;

    private String ip;

    CheckIP()
    {}

    CheckIP(int packetTime, String ip)
    {
        this.packetTime = packetTime;

        this.ip = ip;
    }

    @Override
    public void run()
    {
        try
        {
            if (InetAddress.getByName(ip).isReachable(packetTime))
            {
                System.out.println(ip + " is Reachable!");
            }
            else
            {
                System.out.println(ip + " is not Reachable!");
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
