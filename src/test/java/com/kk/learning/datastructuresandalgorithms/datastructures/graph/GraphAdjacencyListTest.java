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
        graphAdjacencyList.addEdge("Karthik", "Juttiii");
    }

    @Test
    public void shouldAddEdgesForVertices() {
        GraphAdjacencyList graphAdjacencyList = new GraphAdjacencyList();
        String karthik = "Karthik";
        graphAdjacencyList.addVertex(karthik);
        String juttiii = "Juttiii";
        graphAdjacencyList.addVertex(juttiii);
        String ram = "Ram";
        graphAdjacencyList.addVertex(ram);

        graphAdjacencyList.addEdge(karthik, juttiii);
        graphAdjacencyList.addEdge(karthik, ram);
        Map<Vertex, List<Vertex>> adjVertices = graphAdjacencyList.getAdjVertices();
        assertTrue(adjVertices.get(new Vertex(karthik)).contains(new Vertex(juttiii)));
        assertTrue(adjVertices.get(new Vertex(karthik)).contains(new Vertex(ram)));
        assertTrue(adjVertices.get(new Vertex(ram)).contains(new Vertex(karthik)));
        assertTrue(adjVertices.get(new Vertex(juttiii)).contains(new Vertex(karthik)));
    }

    @Test
    public void shouldRemoveVertices() {
        GraphAdjacencyList graphAdjacencyList = new GraphAdjacencyList();
        String karthik = "Karthik";
        graphAdjacencyList.addVertex(karthik);
        String juttiii = "Juttiii";
        graphAdjacencyList.addVertex(juttiii);
        String ram = "Ram";
        graphAdjacencyList.addVertex(ram);

        graphAdjacencyList.addEdge(karthik, juttiii);
        graphAdjacencyList.addEdge(karthik, ram);
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
        graphAdjacencyList.addVertex(karthik);
        String juttiii = "Juttiii";
        graphAdjacencyList.addVertex(juttiii);
        String ram = "Ram";
        graphAdjacencyList.addVertex(ram);

        graphAdjacencyList.addEdge(karthik, juttiii);
        graphAdjacencyList.addEdge(karthik, ram);
        graphAdjacencyList.removeEdge(karthik,ram);
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
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");

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
        graph.addEdge("k", "j");
        graph.addEdge("k", "r");
        graph.addEdge("r", "l");
        graph.addEdge("l", "n");
        graph.addEdge("n", "m");
        graph.addEdge("m", "j");
        graph.addEdge("j", "p");
        graph.addEdge("n", "p");

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

        graph.addEdge("k", "j");
        graph.addEdge("k", "r");
        graph.addEdge("r", "m");
        graph.addEdge("m", "p");
        graph.addEdge("p", "j");


        Set<String> output = graph.breadthFirstTraverse("k");

        assertEquals("[k, j, r, p, m]", output.toString());

    }

}