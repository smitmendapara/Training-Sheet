package messageServiceUsingQueue;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class MyReceiver
{
    public static void main(String[] args)
    {
        try
        {
            Properties properties = new Properties();

            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");

            properties.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");

            // create and start connection

            InitialContext initialContext = new InitialContext(); // it is the starting context for performing naming operations.

            QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) initialContext.lookup("myConnectionFactory");

            QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();

            queueConnection.start();

            // create queue session for the queue receiver and also need of queue for queue receiver to specify queue to used for receive the data

            QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            Queue queue = (Queue) initialContext.lookup("myQueue");

            QueueReceiver queueReceiver = queueSession.createReceiver(queue);

            // create listener class for listening sender

            MyListener myListener = new MyListener();

            // set listener to the receiver

            queueReceiver.setMessageListener(myListener);

            System.out.println("Waiting for Message...");

//            System.out.println("");

            while (true)
            {
                Thread.sleep(1000);
            }

        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
