package schedulerPolling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Polling implements Runnable
{
    @Override
    public void run()
    {
        while (true)
        {
            String ip = CommonUtil.takePollingIp();

            String pingResult = "";

            String pingCmd = "ping -c 4 " + ip;

            try
            {
                Runtime runtime = Runtime.getRuntime();

                Process process = runtime.exec(pingCmd);

                BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));

                String inputLine;

                while ((inputLine = input.readLine()) != null)
                {
                    System.out.println(inputLine);

                    pingResult += inputLine;

                }


                input.close();

                String string = pingResult.toString();

                String subString = string.substring(string.indexOf("rtt"));

                String[] split1 = subString.split("=");

                String[] split2 = split1[1].split("/");

                System.out.println("------------- " + ip + " -------------");

                for(String x:split2)
                {
                    System.out.println(x.trim());
                }

                System.out.println("------------- -------------");

                //ProcessBuilder processBuilder = new ProcessBuilder();

            }

            catch (IOException exception)
            {
                System.out.println(exception);
            }

        }

    }
}
