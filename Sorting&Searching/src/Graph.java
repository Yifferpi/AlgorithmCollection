import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;


public class Graph {
	
	private static int vertexID = 0;
	
	private ArrayList<GNode> vertices;
	Settings settings;
	
	
	
	Graph () {
		this.vertices = new ArrayList<GNode>();
		this.settings = new Settings();
	}
	
	
	
	
	public void setRandomWeights(boolean x) {
		settings.randomWeights = x;
	}
	public void setNegativeWeights(boolean x) {
		settings.negativeWeights = x;
	}
	public void setAmountOfVertices(int x) {
		settings.amountOfVertices = x;
	}
	public void setMaxEdgeWeight(int x) {
		settings.maxWeight = x;
	}
	
	public void generate() {

		for (int i = 0; i < settings.amountOfVertices; i++) 
			addVertex();

		Random r = new Random();
		for (GNode from : vertices) {

			if (settings.directed) {
				
				int amountOfOutEdges = r.nextInt(settings.maxOutDegree);

				for (int j = 0; j < amountOfOutEdges; j++) {

					GNode possibleTo = vertices.get(r.nextInt(vertices.size()));

					if ( !from.hasEdgeTo(possibleTo) && !from.equals(possibleTo) && !possibleTo.equals(getVertex(0))) {
						if (settings.randomWeights) {
							if (settings.negativeWeights) {
								from.addEdge(possibleTo, r.nextInt(settings.maxWeight * 2) - settings.maxWeight);
							} else {
								from.addEdge(possibleTo, r.nextInt(settings.maxWeight));
							}
						} else {
							from.addEdge(possibleTo);
						}
					}	
				} 
			} else {
				
			}
		}
	}

	
	private void addVertex() {
		vertices.add(new GNode(vertexID));
		vertexID++;
	}
	public GNode getVertex(int index) {
		return vertices.get(index);
	}
	public ArrayList<GNode> getVertices() {
		return vertices;
	}
	
	
	public int numVertices() {
		return vertices.size();
	}

	public int numEdges() {
		int total = 0;
		for (GNode x : vertices) {
			total = total + x.numEdges();
		}
		return total;
	}
	
	public void print(PrintStream out) {
		out.println("Graph-Content:");
		for (GNode v : vertices) {
			out.println(v);
			for (GEdge e : v.getEdges()) {
				out.println("   " + e);
			}
		}
	}
}

class GNode {
	
	private final int ID;
	
	private ArrayList<GEdge> out;
	
	GNode(int id) {
		this.ID = id;
		this.out = new ArrayList<GEdge>();
	}
	
	public int getID() {
		return ID;
	}
	public String toString() {
		return "Node #" + ID;
	}
	
	public void addEdge(GNode x) {
		out.add(new GEdge(this, x));
	}
	public void addEdge(GNode x, int weight) {
		out.add(new GEdge(this, x, weight));
	}
	
	public ArrayList<GEdge> getEdges() {
		return out;
	}
	
	public int numEdges() {
		return out.size();
	}
	public boolean hasEdgeTo(GNode x) {
		for (GEdge e : out) {
			if (e.getTo() == x)
				return true;
		}
		return false;
	}
}

class GEdge {
	
	private GNode from;
	private GNode to;
	private int weight;
	

	GEdge (GNode from, GNode to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	GEdge (GNode from, GNode to) {
		this(from, to, 1);
	}
	
	public GNode getFrom() {
		return from;
	}
	public GNode getTo() {
		return to;
	}
	public int getWeight() {
		return weight;
	}
	
	public String toString() {
		return "To: " + to + " Weight: " + weight;
	}
		
}

class Settings {
	boolean randomWeights;
	boolean negativeWeights;
	boolean directed;
	int amountOfVertices;
	int maxOutDegree;
	int maxWeight;
	
	Settings() {
		this.randomWeights = false;
		this.negativeWeights = false;
		this.directed = true;
		
		this.amountOfVertices = 10;
		this.maxOutDegree = 10;
		this.maxWeight = 10;
	}
	
}
