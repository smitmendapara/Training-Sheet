package LearnGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphClass
{
    private class Node
    {
        private String label;

        public Node(String label)
        {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<String, Node>();

    private Map<Node, List<Node>> adjacencyList = new HashMap<Node, List<Node>>();

    public void addNode(String label)
    {
        Node node = new Node(label);

        nodes.put(label, node); // putIfAbsent

        adjacencyList.put(node, new ArrayList<Node>());
    }

    public void addEdge(String from, String to)
    {
        Node fromNode = nodes.get(from);

        if (fromNode == null)
        {
            throw new IllegalArgumentException();
        }

        Node toNode = nodes.get(to);

        if (toNode == null)
        {
            throw new IllegalArgumentException();
        }

        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeNode(String label)
    {
        Node node = nodes.get(label);

        if (node == null)
        {
            return;
        }

        for (Node n : adjacencyList.keySet())
        {
            adjacencyList.get(n).remove(node);
        }

        adjacencyList.remove(node);

        nodes.remove(node);
    }

    public void removeEdge(String from, String to)
    {
        Node fromNode = nodes.get(from);

        Node toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
        {
            return;
        }

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void print()
    {
        for (Node source : adjacencyList.keySet())
        {
            List<Node> targets = adjacencyList.get(source);

            if (!targets.isEmpty())
            {
                System.out.println(source + " is connected with " + targets);
            }
        }
    }
}
