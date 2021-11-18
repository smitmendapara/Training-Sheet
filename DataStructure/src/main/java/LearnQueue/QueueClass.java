package LearnQueue;


import java.util.PriorityQueue;
import java.util.Queue;

public class QueueClass
{
    public static void main(String[] args)
    {
        try
        {
            Queue<Integer> pq = new PriorityQueue<Integer>();

            pq.offer(110);

            pq.offer(122);

            pq.offer(150);

            pq.offer(105);

            System.out.println(pq);

            pq.poll();

            System.out.println(pq);

            System.out.println(pq.peek());

        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
