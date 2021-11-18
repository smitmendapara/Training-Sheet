package Locks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable
{
    String name;

    ReentrantLock reentrantLock;

    public Worker(ReentrantLock reentrantLock, String name)
    {
        this.reentrantLock = reentrantLock;

        this.name = name;
    }

    public void run()
    {
        boolean done = false;

        while (!done)
        {
            //Getting Outer Lock
            boolean ans = reentrantLock.tryLock();

            // Returns True if lock is free
            if(ans)
            {
                try
                {
                    Date date = new Date();

                    SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");

                    System.out.println("task name - "+ name + " outer lock acquired at " + format.format(date) + " Doing outer work");

                    Thread.sleep(1500);

                    // Getting Inner Lock
                    reentrantLock.lock();

                    try
                    {
                        date = new Date();

                        format = new SimpleDateFormat("hh:mm:ss");

                        System.out.println("task name - "+ name + " inner lock acquired at " + format.format(date) + " Doing inner work");

                        System.out.println("Lock Hold Count - "+ reentrantLock.getHoldCount());

                        Thread.sleep(1500);
                    }

                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                    finally
                    {
                        //Inner lock release
                        System.out.println("task name - " + name + " releasing inner lock");

                        reentrantLock.unlock();
                    }

                    System.out.println("Lock Hold Count - " + reentrantLock.getHoldCount());

                    System.out.println("task name - " + name + " work done");

                    done = true;
                }

                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }

                finally
                {
                    //Outer lock release
                    System.out.println("task name - " + name + " releasing outer lock");

                    reentrantLock.unlock();

                    System.out.println("Lock Hold Count - " + reentrantLock.getHoldCount());
                }
            }

            else
            {
                System.out.println("task name - " + name + " waiting for lock");

                try
                {
                    Thread.sleep(1000);
                }

                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}

class test
{
    static final int MAX_THEAD = 2;

    public static void main(String[] args)
    {
        ReentrantLock reentrantLock = new ReentrantLock();

        ExecutorService pool = Executors.newFixedThreadPool(MAX_THEAD);

        Runnable worker1 = new Worker(reentrantLock, "Job1");

        Runnable worker2 = new Worker(reentrantLock, "Job2");

        Runnable worker3 = new Worker(reentrantLock, "Job3");

        Runnable worker4 = new Worker(reentrantLock, "Job4");

        pool.execute(worker1);

        pool.execute(worker2);

        pool.execute(worker3);

        pool.execute(worker4);

        pool.shutdown();
    }
}
