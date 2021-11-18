package LearnHeap;

public class Main
{
    public static void main(String []args)
    {
        try
        {
            HeapClass heap = new HeapClass();

            heap.insert(15);

            heap.insert(10);

            heap.insert(3);

            heap.insert(8);

            heap.insert(12);

            heap.insert(9);

            heap.insert(4);

            heap.insert(1);

            heap.insert(24);

            heap.remove();

            heap.remove();

            System.out.println("Done");
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}


