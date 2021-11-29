package nsq;

import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * Created by smit on 29/11/21.
 */
public class Consumer
{
    public static void main(String[] args)
    {
        try
        {
            NSQLookup lookup = new DefaultNSQLookup();

            lookup.addLookupAddress("localhost", 4161);

            NSQConsumer consumer = new NSQConsumer(lookup, "test_new", "nsq_to_file", (message) -> {

                System.out.println("received : " + message);

                message.finished();

                //message.requeue();
            });

            consumer.setExecutor( new ForkJoinPool(1,(pool)->{

                ForkJoinWorkerThread worker = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
                worker.setName("Worker - " + worker.getPoolIndex());
                return worker;

            },(Thread.UncaughtExceptionHandler)null, true));

            consumer.start();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
