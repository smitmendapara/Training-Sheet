package socketProgramming;

import java.net.URL;

public class ParsingURL
{
    public static void main(String[] args)
    {
        try
        {
            URL url = new URL("http://example.com:80/docs/books/tutorial/index.html?name=networking#DOWNLOADING");

            System.out.println("Protocol : " + url.getProtocol());

            System.out.println("Authority : " + url.getAuthority());

            System.out.println("Host : " + url.getHost());

            System.out.println("Port : " + url.getPort());

            System.out.println("Path : " + url.getPath());

            System.out.println("Query : " + url.getQuery());

            System.out.println("Filename : " + url.getFile());

            System.out.println("Reference : " + url.getRef());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
