package nsq;

import com.github.brainlag.nsq.NSQProducer;

public class Producer
{
    public static void main(String[] args)
    {
        try
        {
            NSQProducer producer = new NSQProducer().addAddress("localhost",4150);

            producer.start();

            for(int i = 0 ; i < 10 ; i++)
            {
                producer.produce("test_new","hi this is smit".getBytes());
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
