package com.kk.learning.datastructuresandalgorithms.datastructures.graph.weightedgraph;

import java.util.*;

public class WeightedGraph {
    private Set<VNode> adjVertices;

    public WeightedGraph() {
        adjVertices = new HashSet<>();
    }

    public void addVertex(String label) {
        VNode vertex = new VNode(label);
        if (!adjVertices.contains(vertex)) {
            adjVertices.add(vertex);
        }
    }

    public VNode getVertex(String label) {
        return adjVertices.stream()
                .filter(vNode -> vNode.getLabel().equals(label))
                .findFirst().orElse(null);
    }

    public void removeVertex(String label) {
        adjVertices.remove(new VNode(label));
    }


    public void addEdge(String src, String dest, int weight) {
        VNode srcVertex = new VNode(src);
        VNode destVertex = new VNode(dest);

        if (!adjVertices.contains(srcVertex) || !adjVertices.contains(destVertex)) {
            throw new IllegalArgumentException("Given vertex(ices) not added");
        }

        Edge edge = new Edge(weight, destVertex);
        adjVertices.stream()
                .filter(v -> v.getLabel().equals(src))
                .forEach(vNode -> vNode.addEdge(edge));
    }


    public List<Path> shortestPathUsingDijkstra(String startNode) {
        Queue<Path> minHeapQueue = new PriorityQueue<>(Comparator.comparing(Path::getShortestDistance));

        VNode startNodeFound = this.adjVertices.stream().filter(vNode -> startNode.equals(vNode.getLabel())).findFirst().get();
        Path startNodePath = new Path(startNodeFound, 0);

        Map<VNode, Path> nodeAndPath = new LinkedHashMap<>();
        nodeAndPath.put(startNodeFound, startNodePath);
        minHeapQueue.add(startNodePath);

        for (VNode vertex : this.adjVertices) {
            if (!vertex.equals(startNodeFound)) {
                Path path = new Path(vertex, Integer.MAX_VALUE);
                minHeapQueue.add(path);
                nodeAndPath.put(vertex, path);
            }
        }

        while (!minHeapQueue.isEmpty()) {
            Path currentNodePath = minHeapQueue.poll();
            VNode currentNode = currentNodePath.getCurrentNode();
            List<Edge> edges = currentNode.getEdges();
            for (Edge edge : edges) {
                VNode neighbour = edge.getDestination();
                Path neighbourPath = nodeAndPath.get(neighbour);
                int neighbourDistance = neighbourPath.getShortestDistance();

                int distance = currentNodePath.getShortestDistance() + edge.getWeight();
                if (distance < neighbourDistance) {
                    neighbourPath.setShortestDistance(distance);
                    neighbourPath.setParent(currentNode);
                }
            }
        }

        return new ArrayList<>(nodeAndPath.values());
    }
}
