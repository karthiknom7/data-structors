package com.kk.learning.datastructuresandalgorithms.datastructures.graph.weightedgraph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WeightedGraph {
    private Set<VNode> adjVertices;

    public WeightedGraph() {
        adjVertices = new HashSet<>();
    }

    public void addVertex(String label){
        VNode vertex = new VNode(label);
        if(!adjVertices.contains(vertex)){
            adjVertices.add(vertex);
        }
    }

    public VNode getVertex(String label){
        return adjVertices.stream()
                .filter(vNode -> vNode.getLabel().equals(label))
                .findFirst().orElse(null);
    }

    public void removeVertex(String label){
        adjVertices.remove(new VNode(label));
    }


    public void addEdge(String src, String dest, int weight) {
        VNode srcVertex = new VNode(src);
        VNode destVertex = new VNode(dest);

        if(!adjVertices.contains(srcVertex) || !adjVertices.contains(destVertex)){
            throw new IllegalArgumentException("Given vertex(ices) not added");
        }

        Edge edge = new Edge(weight, destVertex);
        adjVertices.stream()
                .filter(v -> v.getLabel().equals(src))
                .forEach(vNode -> vNode.addEdge(edge));
    }


}
