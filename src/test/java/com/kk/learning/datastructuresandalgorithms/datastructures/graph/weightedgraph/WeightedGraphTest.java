package com.kk.learning.datastructuresandalgorithms.datastructures.graph.weightedgraph;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WeightedGraphTest {


    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldAddVertexToTheGraph() {
        WeightedGraph weightedGraph = new WeightedGraph();
        weightedGraph.addVertex("k");
        assertEquals(new VNode("k"), weightedGraph.getVertex("k"));
    }

    @Test
    public void shouldThrowExceptionWhileAddingEdgeifAnyVertexIsMissing() {
        WeightedGraph weightedGraph = new WeightedGraph();
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Given vertex(ices) not added");
        weightedGraph.addEdge("src", "dest", 5);
    }

    @Test
    public void shouldAddEdgeToTheTwoVertices() {
        WeightedGraph weightedGraph = new WeightedGraph();
        weightedGraph.addVertex("k");
        weightedGraph.addVertex("n");

        weightedGraph.addEdge("k", "n", 3);

        VNode vertex = weightedGraph.getVertex("k");
        assertEquals(new VNode("n"), vertex.getEdges().get(0).getDestination());
        assertEquals(3, vertex.getEdges().get(0).getWeight());
    }


    @Test
    public void shouldFindShortestPathForAllVerteciesUsingDijkstra() {
        WeightedGraph weightedGraph = new WeightedGraph();
        weightedGraph.addVertex("A");
        weightedGraph.addVertex("B");
        weightedGraph.addVertex("C");

        weightedGraph.addEdge("A", "B", 2);
        weightedGraph.addEdge("A", "C", 4);
        weightedGraph.addEdge("B", "C", 1);
        List<Path> paths = weightedGraph.shortestPathUsingDijkstra("A");
        System.out.println(paths);
        assertEquals(3, paths.size());
        assertEquals("[Path{currentNode=A, shortestDistance=0, parent=null}, Path{currentNode=B, shortestDistance=2, parent=A}, Path{currentNode=C, shortestDistance=3, parent=B}]", paths.toString());
    }

    @Test
    public void shouldFindShortestPathForAllVerteciesUsingDijkstra2() {
        WeightedGraph weightedGraph = new WeightedGraph();
        weightedGraph.addVertex("A");
        weightedGraph.addVertex("B");
        weightedGraph.addVertex("C");
        weightedGraph.addVertex("D");
        weightedGraph.addVertex("E");

        weightedGraph.addEdge("E", "B", 4);
        weightedGraph.addEdge("E", "D", 2);
        weightedGraph.addEdge("D", "C", 1);
        weightedGraph.addEdge("D", "B", 1);
        weightedGraph.addEdge("C", "D", 2);
        weightedGraph.addEdge("B", "A", 3);
        weightedGraph.addEdge("A", "D", 6);
        weightedGraph.addEdge("A", "C", 6);

        List<Path> paths = weightedGraph.shortestPathUsingDijkstra("E");
        System.out.println(paths);
        assertEquals(5, paths.size());
    }
}