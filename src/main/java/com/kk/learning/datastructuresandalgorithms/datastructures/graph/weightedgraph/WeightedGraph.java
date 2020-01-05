package com.kk.learning.datastructuresandalgorithms.datastructures.graph.weightedgraph;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

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
        Map<VNode, Path> nodeAndPath = new LinkedHashMap<>();

        for (VNode vertex : this.adjVertices) {
            if (!startNode.equals(vertex.getLabel())) {
                Path path = new Path(vertex, Integer.MAX_VALUE);
                minHeapQueue.add(path);
                nodeAndPath.put(vertex, path);
            } else {
                Path path = new Path(vertex, 0);
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
                    updateQueue(minHeapQueue);
                }
            }
        }

        return new ArrayList<>(nodeAndPath.values());
    }

    private void updateQueue(Queue<Path> minHeapQueue) {
        Path poll = minHeapQueue.poll();
        minHeapQueue.add(poll);
    }


    public List<Path> shortestPathUsingBellmanFord(String startNodeStr) {
        Map<VNode, Path> nodeAndPath = new LinkedHashMap<>();

        for (VNode vertex : this.adjVertices) {
            if (!startNodeStr.equals(vertex.getLabel())) {
                Path path = new Path(vertex, Integer.MAX_VALUE);
                nodeAndPath.put(vertex, path);
            } else {
                Path path = new Path(vertex, 0);
                nodeAndPath.put(vertex, path);
            }

        }

        List<Pair> edgePairs = adjVertices.stream().flatMap(vNode ->
                vNode.getEdges().stream().map(edge -> new Pair(vNode, edge))
        ).collect(Collectors.toList());

        for (int i = 0; i < this.adjVertices.size() - 1; i++) {
            for (Pair<VNode, Edge> edgePair : edgePairs) {
                VNode currentNode = edgePair.getKey();
                Edge edge = edgePair.getValue();

                Path pathToNeighbour = nodeAndPath.get(edge.getDestination());
                Integer currentNodeDistance = nodeAndPath.get(currentNode).getShortestDistance();

                Integer distanceFormCurrentNodeToNeighbour = currentNodeDistance != Integer.MAX_VALUE ? currentNodeDistance + edge.getWeight() : currentNodeDistance;
                if (distanceFormCurrentNodeToNeighbour < pathToNeighbour.getShortestDistance()) {
                    pathToNeighbour.setShortestDistance(distanceFormCurrentNodeToNeighbour);
                    pathToNeighbour.setParent(currentNode);
                }

            }
        }
        for (Pair<VNode, Edge> edgePair : edgePairs) {
            VNode currentNode = edgePair.getKey();
            Edge edge = edgePair.getValue();
            Path currentNodePath = nodeAndPath.get(currentNode);
            Integer currentNodeDistance = currentNodePath.getShortestDistance();

            Path neighbourPath = nodeAndPath.get(edge.getDestination());
            int distanceFromCurrentNodeToNeighbur = currentNodeDistance + edge.getWeight();

            if (distanceFromCurrentNodeToNeighbur < neighbourPath.getShortestDistance()
                    && distanceFromCurrentNodeToNeighbur != neighbourPath.getShortestDistance()) {
                throw new RuntimeException("Graph has Negative Cycle");
            }
        }
        return new ArrayList<>(nodeAndPath.values());
    }
}
