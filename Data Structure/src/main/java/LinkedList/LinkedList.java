package LinkedList;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList
{
    private Node first;

    private Node last;

    private int size;

    private class Node
    {
        private int value;

        private Node next;


        Node(int value)
        {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private boolean isEmpty()
    {
        return first == null;
    }

    public void addLast(int item)
    {
        Node node = new Node(item);

        if (isEmpty())
        {
            first = last = node;
        }
        else
        {
            last.next = node;

            last = node;// assign new node is a last node
        }

        size++;
    }

    public void addFirst(int item)
    {
        Node node = new Node(item);

        if (isEmpty())
        {
            first = last = node;
        }
        else
        {
            node.next = first;

            first = node;
        }
        size++;
    }

    public int indexOf(int item)
    {
        int index = 0;

        Node current = first;

        while (current != null)
        {
            if (current.value == item)
            {
                return index;
            }
            else
            {
                current = current.next;

                index++;
            }
        }

        return -1;
    }

    public boolean contains(int item)
    {
        return indexOf(item) != -1;
    }

    public void removeFirst()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }

        if (first == last)
        {
            first = last = null;
        }
        else
        {
            Node second = first.next;

            first.next = null;

            first = second;
        }

        size--;
    }

    public void removeLast()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }

        if (first == last)
        {
            first = last = null;
        }
        else
        {
            Node previous = getPrevious(last); // get the previous node

            last = previous;

            last.next = null;
        }

        size--;
    }

    private Node getPrevious(Node node)
    {
        Node current = first;

        while (current != null)
        {
            if (current.next == last)
            {
                return current;
            }
            else
            {
                current = current.next;
            }
        }

        return null;
    }

    public int size()
    {
        return size;
    }

    public int[] toArray()
    {

        int array[] = new int[size];

        int index = 0;

        Node current = first;

        while (current != null)
        {
            array[index++] = current.value;

            current = current.next;
        }

        return array;
    }

    public void reverse()
    {
        if (isEmpty())
        {
            return;
        }

        Node previous = first;

        Node current = first.next;

        while (current != null)
        {
            Node next = current.next;

            current.next = previous;

            previous = current;

            current = next;
        }

        last = first;

        last.next = null;

        first = previous;
    }

    public int getKthElement(int k)
    {
        Node a = first;

        Node b = first;

        for (int i = 0; i < k - 1; i++)
        {
            b = b.next;

            if (b == null)
            {
                return -1;
            }
        }

        while (b != last)
        {
            a = a.next;
            b = b.next;
        }

        return a.value;
    }
}

class Main
{
    public static void main(String[] args)
    {
        try
        {
            LinkedList list = new LinkedList();

            System.out.println(list.size());

            list.addLast(10);

            list.addLast(20);

            list.addLast(30);

            list.addFirst(5);

            System.out.println(list.size());

            list.removeFirst();

            list.removeLast();

            System.out.println(list.size());

            System.out.println(list.indexOf(20));

            System.out.println(list.contains(30));

            list.reverse();

            int[] array = list.toArray();

            System.out.println("Array is : " + Arrays.toString(array));

            System.out.println(list.getKthElement(3));

        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}