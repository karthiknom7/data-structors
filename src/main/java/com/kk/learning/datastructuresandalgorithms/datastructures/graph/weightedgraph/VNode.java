package com.kk.learning.datastructuresandalgorithms.datastructures.graph.weightedgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VNode {
    private String label;
    private List<Edge> edges;

    public VNode(String label) {
        this.label = label;
        edges = new ArrayList<>();
    }

    public void addEdge(Edge edge){
        edges.add(edge);
    }

    public String getLabel() {
        return label;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VNode vNode = (VNode) o;
        return Objects.equals(label, vNode.label);
    }

    @Override
    public int hashCode() {

        return Objects.hash(label);
    }
}
