package Thread;

import java.lang.management.ManagementFactory;

public class JConsole extends Thread
{

    public static void main(String []args)
    {
        try
        {
            JConsole object = new JConsole();

//            object.setDaemon(true);

//            System.out.println(ManagementFactory.getRuntimeMXBean().getVmVersion());

            object.start();

//            System.out.println(Thread.currentThread().activeCount());
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(1000);
            }

            catch (Exception exception) {

                exception.printStackTrace();
            }

            System.out.println("Checking JConsole!!");
        }
    }
}
