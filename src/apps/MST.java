package apps;

import structures.*;
import java.util.ArrayList;

public class MST {
	
	/**
	 * Initializes the algorithm by building single-vertex partial trees
	 * 
	 * @param graph Graph for which the MST is to be found
	 * @return The initial partial tree list
	 */
	public static PartialTreeList initialize(Graph graph) {
	
		PartialTreeList L = new PartialTreeList();
		
		int size = graph.vertices.length;
		
		for(int i = 0; i<size;i++){
			Vertex v = graph.vertices[i];
			
			
			PartialTree T = new PartialTree(v);
			
			
			MinHeap<PartialTree.Arc> P = new MinHeap<PartialTree.Arc>();
			
			for(Vertex.Neighbor tmp = T.getRoot().neighbors; tmp!= null; tmp=tmp.next){
				Vertex v2 = tmp.vertex;
				int weight = tmp.weight;
				PartialTree.Arc A = new PartialTree.Arc(v, v2, weight);
				
				P.insert(A);
				
			}
			T.getArcs().merge(P);
			
			L.append(T);
			
		}
		
		return L;
	}

	/**
	 * Executes the algorithm on a graph, starting with the initial partial tree list
	 * 
	 * @param ptlist Initial partial tree list
	 * @return Array list of all arcs that are in the MST - sequence of arcs is irrelevant
	 */
	public static ArrayList<PartialTree.Arc> execute(PartialTreeList ptlist) {
		
		/* COMPLETE THIS METHOD */

		return null;
	}
}
