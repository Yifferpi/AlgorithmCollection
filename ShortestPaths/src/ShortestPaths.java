import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;


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
		printBFS(g, pre, out);
	}
	
	private static void printBFS(Graph g, GNode[] pre, PrintStream out) {
		
		
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

	
	/**
	 * This Algorithm is a One-To-All Shortest Path Algorithm that calculates the shortest paths from vertex 0 to all others
	 * and prints it to the console. it requires non-negative edge weights. Random weight is okay.
	 * @param g - Graph on which the Algorithm should run.
	 * @param out - PrintStream in which to print results.
	 */
	public static void Dijkstra(Graph g, PrintStream out) {
		
		ArrayList<ArrayList<GEdge>> adjList = g.getAdjList();
		ArrayDeque<GNode> Q = new ArrayDeque<GNode>();
		
		int[] d = new int[g.numVertices()];
		GNode[] prev = new GNode[g.numVertices()];
		//Initialize
		for (int i = 1; i < d.length; i++) {
			d[i] = 1000000;
		}
		//Algorithm
		Q.add(g.getVertex(0));
		while ( !Q.isEmpty() ) {
			GNode u = Q.removeFirst();
			for ( GEdge e : adjList.get(u.getID())) {
				GNode v = e.getTo();
				if ( prev[v.getID()] == null ) {
					d[v.getID()] = d[u.getID()] + e.getWeight();
					prev[v.getID()] = u;
					Q.addLast(v);
				} else if ( d[u.getID()] + e.getWeight() < d[v.getID()] ) {
					d[v.getID()] = d[u.getID()] + e.getWeight();
					prev[v.getID()] = u;
				}
			}
			//out.println(Q.toString());
		}
		printDijkstra(g, prev, d, out);
	}
	
	private static void printDijkstra(Graph g, GNode[] pre, int[] d, PrintStream out) {
		
		
		out.println("Shortest Paths from 0 to all Vertices:");
		for (int i = 1; i < pre.length; i++) {
			String path = "";
			if ( pre[i] == null ) {
				path = "Node #" + i + " not connected";
			} else {
				int index = i;
				path += g.getVertex(index).toString();
				
				while (pre[index] != null) {
					index = pre[index].getID();
					path = g.getVertex(index).toString() + "-->" + path;
				}	
			}
			path = "Distance: " + d[i] + " Path: " + path;
			out.println(path);
		}
	}
	
	//======================================================================================================================

	
	public static void BellmanFord(Graph g, PrintStream out) {
		
		
		ArrayList<GNode> V = g.getVertices();
		ArrayList<GEdge> E = g.getEdges();
		
		
		int[][] dp = new int[V.size()][V.size()];
		GNode[] pre = new GNode[V.size()];
		
		//Init
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 1000000;
		}
		dp[0][0] = 0;
		
		//Calculations
		for (int i = 1; i < V.size(); i++) {
			for (GEdge e : E) {
				if (dp[i][e.getTo().getID()] > dp[i-1][e.getFrom().getID()] + e.getWeight()) {
					dp[i][e.getTo().getID()] = dp[i-1][e.getFrom().getID()] + e.getWeight();
					pre[e.getTo().getID()] = e.getFrom();
				}
			}
		}
		//check for negative Circles
		boolean negativeCircles = false;
		for (GEdge e : E) {
			if (dp[V.size()-1][e.getTo().getID()] > dp[V.size()-1][e.getFrom().getID()] + e.getWeight()) {
				negativeCircles = true;
			}
		}
		
		printShortestPathsBF(g, pre, dp[V.size() - 1], out, negativeCircles);
	}
	
	private static void printShortestPathsBF(Graph g, GNode[] pre, int[] d, PrintStream out, boolean negativeCircles) {
		
		out.println("Shortest Paths from 0 to all Vertices:");
		
		if (negativeCircles) {
			out.println("There are negative circles in this graph");
		} else {
			
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
				path = "Distance: " + d[i] + " Path: " + path;
				out.println(path);
			}
		}
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
