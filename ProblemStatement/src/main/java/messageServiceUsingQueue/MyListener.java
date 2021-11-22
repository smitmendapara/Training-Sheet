package messageServiceUsingQueue;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by smit on 22/11/21.
 */
public class MyListener implements MessageListener
{
    @Override
    public void onMessage(Message message)
    {
        try
        {
            TextMessage textMessage = (TextMessage) message;

            System.out.println("Received Message : " + textMessage.getText());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
