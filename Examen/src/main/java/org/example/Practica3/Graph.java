package org.example.Practica3;

public class Graph<V> {
    private Map<V, Set<V>> adjacencyList = new HashMap<>();
    public boolean addVertex(V v) {
        if (adjacencyList.containsKey(v)) {
            return false; // El vértice ya existe en el grafo
        }
        adjacencyList.put(v, new HashSet<V>());
        return true; // Vértice añadido correctamente
    }
    public boolean containsVertex(V v) {
        return adjacencyList.containsKey(v);
    }
    public Set<V> obtainAdjacents(V v) throws Exception {
        if (!containsVertex(v)) {
            throw new Exception("El vértice no existe en el grafo.");
        }
        return adjacencyList.get(v);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<V, Set<V>> entry : adjacencyList.entrySet()) {
            V vertex = entry.getKey();
            Set<V> adyacents = entry.getValue();
            sb.append(vertex).append(": ");
            sb.append(adyacents).append("\n");
        }
        return sb.toString();
    }
    public List<V> onePath(V v1, V v2) {
        Map<V, V> trace = new HashMap<>();
        Deque<V> openList = new LinkedList<>();
        openList.push(v1);
        trace.put(v1, null);
        boolean found = false;
        while (!openList.isEmpty() && !found) {
            V v = openList.pop();
            found = v.equals(v2);
            if (!found) {
                for (V adj : obtainAdjacents(v)) {
                    if (!trace.containsKey(adj)) {
                        openList.push(adj);
                        trace.put(adj, v);
                    }
                }
            }
        }
        if (found) {
            List<V> path = new ArrayList<>();
            V v = v2;
            while (v != null) {
                path.add(v);
                v = trace.get(v);
            }
            Collections.reverse(path);
            return path;
        } else {
            return null;
        }
    }


}
