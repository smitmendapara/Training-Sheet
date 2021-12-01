import org.apache.commons.net.util.SubnetUtils;

/**
 * Created by smit on 30/11/21.
 */
public class Sample
{
    public static void main(String[] args) {

        String packet;

        String string = "PING 127.0.0.1 (127.0.0.1) 56(84) bytes of data.\n" +
                "64 bytes from 127.0.0.1: icmp_seq=1 ttl=64 time=0.036 ms\n" +
                "64 bytes from 127.0.0.1: icmp_seq=2 ttl=64 time=0.023 ms\n" +
                "64 bytes from 127.0.0.1: icmp_seq=3 ttl=64 time=0.027 ms\n" +
                "64 bytes from 127.0.0.1: icmp_seq=4 ttl=64 time=0.044 ms\n" +
                "\n" +
                "--- 127.0.0.1 ping statistics ---\n" +
                "4 packets transmitted, 4 received, 0% packet loss, time 3060ms\n" +
                "rtt min/avg/max/mdev = 0.023/0.032/0.044/0.009 ms";

        String subString = string.substring(string.indexOf("4 packets"));

        System.out.println(subString);

        if (subString.charAt(23) == '4' && subString.charAt(35) == '0')
        {
            String duplicatePacket = subString.substring(subString.indexOf("time"), subString.indexOf("ms"));

            packet = duplicatePacket.substring(5);

            System.out.println(packet);
        }


        SubnetUtils subnet = new SubnetUtils("127.16.10.0/24");

//        System.out.println(subnet.getInfo());
//
//        System.out.println(subnet.getInfo().getAddress());
//
//        System.out.println(subnet.getInfo().isInRange("127.16.10.200"));

        String []strings = subnet.getInfo().getAllAddresses();

        for (int i = 0; i < strings.length; i++)
        {
            System.out.println(strings[i]);
        }
    }
}
