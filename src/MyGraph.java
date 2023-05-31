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
    }

}