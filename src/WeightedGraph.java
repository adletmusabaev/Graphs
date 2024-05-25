import java.util.*;
public class WeightedGraph<Node> {
    private final boolean undirected;
    private final Map<Node, List<Edge<Node>>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addNode(Node n) {
        if (hasNode(n))
            return;

        map.put(n, new LinkedList<>());
    }

    public void addEdge(Node source, Node dest, double weight) {
        if (!hasNode(source))
            addNode(source);

        if (!hasNode(dest))
            addNode(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).add(new Edge<>(source, dest, weight));

        if (undirected)
            map.get(dest).add(new Edge<>(dest, source, weight));
    }

    public int getNodesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Node n : map.keySet()) {
            count += map.get(n).size();
        }

        if (undirected)
            count /= 2;

        return count;
    }

    public boolean hasNode(Node n) {
        return map.containsKey(n);
    }

    public boolean hasEdge(Node source, Node dest) {
        if (!hasNode(source)) return false;

        return map.get(source).contains(new Edge<>(source, dest));
    }

    public List<Node> adjacencyList(Node n) {
        if (!hasNode(n)) return null;

        List<Node> nodes = new LinkedList<>();
        for (Edge<Node> e : map.get(n)) {
            nodes.add(e.getDest());
        }

        return nodes;
    }

    public Iterable<Edge<Node>> getEdges(Node n) {
        if (!hasNode(n)) return null;

        return map.get(n);
    }
}
