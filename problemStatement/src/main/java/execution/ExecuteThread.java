package execution;

public class ExecuteThread implements Runnable
{
    private Thread thread;

    private String threadName;

    public ExecuteThread(String threadName)
    {
        System.out.println("Creating : " + threadName);

        this.threadName = threadName;
    }

    @Override
    public void run()
    {
        System.out.println("Running Thread : " + threadName);

        try
        {
            for (int i = 4; i >= 1; i--)
            {
                System.out.println("Execute Thread : " + threadName + " " + i);

                Thread.sleep(1000 );
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        System.out.println("Thread " + threadName + " Existing");
    }

    public void start()
    {
        System.out.println("Starting : " + threadName);

        if (thread == null)
        {
            thread = new Thread(this, threadName);

            thread.start();
        }
    }
}
