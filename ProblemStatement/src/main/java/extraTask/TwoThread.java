package extraTask;

import java.util.LinkedList;

public class TwoThread
{
    public static void main(String[] args)
    {
        try
        {
            final InOut inOut = new InOut();

            Thread firstThread = new Thread(new Runnable() {
                @Override
                public void run()
                {
                    for (int i = 0; i < 5; i++)
                    {
                        try
                        {
                            inOut.insertion();
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                }
            });

            Thread secondThread = new Thread(new Runnable() {
                @Override
                public void run()
                {
                    try
                    {
                        for (int i = 0; i < 5; i++)
                        {
                            inOut.deletion();
                        }
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                }
            });

            firstThread.start();

            //Thread.sleep(1000);

            secondThread.start();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }


    public static class InOut
    {
        LinkedList<Integer> list = new LinkedList<Integer>();

        int size = 5;

        public void insertion() throws InterruptedException
        {
            if (size == list.size())
            {
                //System.out.println("List is Full...");

                wait();
            }

            int value = (int) (Math.random() * 100);

            list.add(value);

            System.out.println(Thread.currentThread().getName() + "> Inserted Element is : " + " " + value);

            System.out.println(list);

            Thread.sleep(1000);

            //notify();
        }

        public void deletion() throws InterruptedException
        {
            if (list.size() == 0)
            {
                //System.out.println("List is Null !!");

                wait();
            }

            System.out.println(Thread.currentThread().getName() + "> Deleted Element is : " + " " + list.getFirst());

            list.removeFirst();

            System.out.println(list);

            Thread.sleep(1000);

            //notify();
        }
    }
}
