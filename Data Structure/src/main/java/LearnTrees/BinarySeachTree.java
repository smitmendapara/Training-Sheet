package LearnTrees;

public class    BinarySeachTree
{
    private class Node
    {
        private int value;

        private Node leftNode;

        private Node rightNode;

        public Node(int value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return "Node = " + value;
        }
    }

    private Node root;

    public void insert(int value)
    {

        if (root == null)
        {
            root = new Node(value);

            return;
        }

        Node current = root;

        while (true)
        {
            if (value < current.value)
            {
                if (current.leftNode == null)
                {
                    current.leftNode = new Node(value);

                    break;
                }
                current = current.leftNode;
            }
            else
            {
                if (current.rightNode == null)
                {
                    current.rightNode = new Node(value);

                    break;
                }
                current = current.rightNode;
            }
        }
    }

    public boolean find(int value)
    {
        Node current = root;

        while (current != null)
        {
            if (value < current.value)
            {
                current = current.leftNode;
            }
            else if (value > current.value)
            {
                current = current.rightNode;
            }
            else
            {
                return true;
            }
        }

        return false;
    }
}
