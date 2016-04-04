package ds.graph;

import java.util.*;

/**
 * For checking if node is visited, either store the status in the node, or use an additional set
 * @param <T>
 */
public class GraphSearch<T> {

    public void dfs(GraphNode<T> start) {
        Set<GraphNode<T>> visited = new HashSet<>();
        dfsHelper(start, visited);
    }

    private void dfsHelper(GraphNode<T> node, Set<GraphNode<T>> visited) {
        if (node == null) {
            return;
        }

        System.out.println(node.data);
        visited.add(node);

        for (GraphNode<T> neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public void dfsWithNoSet(GraphNode<T> node) {
        if (node == null) {
            return;
        }

        node.state = State.VISITING;
        System.out.println(node.data);

        for (GraphNode<T> neighbor : node.neighbors) {
            if (neighbor.state == State.VISITING) {
                throw new RuntimeException("Cycle found");
            } else if (neighbor.state == State.UNVISITED) {
                dfsWithNoSet(neighbor);
            }
        }

        node.state = State.VISITED;
    }

    public void bfs(GraphNode<T> start) {
        if (start == null) {
            return;
        }
        Set<GraphNode<T>> set = new HashSet<>();
        Queue<GraphNode<T>> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            GraphNode<T> node = queue.remove();
            System.out.println(node.data);

            for (GraphNode<T> neighbor: node.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

}
