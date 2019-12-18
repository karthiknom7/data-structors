package com.kk.learning.datastructuresandalgorithms.datastructures.graph;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class GraphAdjacencyListTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldAddVertex() {
        GraphAdjacencyList graphAdjacencyList = new GraphAdjacencyList();
        graphAdjacencyList.addVertex("Karthik");
        assertTrue(graphAdjacencyList.getAdjVertices().containsKey(new Vertex("Karthik")));
    }


    @Test
    public void shouldThrowAnExceptionIfGivenVertexIsNotPresentWhileAddingEdges() {
        GraphAdjacencyList graphAdjacencyList = new GraphAdjacencyList();
        graphAdjacencyList.addVertex("Karthik");
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Given vertex(ices) not added");
        graphAdjacencyList.addBiDirectionalEdge("Karthik", "Juttiii");
    }

    @Test
    public void shouldAddEdgesForVertices() {
        GraphAdjacencyList graphAdjacencyList = new GraphAdjacencyList();
        String karthik = "Karthik";
        String juttiii = "Juttiii";
        String ram = "Ram";
        graphAdjacencyList.addVertex(karthik);
        graphAdjacencyList.addVertex(juttiii);
        graphAdjacencyList.addVertex(ram);;

        graphAdjacencyList.addBiDirectionalEdge(karthik, juttiii);
        graphAdjacencyList.addBiDirectionalEdge(karthik, ram);
        Map<Vertex, List<Vertex>> adjVertices = graphAdjacencyList.getAdjVertices();
        assertTrue(adjVertices.get(new Vertex(karthik)).contains(new Vertex(juttiii)));
        assertTrue(adjVertices.get(new Vertex(karthik)).contains(new Vertex(ram)));
        assertTrue(adjVertices.get(new Vertex(ram)).contains(new Vertex(karthik)));
        assertTrue(adjVertices.get(new Vertex(juttiii)).contains(new Vertex(karthik)));
    }


    @Test
    public void shouldAddSingleEdgeForVertices() {
        GraphAdjacencyList graphAdjacencyList = new GraphAdjacencyList();
        String karthik = "Karthik";
        String juttiii = "Juttiii";
        String ram = "Ram";
        graphAdjacencyList.addVertex(karthik);
        graphAdjacencyList.addVertex(juttiii);
        graphAdjacencyList.addVertex(ram);

        graphAdjacencyList.addSingleDirectionalEdge(karthik, juttiii);
        graphAdjacencyList.addSingleDirectionalEdge(karthik, ram);
        Map<Vertex, List<Vertex>> adjVertices = graphAdjacencyList.getAdjVertices();
        assertTrue(adjVertices.get(new Vertex(karthik)).contains(new Vertex(juttiii)));
        assertTrue(adjVertices.get(new Vertex(karthik)).contains(new Vertex(ram)));
        assertFalse(adjVertices.get(new Vertex(ram)).contains(new Vertex(karthik)));
        assertFalse(adjVertices.get(new Vertex(juttiii)).contains(new Vertex(karthik)));
    }

    @Test
    public void shouldRemoveVertices() {
        GraphAdjacencyList graphAdjacencyList = new GraphAdjacencyList();
        String karthik = "Karthik";
        String juttiii = "Juttiii";
        String ram = "Ram";
        graphAdjacencyList.addVertex(karthik);
        graphAdjacencyList.addVertex(juttiii);
        graphAdjacencyList.addVertex(ram);

        graphAdjacencyList.addBiDirectionalEdge(karthik, juttiii);
        graphAdjacencyList.addBiDirectionalEdge(karthik, ram);
        graphAdjacencyList.removeVertex(ram);
        Map<Vertex, List<Vertex>> adjVertices = graphAdjacencyList.getAdjVertices();
        assertTrue(adjVertices.get(new Vertex(karthik)).contains(new Vertex(juttiii)));
        assertFalse(adjVertices.get(new Vertex(karthik)).contains(new Vertex(ram)));
        assertFalse(adjVertices.containsKey(new Vertex(ram)));
        assertTrue(adjVertices.get(new Vertex(juttiii)).contains(new Vertex(karthik)));
    }

    @Test
    public void shouldremoveEdgesForVertices() {
        GraphAdjacencyList graphAdjacencyList = new GraphAdjacencyList();
        String karthik = "Karthik";
        String juttiii = "Juttiii";
        String ram = "Ram";
        graphAdjacencyList.addVertex(karthik);
        graphAdjacencyList.addVertex(juttiii);
        graphAdjacencyList.addVertex(ram);

        graphAdjacencyList.addBiDirectionalEdge(karthik, juttiii);
        graphAdjacencyList.addBiDirectionalEdge(karthik, ram);
        graphAdjacencyList.removeBiDirectionalEdge(karthik,ram);
        Map<Vertex, List<Vertex>> adjVertices = graphAdjacencyList.getAdjVertices();
        assertTrue(adjVertices.get(new Vertex(karthik)).contains(new Vertex(juttiii)));
        assertFalse(adjVertices.get(new Vertex(karthik)).contains(new Vertex(ram)));
        assertFalse(adjVertices.get(new Vertex(ram)).contains(new Vertex(karthik)));
        assertTrue(adjVertices.get(new Vertex(juttiii)).contains(new Vertex(karthik)));
    }


    @Test
    public void shouldTraverseBFT() {
        GraphAdjacencyList graph = new GraphAdjacencyList();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addBiDirectionalEdge("Bob", "Alice");
        graph.addBiDirectionalEdge("Bob", "Rob");
        graph.addBiDirectionalEdge("Alice", "Mark");
        graph.addBiDirectionalEdge("Rob", "Mark");
        graph.addBiDirectionalEdge("Alice", "Maria");
        graph.addBiDirectionalEdge("Rob", "Maria");

        Set<String> output = graph.breadthFirstTraverse("Bob");

        assertEquals("[Bob, Alice, Rob, Mark, Maria]", output.toString());

    }

    @Test
    public void shouldTraverseBFT2() {
        GraphAdjacencyList graph = new GraphAdjacencyList();
        graph.addVertex("k");
        graph.addVertex("j");
        graph.addVertex("r");
        graph.addVertex("m");
        graph.addVertex("p");
        graph.addVertex("l");
        graph.addVertex("n");
        graph.addBiDirectionalEdge("k", "j");
        graph.addBiDirectionalEdge("k", "r");
        graph.addBiDirectionalEdge("r", "l");
        graph.addBiDirectionalEdge("l", "n");
        graph.addBiDirectionalEdge("n", "m");
        graph.addBiDirectionalEdge("m", "j");
        graph.addBiDirectionalEdge("j", "p");
        graph.addBiDirectionalEdge("n", "p");

        Set<String> output = graph.breadthFirstTraverse("k");

        assertEquals("[k, j, r, m, p, l, n]", output.toString());

    }



    @Test
    public void shouldTraverseBFT3() {
        GraphAdjacencyList graph = new GraphAdjacencyList();
        graph.addVertex("k");
        graph.addVertex("j");
        graph.addVertex("r");
        graph.addVertex("m");
        graph.addVertex("p");

        graph.addBiDirectionalEdge("k", "j");
        graph.addBiDirectionalEdge("k", "r");
        graph.addBiDirectionalEdge("r", "m");
        graph.addBiDirectionalEdge("m", "p");
        graph.addBiDirectionalEdge("p", "j");


        Set<String> output = graph.breadthFirstTraverse("k");

        assertEquals("[k, j, r, p, m]", output.toString());

    }


    @Test
    public void shouldTraverseDFT() {
        GraphAdjacencyList graph = new GraphAdjacencyList();
        graph.addVertex("k");
        graph.addVertex("j");
        graph.addVertex("r");
        graph.addVertex("m");
        graph.addVertex("p");
        graph.addVertex("l");
        graph.addVertex("n");
        graph.addBiDirectionalEdge("k", "j");
        graph.addBiDirectionalEdge("k", "r");
        graph.addBiDirectionalEdge("r", "l");
        graph.addBiDirectionalEdge("l", "n");
        graph.addBiDirectionalEdge("n", "m");
        graph.addBiDirectionalEdge("m", "j");
        graph.addBiDirectionalEdge("j", "p");
        graph.addBiDirectionalEdge("n", "p");

        Set<String> output = graph.depthFirstTraverse("k");

        assertEquals("[k, r, l, n, p, j, m]", output.toString());

    }

    @Test
    public void shouldTraverseDFT2() {
        GraphAdjacencyList graph = new GraphAdjacencyList();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addBiDirectionalEdge("Bob", "Alice");
        graph.addBiDirectionalEdge("Bob", "Rob");
        graph.addBiDirectionalEdge("Alice", "Mark");
        graph.addBiDirectionalEdge("Rob", "Mark");
        graph.addBiDirectionalEdge("Alice", "Maria");
        graph.addBiDirectionalEdge("Rob", "Maria");

        Set<String> output = graph.depthFirstTraverse("Bob");

        assertEquals("[Bob, Rob, Maria, Alice, Mark]", output.toString());

    }

    @Test
    public void shouldReturnSimpleTopologicalSort() {
        GraphAdjacencyList graph = new GraphAdjacencyList();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("F");

        graph.addSingleDirectionalEdge("A", "B");
        graph.addSingleDirectionalEdge("A", "C");
        graph.addSingleDirectionalEdge("C", "B");
        graph.addSingleDirectionalEdge("B", "F");


        Set<String> output = graph.topologicalSort("A");

        assertEquals("[A, C, B, F]", output.toString());

    }


    @Test
    public void shouldReturnComplexTopologicalSort() {
        GraphAdjacencyList graph = new GraphAdjacencyList();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("F");
        graph.addVertex("K");

        graph.addSingleDirectionalEdge("A", "K");
        graph.addSingleDirectionalEdge("A", "D");
        graph.addSingleDirectionalEdge("K", "B");
        graph.addSingleDirectionalEdge("K", "C");
        graph.addSingleDirectionalEdge("B", "D");
        graph.addSingleDirectionalEdge("C", "D");
        graph.addSingleDirectionalEdge("D", "F");

        Set<String> output = graph.topologicalSort("A");

        assertEquals("[A, K, C, B, D, F]", output.toString());

    }

}