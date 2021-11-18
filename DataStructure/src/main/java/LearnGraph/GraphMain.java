package LearnGraph;

public class GraphMain
{
    public static void main(String []args)
    {
        GraphClass graph = new GraphClass();

        graph.addNode("first");

        graph.addNode("second");

//        graph.addEdge("first", "second");

        graph.print();
    }
}
