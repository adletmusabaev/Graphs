import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<Node> extends Search<Node> {
    public BreadthFirstSearch(MyGraph<Node> graph, Node source) {
        super(source);

        bfs(graph, source);
    }

    private void bfs(MyGraph<Node> graph, Node current) {
        marked.add(current);

        Queue<Node> queue = new LinkedList<>();
        queue.add(current); //[0]

        while (!queue.isEmpty()) {
            Node v = queue.remove(); // []

            for (Node vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v); // {[1,0] [2,0] [3,0] [4 0] [5 1] [6 1] [7 2]}
                    queue.add(vertex); // [1,2,3,4]
                }
            }
        }
    }
}