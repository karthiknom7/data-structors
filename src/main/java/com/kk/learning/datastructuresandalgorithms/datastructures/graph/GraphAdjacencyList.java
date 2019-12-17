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

    public void addVertex(String label){
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<Vertex>());
    }

    public void addEdge(String lable1, String lable2){
        Vertex vertex1 = new Vertex(lable1);
        Vertex vertext2 = new Vertex(lable2);
        if(!adjVertices.containsKey(vertex1) || !adjVertices.containsKey(vertext2)){
            throw new IllegalArgumentException("Given vertex(ices) not added");
        }
        adjVertices.get(vertex1).add(vertext2);
        adjVertices.get(vertext2).add(vertex1);
    }


    public void removeVertex(String lable) {
        Vertex vertex = new Vertex(lable);
        adjVertices.values().stream().forEach(e -> e.remove(vertex));
        adjVertices.remove(vertex);
    }

    public void removeEdge(String lable1, String lable2){
        Vertex vertex1 = new Vertex(lable1);
        Vertex vertex2 = new Vertex(lable2);
        if(!adjVertices.containsKey(vertex1) || !adjVertices.containsKey(vertex2)){
            throw new IllegalArgumentException("Given vertex(ices) not added");
        }
        adjVertices.get(vertex1).remove(vertex2);
        adjVertices.get(vertex2).remove(vertex1);
    }

    public Set<String> breadthFirstTraverse(String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()){
            String vertex = queue.poll();
            List<Vertex> vertices = adjVertices.get(new Vertex(vertex));
            for(Vertex v : vertices){
                if(!visited.contains(v.getLable())){
                    queue.add(v.getLable());
                    visited.add(v.getLable());
                }
            }
        }
        return visited;
    }
}
