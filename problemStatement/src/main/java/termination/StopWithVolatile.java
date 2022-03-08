package termination;

public class StopWithVolatile implements Runnable
{
    private volatile boolean flag = true;

    public void stopRunning()
    {
        flag = false;
    }

    @Override
    public void run()
    {
        while (flag)
        {
            System.out.println("Thread is Running...");
        }
        System.out.println("Thread is Stopped!!");
    }
}
