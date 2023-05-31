import java.util.*;

/**
 * The MyGraph class represents a generic graph data structure.
 * It supports operations such as adding vertices, adding edges, checking for edges,
 * removing edges, retrieving neighbors, performing Breadth-First Search (BFS),
 * and finding the shortest path using Dijkstra's algorithm.
 *
 */
public class MyGraph<V> {
    private Map<V, Vertex<V>> vertices;

    /**
     * Constructs an empty MyGraph object.
     * Initializes the vertices map.
     */
    public MyGraph() {
        vertices = new HashMap<V, Vertex<V>>();
    }

    private class Vertex<V> {
        private V data;
        private Map<Vertex<V>, Double> adjacentVertices;

        /**
         * Constructs a vertex with the given data.
         * Initializes the map of adjacent vertices.
         *
         */
        public Vertex(V data) {
            this.data = data;
            adjacentVertices = new HashMap<>();
        }

        /**
         * Adds an adjacent vertex with the specified weight.
         */
        public void addAdjacentVertex(Vertex<V> destination, double weight) {
            adjacentVertices.put(destination, weight);
        }

        /**
         * Removes the specified adjacent vertex from the vertex's neighbors.
         */
        public void removeAdjacentVertex(Vertex<V> destination) {
            adjacentVertices.remove(destination);
        }

        /**
         * Retrieves the data associated with the vertex.
         */
        public V getData() {
            return data;
        }

        /**
         * Retrieves a list of neighboring vertices.
         */
        public List<Vertex<V>> getNeighbours() {
            ArrayList<Vertex<V>> neighbours = new ArrayList<>();
            for (Vertex<V> vertex : adjacentVertices.keySet()) {
                neighbours.add(vertex);
            }
            return neighbours;
        }

        /**
         * Checks if an edge exists between the vertex and the specified destination vertex.
         */
        public boolean hasEdge(Vertex<V> destination) {
            if (adjacentVertices.containsKey(destination)) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * Retrieves the weight of the edge between the vertex and the specified neighbor vertex.
         */
        public double getEdgeWeight(Vertex<V> neighbor) {
            return adjacentVertices.get(neighbor);
        }
    }

    /**
     * Adds a vertex with the specified data to the graph.
     */
    public void addVertex(V data) {
        vertices.put(data, new Vertex<>(data));
    }

    /**
     * Adds an edge between the source and destination vertices with the specified weight.
     */
    public void addEdge(V sourceKey, V destinationKey, double weight) {
        Vertex<V> source = vertices.get(sourceKey);
        Vertex<V> destination = vertices.get(destinationKey);
        source.addAdjacentVertex(destination, weight);
        destination.addAdjacentVertex(source, weight);
    }

    /**
     * Checks if an edge exists between the source and destination vertices.
     */
    public boolean hasEdge(V sourceKey, V destinationKey) {
        Vertex<V> source = vertices.get(sourceKey);
        Vertex<V> destination = vertices.get(destinationKey);
        if (source.hasEdge(destination) || destination.hasEdge(source)) {
            return true;
        }
        return false;
    }

    /**
     * Removes the edge between the source and destination vertices.
     */
    public void removeEdge(V sourceKey, V destinationKey) {
        Vertex<V> source = vertices.get(sourceKey);
        Vertex<V> destination = vertices.get(destinationKey);
        source.removeAdjacentVertex(destination);
        destination.removeAdjacentVertex(source);
    }

    /**
     * Retrieves a list of neighboring vertices for the vertex associated with the specified key.
     */
    public List<Vertex<V>> getNeighbours(V key) {
        Vertex<V> vertex = vertices.get(key);
        return vertex.getNeighbours();
    }

