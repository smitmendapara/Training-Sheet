package Thread;

class Demo
{
    public static void main(String args[])
    {
        Thread thread = Thread.currentThread();

        System.out.println("Current thread: " + thread);

        thread.setName("My Thread");

        System.out.println("After name change: " + thread);

        try
        {
            for(int n = 7; n > 0; n--)
            {
                System.out.println(n);

                Thread.sleep(1000);
            }
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}