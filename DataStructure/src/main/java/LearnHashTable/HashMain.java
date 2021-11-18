package LearnHashTable;


public class HashMain
{
    public static void main(String []args)
    {
        CustomHashTable table = new CustomHashTable();

        table.put(6, "One");
        table.put(8, "Three");
        table.put(11, "One");

        table.put(6, "Six");

        System.out.println(table.get(8));

        table.remove(11);

        System.out.println("Done");
    }
}
