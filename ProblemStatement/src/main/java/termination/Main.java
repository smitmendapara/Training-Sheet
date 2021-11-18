package termination;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            StopWithVolatile stopWithVolatile = new StopWithVolatile();

            Thread volatieThread = new Thread(stopWithVolatile);

            volatieThread.start();

            Thread.sleep(1);

            stopWithVolatile.stopRunning();

            StopWithInterrupts stopWithInterrupts = new StopWithInterrupts();

            Thread interruptThread = new Thread(stopWithInterrupts);

            interruptThread.start();

            Thread.sleep(1);

            interruptThread.interrupt();

        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
