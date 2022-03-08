package pinging;

import org.apache.commons.net.util.SubnetUtils;

import java.util.Scanner;

/**
 * Created by smit on 30/11/21.
 */
public class UpOrDown
{
    public static void main(String[] args)
    {
        try
        {
            Scanner scanner = new Scanner(System.in);

            String CIDR = scanner.next();

            SubnetUtils subnet = new SubnetUtils(CIDR);

            String []strings = subnet.getInfo().getAllAddresses();

            checkUpOrDownIp(strings);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private static void checkUpOrDownIp(String[] strings)
    {
        try
        {
            for (int i = 0; i < strings.length; i++)
            {
                new TraceIp(strings[i]).start();
            }

        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
