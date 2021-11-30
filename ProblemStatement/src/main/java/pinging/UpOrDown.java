package pinging;

/**
 * Created by smit on 30/11/21.
 */
public class UpOrDown
{
    public static void main(String[] args)
    {
        checkUpOrDownIp("127.16.10");
    }

    private static void checkUpOrDownIp(String subnet)
    {
        try
        {
            for (int i = 0; i < 255; i++)
            {
                String ip = subnet + "." + i;

                new TraceIp(ip).start();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
