package LearnTrees;

public class TreeMain
{
    public static void main(String []args)
    {
       try
       {
           BinarySeachTree binarySeachTree = new BinarySeachTree();

           binarySeachTree.insert(7);

           binarySeachTree.insert(4);

           binarySeachTree.insert(6);

           binarySeachTree.insert(9);

           binarySeachTree.insert(1);

           binarySeachTree.insert(8);

           binarySeachTree.insert(10);

           System.out.println(binarySeachTree.find(1));


           AVLTree avlTree = new AVLTree();

           avlTree.insert(20);

           avlTree.insert(10);

           avlTree.insert(30);

           avlTree.insert(40);

           avlTree.insert(50);

           avlTree.insert(70);

           avlTree.insert(80);
       }

       catch (Exception exception)
       {
           exception.printStackTrace();
       }
    }
}
