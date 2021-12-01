package readWriteThread;

import java.io.FileWriter;

public class DataWriter implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            FileWriter fileWriter = new FileWriter("/home/smit/Downloads/MyFile.txt");

            fileWriter.write("Multithreaded application has a multiple thread to perform multiple task at a same time!!");

            fileWriter.close();

            Thread.sleep(2000);

            System.out.println("Once again successfully wrote to the file!!");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
