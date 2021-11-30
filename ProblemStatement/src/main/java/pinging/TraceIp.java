package pinging;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by smit on 30/11/21.
 */
public class TraceIp extends Thread
{
    private String ip;

    private int packetTime;

    TraceIp()
    {}

    TraceIp(String ip)
    {
        this.ip = ip;
    }

    @Override
    public void run()
    {
            String pingResult = "";

            String cmdCommand = "ping -c 4 " + ip;

            try
            {
                Runtime runtime = Runtime.getRuntime();

                Process process = runtime.exec(cmdCommand);

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                String input;

                while ((input = reader.readLine()) != null)
                {
                    pingResult += input;
                }

                reader.close();

                String string = pingResult.toString();

                String subString = string.substring(string.indexOf("4 packets"));

                if (subString.charAt(23) == '4' && subString.charAt(35) == '0')
                {
                    String duplicatePacket = subString.substring(subString.indexOf("time"), subString.indexOf("ms"));

                    packetTime = Integer.parseInt(duplicatePacket.substring(5));

//                    System.out.println(packetTime);

                    new CheckIP(packetTime, ip).start();
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }

    }
}
