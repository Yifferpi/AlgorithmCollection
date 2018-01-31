import org.junit.Ignore;
import org.junit.Test;

public class GraphTest {

	
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
		
		Graph g;
		
		g= new Graph();
		g.setAmountOfVertices(6);
		g.generate();
		
		g.print(System.out);
		ShortestPaths.BFS(g, System.out);
		
	
	}

}
