package LearnTrees;

public class AVLTree
{
    private class AVLNode
    {
        private int value;

        private AVLNode leftChild;

        private AVLNode rightChild;

        public AVLNode(int value)
        {
            this.value = value;
        }

        @Override
        public String toString() {
            return "AVLNode{" +
                    "value=" + value +
                    '}';
        }
    }

    private AVLNode root;

    public void insert(int value)
    {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value)
    {
        if (root == null)
        {
            root = new AVLNode(value);

            return root;
        }

        if (value < root.value)
        {
            root = insert(root.leftChild, value);
        }
        else if (value > root.value)
        {
            root = insert(root.rightChild, value);
        }
        return root;
    }
}
