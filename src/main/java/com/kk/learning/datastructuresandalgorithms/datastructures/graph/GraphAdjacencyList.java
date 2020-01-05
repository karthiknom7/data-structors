package com.kk.learning.datastructuresandalgorithms.datastructures.graph;

import java.util.*;

public class GraphAdjacencyList {
    private Map<Vertex, List<Vertex>> adjVertices;

    public GraphAdjacencyList() {
        adjVertices = new HashMap<>();
    }

    public Map<Vertex, List<Vertex>> getAdjVertices() {
        return adjVertices;
    }

    public void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<Vertex>());
    }

    public void addBiDirectionalEdge(String label1, String label2) {
        Vertex vertex1 = new Vertex(label1);
        Vertex vertext2 = new Vertex(label2);
        if (!adjVertices.containsKey(vertex1) || !adjVertices.containsKey(vertext2)) {
            throw new IllegalArgumentException("Given vertex(ices) not added");
        }
        adjVertices.get(vertex1).add(vertext2);
        adjVertices.get(vertext2).add(vertex1);
    }

    public void addSingleDirectionalEdge(String label1, String label2) {
        Vertex vertex1 = new Vertex(label1);
        Vertex vertex2 = new Vertex(label2);
        if (!adjVertices.containsKey(vertex1) || !adjVertices.containsKey(vertex2)) {
            throw new IllegalArgumentException("Given vertex(ices) not added");
        }
        adjVertices.get(vertex1).add(vertex2);
    }


    public void removeVertex(String label) {
        Vertex vertex = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(vertex));
        adjVertices.remove(vertex);
    }

    public void removeBiDirectionalEdge(String label1, String label2) {
        Vertex vertex1 = new Vertex(label1);
        Vertex vertex2 = new Vertex(label2);
        if (!adjVertices.containsKey(vertex1) || !adjVertices.containsKey(vertex2)) {
            throw new IllegalArgumentException("Given vertex(ices) not added");
        }
        adjVertices.get(vertex1).remove(vertex2);
        adjVertices.get(vertex2).remove(vertex1);
    }

    public Set<String> breadthFirstTraverse(String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                List<Vertex> vertices = adjVertices.get(new Vertex(vertex));
                for (Vertex v : vertices) {
                    queue.add(v.getLable());
                }
            }
        }
        return visited;
    }

    public Set<String> depthFirstTraverse(String root) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                List<Vertex> adjacentVertices = adjVertices.get(new Vertex(vertex));
                for (Vertex v : adjacentVertices) {
                    stack.push(v.getLable());
                }
            }
        }
        return visited;
    }

    public Set<String> topologicalSort(String root) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<String>();
        for (Vertex v : adjVertices.keySet()) {
            topologicalTraverse(v, stack, visited);
        }
        Set<String> sortOrder = new LinkedHashSet<>();
        while (!stack.isEmpty()) {
            sortOrder.add(stack.pop());
        }
        return sortOrder;
    }

    private void topologicalTraverse(Vertex v, Stack<String> stack, Set<String> visited) {
        if (!visited.contains(v.getLable())) {
            visited.add(v.getLable());
            List<Vertex> vertices = adjVertices.get(v);
            if (!vertices.isEmpty()) {
                for (Vertex neighbourVertex : vertices) {
                    topologicalTraverse(neighbourVertex, stack, visited);
                }
            }
            stack.push(v.getLable());
        }
    }
}
