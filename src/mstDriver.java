import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import apps.MST;
import apps.PartialTree;
import apps.PartialTree.Arc;
import apps.PartialTreeList;
import structures.Graph;
import structures.MinHeap;
import structures.Vertex;
import structures.Vertex.Neighbor;

public class mstDriver {
	static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("Enter graph file: ");
		String infile = keyboard.readLine();
		BufferedReader br = new BufferedReader(new FileReader(infile));
		Graph graph = new Graph(infile);
		PartialTreeList tmp = MST.initialize(graph);
		ArrayList <PartialTree.Arc> al = MST.execute(tmp);
		Iterator<Arc> it = al.iterator();
		
		while(it.hasNext()){
			Arc kek = it.next();
			System.out.println(kek.toString());
		}
	}

}