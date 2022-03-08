package messageServiceUsingQueue;

import javax.jms.*;
import javax.naming.InitialContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MySender
{
    public static void main(String[] args)
    {
        try
        {
            // create and start connection

            InitialContext initialContext = new InitialContext();

            QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) initialContext.lookup("myConnectionFactory");

            QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();

            queueConnection.start();

            // create queue session for the queue sender and also need of queue for queue sender to specify queue to used for send the data

            QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            Queue queue = (Queue) initialContext.lookup("myQueue");

            QueueSender queueSender = queueSession.createSender(queue);

            // send containing data and also adds a text message body

            TextMessage textMessage = queueSession.createTextMessage();

            // read data from the console and send to the receiver

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            while (true)
            {
                String string = bufferedReader.readLine();

                if (string.equals("stop"))
                {
                    break;
                }

                textMessage.setText(string);

                queueSender.send(textMessage);

                System.out.println("Message Successfully Sent!");
            }

            queueConnection.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
