import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MyGraph {
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
    }

}