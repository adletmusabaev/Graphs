import java.util.Objects;

public class Edge<Node> {
    private Node source;
    private Node dest;
    private Double weight;

    public Edge(Node source, Node dest, Double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Edge(Node source, Node dest) {
        this.source = source;
        this.dest = dest;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public Node getSource() {
        return source;
    }

    public void setDest(Node dest) {
        this.dest = dest;
    }

    public Node getDest() {
        return dest;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // references compared

        if (o == null || getClass() != o.getClass()) return false;

        Edge<?> otherEdge = (Edge<?>) o;

        return Objects.equals(this.source, otherEdge.source) &&
                Objects.equals(this.dest, otherEdge.dest);
    }
}