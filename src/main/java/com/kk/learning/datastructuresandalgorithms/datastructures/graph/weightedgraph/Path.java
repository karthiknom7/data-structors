package com.kk.learning.datastructuresandalgorithms.datastructures.graph.weightedgraph;

import java.util.Optional;

public class Path {
    private VNode currentNode;
    private Integer shortestDistance;
    private VNode parent;

    public Path(VNode currentNode, Integer shortestDistance, VNode parent) {
        this.currentNode = currentNode;
        this.shortestDistance = shortestDistance;
        this.parent = parent;
    }

    public Path(VNode currentNode, Integer shortestDistance) {
        this.currentNode = currentNode;
        this.shortestDistance = shortestDistance;
    }

    public VNode getCurrentNode() {
        return currentNode;
    }


    public Integer getShortestDistance() {
        return shortestDistance;
    }

    public void setShortestDistance(Integer shortestDistance) {
        this.shortestDistance = shortestDistance;
    }

    public VNode getParent() {
        return parent;
    }

    public void setParent(VNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Path{" +
                "currentNode=" + currentNode.getLabel() +
                ", shortestDistance=" + shortestDistance +
                ", parent=" + Optional.ofNullable(parent).map(VNode::getLabel).orElse(null) +
                '}';
    }
}
