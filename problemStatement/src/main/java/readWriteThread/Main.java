package readWriteThread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            File file = new File("/home/smit/Downloads/MyFile.txt");

            createFile(file);

            FileWriter fileWriter = new FileWriter("/home/smit/Downloads/MyFile.txt");

            writeFile(fileWriter);

            DataReader dataReader = new DataReader();

            Thread readThread = new Thread(dataReader);

            DataWriter dataWriter = new DataWriter();

            Thread writeThread = new Thread(dataWriter);

            writeThread.start();

            writeThread.join();

            readThread.start();

            readThread.join();

        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static void writeFile(FileWriter fileWriter) throws IOException
    {
        fileWriter.write("This is a public file to a read!!");

        fileWriter.close();

        System.out.println("Successfully wrote to the file!!");
    }

    private static void createFile(File file) throws IOException
    {
        if (file.createNewFile())
        {
            System.out.println("File is Created!!");
        }
    }

}
