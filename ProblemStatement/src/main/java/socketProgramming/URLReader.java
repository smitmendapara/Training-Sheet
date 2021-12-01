package socketProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = null;

        try
        {
            URL url = new URL("http://www.oracle.com/");

            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

            String input;

            while ((input = bufferedReader.readLine()) != null)
            {
                System.out.println(input);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            bufferedReader.close();
        }
    }
}
