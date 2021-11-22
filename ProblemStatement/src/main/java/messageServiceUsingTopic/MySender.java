package messageServiceUsingTopic;

import javax.jms.*;
import javax.naming.InitialContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by smit on 22/11/21.
 */
public class MySender
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

            TopicPublisher publisher = topicSession.createPublisher(topic);

            TextMessage textMessage = topicSession.createTextMessage();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            while(true)
            {
                String string = bufferedReader.readLine();

                if (string.equals("stop"))
                {
                    break;
                }

                textMessage.setText(string);

                publisher.publish(textMessage);

                System.out.println("Message Successfully Sent!");
            }

            topicConnection.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
