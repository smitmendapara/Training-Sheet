package LearnHeap;

public class HeapClass
{
    private int arr[] = new int[10];

    private int size;

    public void insert(int value)
    {
        if (isFull())
        {
            throw new IllegalStateException();
        }

        arr[size++] = value;

        bubbleUp();
    }

    public void remove()
    {
        int root = arr[0];

        arr[0] = arr[--size];

        int index = 0;

        while ( index <= size && !isValidParent(index) )
        {
            int largerChildIndex = largerChildIndex(index);

            swap(index, largerChildIndex);

            index = largerChildIndex;
        }
    }

    private boolean hasLeftChild(int index)
    {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index)
    {
        return rightChildIndex(index) <= size;
    }

    private int largerChildIndex(int index)
    {
        if (!hasLeftChild(index))
        {
            return index;
        }

        if (!hasRightChild(index))
        {
            return leftChildIndex(index);
        }

        return ( leftChild(index) > rightChild(index) ? leftChildIndex(index) : rightChildIndex(index) );
    }

    private boolean isValidParent(int index)
    {
        if (!hasLeftChild(index))
        {
            return true;
        }

        boolean isValid = arr[index] >= leftChild(index);

        if (hasRightChild(index))
        {
            isValid = isValid & arr[index] >= rightChild(index);;
        }

        return isValid;
    }

    private int rightChild(int index)
    {
        return arr[rightChildIndex(index)];
    }

    private int leftChild(int index)
    {
        return arr[leftChildIndex(index)];
    }

    private int leftChildIndex(int index)
    {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index)
    {
        return (index * 2) + 2;
    }

    private void bubbleUp()
    {
        int currentIndex = size - 1;

        while (isValid(currentIndex))
        {
            swap(currentIndex, parent(currentIndex));

            currentIndex = parent(currentIndex);
        }
    }

    private boolean isFull()
    {
        return size == arr.length;
    }

    private boolean isValid(int currentIndex)
    {
        return ( currentIndex > 0 && (arr[currentIndex] > arr[parent(currentIndex)]) );
    }

    private int parent(int index)
    {
        return (index - 1) / 2;
    }

    private void swap(int first, int second)
    {
        int temp = arr[first];

        arr[first] = arr[second];

        arr[second] = temp;
    }
}
