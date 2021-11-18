package LearnQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueClass
{
    public static void main(String[] args)
    {
        try
        {
            Queue<Integer> priorityQueue = new PriorityQueue<Integer>();

            priorityQueue.offer(110);

            priorityQueue.offer(122);

            priorityQueue.offer(150);

            priorityQueue.offer(105);

            priorityQueue.offer(25);

            System.out.println(priorityQueue);

            priorityQueue.poll();

            System.out.println(priorityQueue);

            System.out.println(priorityQueue.peek());


        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}



