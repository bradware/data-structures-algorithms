import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * @author James Ruiz
 * @date The beginning of time
 * @element water
 * @weakness hugs
 */
public class MSTTest1 {

    AdjacencyList myAdjacencyList;
    List<Edge> myEdges = new ArrayList<Edge>();
    
    

    Vertex v1 = new Vertex("V1");
    Vertex v2 = new Vertex("V2");
    Vertex v3 = new Vertex("V3");
    Vertex v4 = new Vertex("V4");
    Vertex v5 = new Vertex("V5");
    Vertex v6 = new Vertex("V6");
    Vertex v7 = new Vertex("V7");

    @Before
    public void setUp() throws Exception {

        //Vertex 1 edges
        myEdges.add(new Edge(v2, v1, 2));
        myEdges.add(new Edge(v3, v1, 4));
        myEdges.add(new Edge(v4, v1, 1));

        //Vertex 2 edges
        myEdges.add(new Edge(v1, v2, 2));
        myEdges.add(new Edge(v4, v2, 3));
        myEdges.add(new Edge(v5, v2, 10));

        //Vertex 3 edges
        myEdges.add(new Edge(v1, v3, 4));
        myEdges.add(new Edge(v4, v3, 2));
        myEdges.add(new Edge(v6, v3, 5));


        //Vertex 4 edges
        myEdges.add(new Edge(v1, v4, 1));
        myEdges.add(new Edge(v2, v4, 3));
        myEdges.add(new Edge(v5, v4, 7));
        myEdges.add(new Edge(v7, v4, 4));
        myEdges.add(new Edge(v6, v4, 8));
        myEdges.add(new Edge(v3, v4, 2));

        //Vertex 5 edges
        myEdges.add(new Edge(v2, v5, 10));
        myEdges.add(new Edge(v4, v5, 7));
        myEdges.add(new Edge(v7, v5, 6));

        //Vertex 6 edges
        myEdges.add(new Edge(v3, v6, 5));
        myEdges.add(new Edge(v4, v6, 8));
        myEdges.add(new Edge(v7, v6, 1));


        //Vertex 7 edges
        myEdges.add(new Edge(v6, v7, 1));
        myEdges.add(new Edge(v4, v7, 4));
        myEdges.add(new Edge(v5, v7, 6));


        myAdjacencyList=new AdjacencyList(myEdges);

    }

    /*
     * SPECIAL NOTE: If you want to see your edges as vertices instead of pointers to memory locations
     * then modify the toString() in your Edge.java class to print the vertex's data. I highly
     * recommend this for debugging purposes. Edge.java is not a deliverable, so you are only doing
     * this for debugging purposes.
     */
    
    
    @Test
    public void testKruskals0() {
        Collection<Edge> testResult = MST.kruskals(myEdges);
        System.out.println("Kruskal's: Normal\n"+testResult.toString()+"\n");
        assertTrue(testResult.contains(myEdges.get(3)));
        assertTrue(testResult.contains(myEdges.get(0)));
        assertTrue(testResult.contains(myEdges.get(14)));
        assertTrue(testResult.contains(myEdges.get(21)));
        assertTrue(testResult.contains(myEdges.get(23)));
    }
    @Test
    public void testKruskals1() {
        Collection<Edge> testResult = MST.kruskals(null);
        System.out.println("Kruskal's: null Edges\n"+testResult.toString()+"\n");
        assertEquals(0, testResult.size());
    }
    
    @Test
    public void testKruskals2() {
        //Test weights
        int sum=0;
        Collection<Edge> testResult = MST.kruskals(myEdges);
        
        
        for(Edge e: testResult)
            sum+=e.weight;
        
        System.out.println("Kruskal's: Normal with weights summing to "+sum+"\n"+testResult.toString()+"\n");
        assertEquals(16, sum);
    }

    @Test
    public void testPrims0() {

        Collection<Edge> testResult = MST.prims(v1, myAdjacencyList);
        System.out.println("Prim's: Normal\n"+testResult.toString()+"\n");
        assertEquals(6, testResult.size());
        assertTrue(testResult.contains(myEdges.get(3)));
        assertTrue(testResult.contains(myEdges.get(0)));
        assertTrue(testResult.contains(myEdges.get(14)));
        assertTrue(testResult.contains(myEdges.get(21)));
        assertTrue(testResult.contains(myEdges.get(23)));
    }
    
    @Test
    public void testPrims1() {

        //test if graph is null
        Collection<Edge> testResult = MST.prims(v1, null);
        System.out.println("Prim's: null Graph\n"+testResult.toString()+"\n");
        assertEquals(0, testResult.size());
    }
    
    @Test
    public void testPrims2() {

        //test if start vertex is null
        Collection<Edge> testResult = MST.prims(null, myAdjacencyList);
        System.out.println("Prim's: null Starting Vertex\n"+testResult.toString()+"\n");
        assertEquals(0, testResult.size());
    }
    
