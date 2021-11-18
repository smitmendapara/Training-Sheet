package LearnHashTable;

import java.util.HashSet;
import java.util.Set;

public class HashTableSet
{
    public static void main(String[] args)
    {
        try
        {
            Set<Integer> set = new HashSet<Integer>();

            set.add(101);

            set.add(201);

            set.add(333);

            set.add(111);

            set.add(201);

            System.out.println(set);

            set.remove(333);

            System.out.println(set);

        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
