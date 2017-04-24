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
		ArrayList<PartialTree.Arc> component = new ArrayList<PartialTree.Arc>();
		while(!(ptlist.size()<2)){
			PartialTree PTX = ptlist.remove();
			MinHeap<PartialTree.Arc>PQX = PTX.getArcs();
			PartialTree.Arc  a = PQX.getMin();
			Vertex v1 = a.v1;
			Vertex v2 = a.v2;
			while(v2.parent == v1.parent){
				PTX.getArcs().deleteMin();
				a = PTX.getArcs().getMin();
				v1 = a.v1;
				v2 = a.v2;
			}
			component.add(a);
			PartialTree PTY = ptlist.remove();
			while(PTY.getRoot()!= v2.parent){
				PartialTree tmp = PTY;
				PTY = ptlist.remove();
				ptlist.append(tmp);
				
			}
			MinHeap<PartialTree.Arc>PQY = PTY.getArcs();
			PTX.merge(PTY);
			PTX.getArcs().merge(PQY);
			ptlist.append(PTX);
			
		}
		/* COMPLETE THIS METHOD */

		return null;
	}
}
