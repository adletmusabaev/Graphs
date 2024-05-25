import java.util.*;
public class DijkstraSearch<Node> extends Search<Node> {
    private final Set<Node> unsettledNodes;
    private final Map<Node, Double> distances;
    private final WeightedGraph<Node> graph;

    public DijkstraSearch(WeightedGraph<Node> graph, Node source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;

        dijkstra();
    }

    public void dijkstra() {
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Node currentNode = getNodeWithMinimumWeight(unsettledNodes);

            marked.add(currentNode);
            unsettledNodes.remove(currentNode);

            for (Node neighbor : graph.adjacencyList(currentNode)) {
                double newDistance = getShortestDistance(currentNode) + getDistance(currentNode, neighbor);

                if (getShortestDistance(neighbor) > newDistance) {
                    distances.put(neighbor, newDistance);
                    edgeTo.put(neighbor, currentNode); // inverted adding
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }

    private double getDistance(Node node, Node target) {
        for (Edge<Node> edge : graph.getEdges(node)) {
            if (edge.getDest().equals(target))
                return edge.getWeight();
        }

        throw new RuntimeException("Not found!");
    }

    private Node getNodeWithMinimumWeight(Set<Node> nodes) {
        Node minimum = null;
        for (Node node : nodes) {
            if (minimum == null) {
                minimum = node;

                continue;
            }

            if (getShortestDistance(node) < getShortestDistance(minimum))
                minimum = node;
        }

        return minimum;
    }

    private double getShortestDistance(Node destination) {
        Double d = distances.get(destination);

        return (d == null ? Double.MAX_VALUE : d);
    }
}
