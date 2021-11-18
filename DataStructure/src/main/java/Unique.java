import java.util.Set;
import java.util.TreeSet;

public class Unique
{
    public static void main(String[] args)
    {
        Set<Integer> treeSet = new TreeSet<Integer>();

        treeSet.add(12);

        treeSet.add(2);

        treeSet.add(11);

        treeSet.add(5);

        System.out.println(treeSet);

    }
}