    /**
     * Performs Breadth-First Search (BFS) starting from the vertex associated with the specified key.
     * It visits all the vertices reachable from the starting vertex and prints them in BFS order.
     */
    public void BFS(V startKey) {
        // Get the starting vertex
        Vertex<V> start = vertices.get(startKey);

        // Keep track of visited vertices
        Map<Vertex<V>, Boolean> visited = new HashMap<>();

        // Create a queue for BFS traversal
        Queue<Vertex<V>> q = new LinkedList<>();

        // Enqueueing starting vertex
        q.add(start);

        // Perform BFS
        while (!q.isEmpty()) {
            // Dequeue a vertex from the queue and print it
            Vertex<V> current = q.poll();
            visited.put(current, true);
            System.out.print(current.getData() + " ");

            // Get the neighbors of the current vertex
            ArrayList<Vertex<V>> neighbours = (ArrayList<Vertex<V>>) current.getNeighbours();

            // Visit all the unvisited neighbors and enqueue them
            for (Vertex<V> vertex : neighbours) {
                if (!visited.containsKey(vertex)) {
                    q.add(vertex);
                    visited.put(vertex, true);
                }
            }
        }

    }

    /**
     * Finds the shortest path using Dijkstra's algorithm starting from the vertex associated with the specified key.
     * It calculates the shortest path from the starting vertex to all other vertices in the graph.
     * The distances and shortest paths are printed for each vertex.
     */
    public void Dijkstra(V start) {
        // Check if the starting vertex exists in the graph
        if (!vertices.containsKey(start)) {
            System.out.println("Start vertex does not exist in the graph.");
            return;
        }

        // Get the starting vertex
        Vertex<V> startVertex = vertices.get(start);

        // Initialize distances and previous vertices maps
        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> previousVertices = new HashMap<>();

        // Initialize distances to all other vertices as positive infinity except the starting vertex as 0
        for (Vertex<V> vertex : vertices.values()) {
            if (vertex.equals(startVertex)) {
                distances.put(vertex, 0.0);
            } else {
                distances.put(vertex, Double.POSITIVE_INFINITY);
            }
        }

        // Create a priority queue based on distances
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        queue.add(startVertex);

        // Perform Dijkstra's algorithm
        while (!queue.isEmpty()) {
            // Extract the vertex with the smallest distance
            Vertex<V> currentVertex = queue.poll();

            // If the distance is infinity, there are no more reachable vertices
            if (distances.get(currentVertex) == Double.POSITIVE_INFINITY) {
                break;
            }

            // Iterate through the neighbors of the current vertex
            for (Vertex<V> neighbor : currentVertex.getNeighbours()) {
                // Calculate the distance from the starting vertex to the neighbor through the current vertex
                double edgeWeight = currentVertex.getEdgeWeight(neighbor);
                double distance = distances.get(currentVertex) + edgeWeight;

                // If the new distance is smaller, update the distance and previous vertex
                if (distance < distances.get(neighbor)) {
                    distances.put(neighbor, distance);
                    previousVertices.put(neighbor, currentVertex);

                    // Remove and add the neighbor to update its position in the priority queue
                    queue.remove(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        // Print the shortest paths and distances for each vertex
        for (Vertex<V> vertex : vertices.values()) {
            if (vertex.equals(startVertex)) {
                System.out.println("Shortest path from " + start + " to " + vertex.getData() + ":");
                System.out.println(start + " (Distance: 0)");
            } else if (previousVertices.containsKey(vertex)) {
                // Construct the shortest path by traversing the previous vertices map
                List<Vertex<V>> path = new ArrayList<>();
                Vertex<V> current = vertex;
                while (current != null) {
                    path.add(0, current);
                    current = previousVertices.get(current);
                }

                // Print the shortest path and distance for the current vertex
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

    /**
     * Prints the graph by displaying each vertex and its connected vertices.
     * It traverses through each vertex in the graph and prints its data along with its connected vertices.
     */
    public void printGraph() {
        for (Vertex<V> vertex : vertices.values()) {
            // Get the neighbors of the current vertex
            ArrayList<Vertex<V>> neighbours = (ArrayList<Vertex<V>>) vertex.getNeighbours();

            // Print the current vertex and its connected vertices
            System.out.print("Current Vertex -> " + vertex.getData() + "  Connected vertices: ");
            for (Vertex<V> neighbour : neighbours) {
                System.out.print(neighbour.getData() + " ");
            }
            System.out.println();
        }

    }
}