import org.junit.Ignore;
import org.junit.Test;

public class GraphTest {

	
	@Test
	public void testGraph() {
		Graph g = new Graph();
		g.setAmountOfVertices(6);
		g.setMaxEdgeWeight(4);
		g.setRandomWeights(true);
		g.generate();
		g.print(System.out);
		
	}
	
	@Ignore
	@Test
	public void testBFS() {
		
		Graph g = new Graph();
		g.setAmountOfVertices(6);
		g.generate();
		g.print(System.out);
		
		ShortestPaths.BFS(g, System.out);
	
	}

}
