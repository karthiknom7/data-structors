package com.kk.learning.datastructuresandalgorithms.datastructures.graph.weightedgraph;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class WeightedGraphTest {


    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Test
    public void shouldAddVertexToTheGraph() {
        WeightedGraph weightedGraph = new WeightedGraph();
        weightedGraph.addVertex("k");
        assertEquals(new VNode("k"),weightedGraph.getVertex("k"));
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
        assertEquals(new VNode("n"),vertex.getEdges().get(0).getDestination());
        assertEquals(3,vertex.getEdges().get(0).getWeight());
    }


}