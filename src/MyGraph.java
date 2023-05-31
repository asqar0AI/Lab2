import java.util.*;

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

    public void removeEdge(V sourceKey, V destinationKey) {
        Vertex<V> source = vertices.get(sourceKey);
        Vertex<V> destination = vertices.get(destinationKey);
        source.removeAdjacentVertex(destination);
        destination.removeAdjacentVertex(source);
    }

    public List<Vertex<V>> getNeighbours(V key) {
        Vertex<V> vertex = vertices.get(key);
        return vertex.getNeighbours();
    }

    public void BFS(V startKey) {
        Vertex<V> start = vertices.get(startKey);
        Map<Vertex<V>, Boolean> visited = new HashMap<>();
        Queue<Vertex<V>> q = new LinkedList<>();

        q.add(start);
        while (!q.isEmpty()) {
            Vertex<V> current = q.poll();
            visited.put(current, true);
            System.out.print(current.getData() + " ");
            ArrayList<Vertex<V>> neighbours = (ArrayList<Vertex<V>>) current.getNeighbours();
            for (Vertex<V> vertex : neighbours) {
                if (!visited.containsKey(vertex)) {
                    q.add(vertex);
                    visited.put(vertex, true);
                }
            }
        }

    }

    public void Dijkstra(V start) {
        if (!vertices.containsKey(start)) {
            System.out.println("Start vertex does not exist in the graph.");
            return;
        }

        Vertex<V> startVertex = vertices.get(start);

        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> previousVertices = new HashMap<>();

        for (Vertex<V> vertex : vertices.values()) {
            if (vertex.equals(startVertex)) {
                distances.put(vertex, 0.0);
            } else {
                distances.put(vertex, Double.POSITIVE_INFINITY);
            }
        }

        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();

            if (distances.get(currentVertex) == Double.POSITIVE_INFINITY) {
                break;
            }

            for (Vertex<V> neighbor : currentVertex.getNeighbours()) {
                double edgeWeight = currentVertex.getEdgeWeight(neighbor);
                double distance = distances.get(currentVertex) + edgeWeight;

                if (distance < distances.get(neighbor)) {
                    distances.put(neighbor, distance);
                    previousVertices.put(neighbor, currentVertex);
                    queue.remove(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        for (Vertex<V> vertex : vertices.values()) {
            if (vertex.equals(startVertex)) {
                System.out.println("Shortest path from " + start + " to " + vertex.getData() + ":");
                System.out.println(start + " (Distance: 0)");
            } else if (previousVertices.containsKey(vertex)) {
                List<Vertex<V>> path = new ArrayList<>();
                Vertex<V> current = vertex;
                while (current != null) {
                    path.add(0, current);
                    current = previousVertices.get(current);
                }
                StringBuilder pathString = new StringBuilder();
                for (Vertex<V> v : path) {
                    pathString.append(v.getData()).append(" -> ");
                }
                pathString.delete(pathString.length() - 4, pathString.length());
                System.out.println("Shortest path from " + start + " to " + vertex.getData() + ":");
                System.out.println(pathString.toString() + " (Distance: " + distances.get(vertex) + ")");
            } else {
                System.out.println("There is no path from " + start + " to " + vertex.getData());
            }
        }
    }
}