package schedulerPolling;

import java.util.concurrent.ConcurrentHashMap;

public class Scheduler implements Runnable
{
    ConcurrentHashMap<String, Integer> context = new ConcurrentHashMap<String, Integer>();

    ConcurrentHashMap<String, Integer> partialContext = new ConcurrentHashMap<String, Integer>();

    public Scheduler()
    {
        context.put("127.16.8.1", 30);
        context.put("127.16.8.2", 60);
        context.put("127.16.8.3", 50);
        context.put("127.16.8.4", 100);
        context.put("127.16.8.5", 100);
        context.put("127.16.8.6", 10);
        context.put("127.16.8.7", 30);
        context.put("127.16.8.8", 10);
        context.put("127.16.8.9", 100);

        partialContext.putAll(context);

    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                for (String ipAddress : partialContext.keySet())
                {
                    int time = partialContext.get(ipAddress);

                    partialContext.replace(ipAddress, time - 10);

                    if (partialContext.get(ipAddress) <= 0)
                    {
                        CommonUtil.putPollingIp(ipAddress);

                        partialContext.put(ipAddress,context.get(ipAddress));
                    }
                }

                Thread.sleep(10);

            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
