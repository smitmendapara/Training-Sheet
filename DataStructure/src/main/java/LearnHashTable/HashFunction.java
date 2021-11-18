package LearnHashTable;

import java.util.HashMap;
import java.util.Map;

public class HashFunction
{
    public static void main(String []args)
    {
        try
        {
            Map<Integer, String> map = new HashMap<Integer, String>();

            map.put(123182, "ABC");

            System.out.println(hash(123182)); // pass integer as a index of array to hash function

            Map<String, String> newMap = new HashMap<String, String>();

            newMap.put("ABC", "XYZ");

            System.out.println(newHash("ABC")); // pass string as a index of array to hash function

            String string = "hash code";

            System.out.println(string.hashCode()); // to convert into hash code value
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static int hash(int key)
    {
        return key % 100;
    }

    public static int newHash(String key)
    {
        int hash = 0;

        for (Character ch : key.toCharArray())
        {
            hash += ch;
        }

        return hash * 100;
    }
}