    @Test
    public void testPrims3() {
        //test if weight is minimum
        int sum=0;
        Collection<Edge> testResult = MST.prims(v1, myAdjacencyList);
        
        
        for(Edge e: testResult)
            sum+=e.weight;
        
        System.out.println("Prim's: Normal with weights summing to "+sum+"\n"+testResult.toString()+"\n");
        assertEquals(16, sum);
    }
    
    @Test
    public void testPrims4() {

        Collection<Edge> testResult = MST.prims(v2, myAdjacencyList);
        System.out.println("Prim's: Start from V2\n"+testResult.toString()+"\n");
        assertEquals(6, testResult.size());
        assertTrue(testResult.contains(myEdges.get(3)));
        assertTrue(testResult.contains(myEdges.get(0)));
        assertTrue(testResult.contains(myEdges.get(14)));
        assertTrue(testResult.contains(myEdges.get(21)));
        assertTrue(testResult.contains(myEdges.get(23)));
    }
    @Test
    public void testPrims5() {

        Collection<Edge> testResult = MST.prims(v3, myAdjacencyList);
        System.out.println("Prim's: Start from V2\n"+testResult.toString()+"\n");
        assertEquals(6, testResult.size());
        assertTrue(testResult.contains(myEdges.get(3)));
        assertTrue(testResult.contains(myEdges.get(0)));
        assertTrue(testResult.contains(myEdges.get(14)));
        assertTrue(testResult.contains(myEdges.get(21)));
        assertTrue(testResult.contains(myEdges.get(23)));
    }
    
    @Test
    public void testPrims6() {

        Collection<Edge> testResult = MST.prims(v4, myAdjacencyList);
        System.out.println("Prim's: Start from V2\n"+testResult.toString()+"\n");
        assertEquals(6, testResult.size());
        assertTrue(testResult.contains(myEdges.get(3)));
        assertTrue(testResult.contains(myEdges.get(0)));
        assertTrue(testResult.contains(myEdges.get(14)));
        assertTrue(testResult.contains(myEdges.get(21)));
        assertTrue(testResult.contains(myEdges.get(23)));
    }
    
    @Test
    public void testPrims7() {

        Collection<Edge> testResult = MST.prims(v5, myAdjacencyList);
        System.out.println("Prim's: Start from V2\n"+testResult.toString()+"\n");
        assertEquals(6, testResult.size());
        assertTrue(testResult.contains(myEdges.get(3)));
        assertTrue(testResult.contains(myEdges.get(0)));
        assertTrue(testResult.contains(myEdges.get(14)));
        assertTrue(testResult.contains(myEdges.get(21)));
        assertTrue(testResult.contains(myEdges.get(23)));
    }
    
    @Test
    public void testPrims8() {

        Collection<Edge> testResult = MST.prims(v6, myAdjacencyList);
        System.out.println("Prim's: Start from V2\n"+testResult.toString()+"\n");
        assertEquals(6, testResult.size());
        assertTrue(testResult.contains(myEdges.get(3)));
        assertTrue(testResult.contains(myEdges.get(0)));
        assertTrue(testResult.contains(myEdges.get(14)));
        assertTrue(testResult.contains(myEdges.get(21)));
        assertTrue(testResult.contains(myEdges.get(23)));
    }
    
    @Test
    public void testPrims9() {

        Collection<Edge> testResult = MST.prims(v7, myAdjacencyList);
        System.out.println("Prim's: Start from V2\n"+testResult.toString()+"\n");
        assertEquals(6, testResult.size());
        assertTrue(testResult.contains(myEdges.get(3)));
        assertTrue(testResult.contains(myEdges.get(0)));
        assertTrue(testResult.contains(myEdges.get(14)));
        assertTrue(testResult.contains(myEdges.get(21)));
        assertTrue(testResult.contains(myEdges.get(23)));
    }
    
    @Test
    public void testBoth0(){
        //The ultimate test
        assertTrue(MST.kruskals(myEdges).containsAll(MST.prims(v1, myAdjacencyList)));
        assertTrue(MST.kruskals(myEdges).containsAll(MST.prims(v2, myAdjacencyList)));
        assertTrue(MST.kruskals(myEdges).containsAll(MST.prims(v3, myAdjacencyList)));
        assertTrue(MST.kruskals(myEdges).containsAll(MST.prims(v4, myAdjacencyList)));
        assertTrue(MST.kruskals(myEdges).containsAll(MST.prims(v5, myAdjacencyList)));
        assertTrue(MST.kruskals(myEdges).containsAll(MST.prims(v6, myAdjacencyList)));
        assertTrue(MST.kruskals(myEdges).containsAll(MST.prims(v7, myAdjacencyList)));
    }

    //Good Luck on the Final!
    
}
