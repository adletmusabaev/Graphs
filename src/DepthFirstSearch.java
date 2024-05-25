public class DepthFirstSearch<Node> extends Search<Node> {
    public DepthFirstSearch(MyGraph<Node> graph, Node source) {
        super(source);

        dfs(graph, source);
    }

    private void dfs(MyGraph<Node> graph, Node current) {
        marked.add(current);

        for (Node v : graph.adjacencyList(current)) {
            if (!marked.contains(v)) {
                edgeTo.put(v, current);
                dfs(graph, v);
            }
        }
    }
}