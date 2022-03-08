package readWriteThread;

import java.io.File;
import java.util.Scanner;

class DataReader implements Runnable
{
    @Override
    public void run()
    {
        File file = new File("/home/smit/Downloads/MyFile.txt");

        try
        {
            Scanner scanner = new Scanner(file);

            Thread.sleep(2000);

            System.out.println();

            System.out.println("----------------------- File Content ------------------------");

            while (scanner.hasNext())
            {
                String data = scanner.nextLine();

                System.out.println(data);
            }

            scanner.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
