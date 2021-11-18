package LearnHashTable;

import java.util.HashMap;
import java.util.Map;


public class HashTableMap
{
    public static void main(String[] args)
    {
        try
        {
            HashMap<Integer, String> map = new HashMap<Integer, String>();

            map.put(1, "One");

            map.put(2, "Two");

            map.put(3, "Three");

            System.out.println(map);

            for (Map.Entry<Integer, String> entry : map.entrySet())
            {
                System.out.println(entry);

                System.out.println(entry.getKey());

                System.out.println(entry.getValue());
            }

            for (Integer value : map.keySet())
            {
                System.out.println(value);
            }

            for (String string : map.values())
            {
                System.out.println(string);
            }

        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}

