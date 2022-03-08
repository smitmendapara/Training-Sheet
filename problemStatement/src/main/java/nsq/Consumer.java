package nsq;

import com.github.brainlag.nsq.NSQConsumer;

import com.github.brainlag.nsq.lookup.DefaultNSQLookup;

import com.github.brainlag.nsq.lookup.NSQLookup;

public class Consumer
{
    public static void main(String[] args)
    {
        try
        {
            NSQLookup lookup = new DefaultNSQLookup();

            lookup.addLookupAddress("localhost", 4161);

            NSQConsumer consumer = new NSQConsumer(lookup, "newTopic", "myChannel", (message) -> {

                System.out.println("received : " + new String(message.getMessage()));

                message.finished();

                //message.requeue();
            });


            consumer.start();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
