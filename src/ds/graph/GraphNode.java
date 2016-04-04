package ds.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {

    public T data;
    public List<GraphNode<T>> neighbors;
    public State state;

    public GraphNode(T data) {
        this(data, new ArrayList<>());
    }

    public GraphNode(T data, List<GraphNode<T>> neighbors) {
        this.data = data;
        this.neighbors = neighbors;
        this.state = State.UNVISITED;
    }
}
