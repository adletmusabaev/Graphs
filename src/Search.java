import java.util.*;

public class Search<Node> {
    protected Set<Node> marked;
    protected Map<Node, Node> edgeTo;
    protected final Node source;

    public Search(Node source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Node n) {
        return marked.contains(n);
    }

    public List<Node> pathTo(Node n) {
        if (!hasPathTo(n)) return null;

        LinkedList<Node> ls = new LinkedList<>();
        for (Node i = n; i != source; i = edgeTo.get(i)) {
            ls.push(i); 
        }

        ls.push(source);

        return ls;
    }
}
