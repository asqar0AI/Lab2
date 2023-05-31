import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MyGraph<V> {
    private Map<V, Vertex<V>> vertices;

    public MyGraph() {
        vertices = new HashMap<V, Vertex<V>>();
    }

    private class Vertex<V> {
        private V data;
        private Map<Vertex<V>, Double> adjacentVertices;

        public Vertex(V data) {
            this.data = data;
            adjacentVertices = new HashMap<>();
        }

        public void addAdjacentVertex(Vertex<V> destination, double weight) {
            adjacentVertices.put(destination, weight);
        }

        public void removeAdjacentVertex(Vertex<V> destination) {
            adjacentVertices.remove(destination);
        }

        public V getData() {
            return data;
        }
        public List<Vertex<V>> getNeighbours() {
            ArrayList<Vertex<V>> neighbours = new ArrayList<>();
            for (Vertex<V> vertex : adjacentVertices.keySet()) {
                neighbours.add(vertex);
            }
            return neighbours;
        }

        public boolean hasEdge(Vertex<V> destination) {
            if (adjacentVertices.containsKey(destination)) {
                return true;
            } else {
                return false;
            }
        }

        public double getEdgeWeight(Vertex<V> neighbor) {
            return adjacentVertices.get(neighbor);
        }
    }

    public void addVertex(V data) {
        vertices.put(data, new Vertex<>(data));
    }

    public void addEdge(V sourceKey, V destinationKey, double weight) {
        Vertex<V> source = vertices.get(sourceKey);
        Vertex<V> destination = vertices.get(destinationKey);
        source.addAdjacentVertex(destination, weight);
        destination.addAdjacentVertex(source, weight);
    }

    public boolean hasEdge(V sourceKey, V destinationKey) {
        Vertex<V> source = vertices.get(sourceKey);
        Vertex<V> destination = vertices.get(destinationKey);
        if (source.hasEdge(destination) || destination.hasEdge(source)) {
            return true;
        }
        return false;
    }

}