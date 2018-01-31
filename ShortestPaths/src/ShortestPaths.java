import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.PriorityQueue;


public class ShortestPaths {

	
	
	//======================================================================================================================
	
	/**
	 * This Algorithm is a One-To-All Shortest Path Algorithm that calculates the shortest paths from vertex 0 to all others
	 * and prints it to the console. It requires non-negative uniform edge weights.
	 * @param g - Graph on which the Algorithm should run.
	 * @param out - PrintStream in which to print results.
	 */
	public static void BFS(Graph g, PrintStream out) {
		GNode[] pre = new GNode[g.numVertices()];
		
		ArrayDeque<GNode> Q = new ArrayDeque<GNode>();
		Q.add(g.getVertex(0));
		while ( !Q.isEmpty() ) {
			GNode u = Q.removeFirst();
			for (GEdge e : u.getEdges()) {
				if (pre[e.getTo().getID()] == null) {
					pre[e.getTo().getID()] = u;
					Q.addLast(e.getTo());
				}
			}
		}
		printShortestPaths(g, pre, out);
	}
	
	private static void printShortestPaths(Graph g, GNode[] pre, PrintStream out) {
		
		
		out.println("Shortest Paths from 0 to all Vertices:");
		for (int i = 1; i < pre.length; i++) {
			String path = "";
			if ( pre[i] == null ) {
				path = "Node #" + i + " not connected";
			} else {
				int index = i;
				path = g.getVertex(index).toString();
				
				while (pre[index] != null) {
					index = pre[index].getID();
					path = g.getVertex(index).toString() + "-->" + path;
				}	
			}
			out.println(path);
		}
	}
	
	
	//======================================================================================================================

	public static void Dijkstra(Graph g, PrintStream out) {
		
		
		GNode[] pre = new GNode[g.numVertices()];
		int[] dis = new int[g.numVertices()];
		
		for (GNode v : g.getVertices()) {
			pre[v.getID()] = null;
			dis[v.getID()] = 1000000;
		}
		dis[0] = 0;
		
		//PriorityQueue<GNode> Q = new PriorityQueue<GNode>();
		
		//TODO
		
	}
	
	//======================================================================================================================

	
	public static void BellmanFord(Graph g, PrintStream out) {
		//TODO
	}
	
	//======================================================================================================================

	
	public static void FloydWarshall(Graph g, PrintStream out) {
		//TODO
	}
	
	
	//======================================================================================================================

	
	public static void Johnsson(Graph g, PrintStream out) {
		//TODO
	}
	

}
