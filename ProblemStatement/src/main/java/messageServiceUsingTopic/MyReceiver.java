package messageServiceUsingTopic;

import javax.jms.*;
import javax.naming.InitialContext;

/**
 * Created by smit on 22/11/21.
 */
public class MyReceiver
{
    public static void main(String[] args)
    {
        try
        {
            InitialContext initialContext = new InitialContext();

            TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory)initialContext.lookup("myTopicConnectionFactory");

            TopicConnection topicConnection = topicConnectionFactory.createTopicConnection();

            topicConnection.start();

            TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            Topic topic = (Topic)initialContext.lookup("myTopic");

            TopicSubscriber subscriber = topicSession.createSubscriber(topic);

            MyListener myListener = new MyListener();

            subscriber.setMessageListener(myListener);

            System.out.println("Waiting for Message...");

            while(true)
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
