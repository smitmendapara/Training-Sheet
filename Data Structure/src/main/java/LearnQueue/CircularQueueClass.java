package LearnQueue;

public class CircularQueueClass
{
    int front, rear;
    int max;
    int arr[];

    public CircularQueueClass()
    {
        front = -1;
        rear = -1;
        max = 4;
        arr = new int[max];
    }

    void insert(int val)
    {
        if (rear == -1 && front == -1)
        {
            rear = 0;
            front = 0;

            arr[rear] = val;

            System.out.println("Inserted Element is : " + arr[rear]);
        }

        else if (((rear+1)%max) == front)
        {
            System.out.println("Circular Queue is Full!!");
        }

        else
        {
            rear = ((rear+1)%max);

            arr[rear] = val;

            System.out.println("Inserted Element is : " + arr[rear]);
        }
    }

    void pop()
    {
        if (front == -1 && rear == -1)
        {
            System.out.println("Circular Queue is Empty!!");
        }

        else if (front == rear)
        {
            System.out.println("Deleted Element is : " + arr[front]);

            front = -1;
            rear = -1;
        }

        else
        {
            System.out.println("Deleted Element is : " + arr[front]);

            front = ((front+1)%max);
        }
    }

    void display()
    {
        int i = front;

        if (front == -1 && rear == -1)
        {
            System.out.println("Circular Queue is Empty!!");
        }

        else
        {
            System.out.println("Element in Circular Queue is : ");

            while (i >= rear || i <= rear)
            {
                System.out.println(arr[i]);

                if (i == max-1)
                {
                    i = 0;
                }

                else if (i == rear)
                {
                    break;
                }

                else
                {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        try
        {
            CircularQueueClass cQueue = new CircularQueueClass();

            cQueue.insert(10);

            cQueue.insert(20);

            cQueue.insert(30);

            cQueue.insert(40);


            cQueue.pop();

            cQueue.pop();

            cQueue.pop();


            cQueue.insert(50);

            cQueue.insert(60);

            cQueue.insert(70);

            cQueue.display();

        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
