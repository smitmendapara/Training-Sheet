package schedulerPolling;

import java.util.concurrent.LinkedBlockingQueue;

public class CommonUtil
{

    private final static LinkedBlockingQueue<String> pollingQueue = new LinkedBlockingQueue<String>();

    public static String takePollingIp()
    {
        try
        {
            return pollingQueue.take();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return null;
    }

    public static void putPollingIp(String ipName)
    {
        try
        {
            pollingQueue.add(ipName);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
