import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import apps.MST;
import apps.PartialTree;
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
		MST.initialize(graph);
		
		
	
		
		
	}

}