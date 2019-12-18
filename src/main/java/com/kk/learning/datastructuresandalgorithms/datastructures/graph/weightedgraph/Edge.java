package com.kk.learning.datastructuresandalgorithms.datastructures.graph.weightedgraph;

public class Edge {
    private int weight;
    private VNode destination;

    public Edge(int weight, VNode destination) {
        this.weight = weight;
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public VNode getDestination() {
        return destination;
    }
}
