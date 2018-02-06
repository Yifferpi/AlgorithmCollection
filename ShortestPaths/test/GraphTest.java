import org.junit.Ignore;
import org.junit.Test;

public class GraphTest {

	@Ignore
	@Test
	public void testGraph() {
		Graph g = new Graph();
		g.setAmountOfVertices(6);
		g.setMaxEdgeWeight(4);
		g.setRandomWeights(true);
		g.setDirected(false);
		g.generate();
		g.print(System.out);
		System.out.println(g.numVertices());
		System.out.println(g.numEdges());
		
	}
	
	@Ignore
	@Test
	public void testBFS() {
		System.out.println("=====================================");
		System.out.println("BFS: ");
		System.out.println("=====================================");
		
		Graph g;
		
		g= new Graph();
		g.setAmountOfVertices(6);
		g.generate();
		
		g.print(System.out);
		ShortestPaths.BFS(g, System.out);
		
	
	}
	
	
	@Test
	public void testDijkstra() {
		System.out.println("=====================================");
		System.out.println("Dijkstra: ");
		System.out.println("=====================================");
		
		Graph g;
		//new directed Graph with random positive weights
		g= new Graph();
		g.setAmountOfVertices(100);
		g.setDirected(true);
		g.setRandomWeights(true);
		g.setMaxEdgeWeight(5);
		
		g.generate();
		//g.print(System.out);
		
		ShortestPaths.Dijkstra(g, System.out);
	}
	
	@Ignore
	@Test
	public void testBellmanFord() {
		System.out.println("=====================================");
		System.out.println("BellmanFord: ");
		System.out.println("=====================================");
		
		Graph g;
		//new directed Graph with random positive or negative weights
		g= new Graph();
		g.setAmountOfVertices(6);
		g.setDirected(true);
		g.setRandomWeights(true);
		g.setNegativeWeights(true);
		g.setMaxEdgeWeight(5);
		
		g.generate();
		g.print(System.out);
		
		ShortestPaths.BellmanFord(g, System.out);
	}

}
