package com.graphs;

import java.util.LinkedList;
import java.util.Stack;

public class GraphDFS {
	static class Graph {
		int vertices;
		LinkedList<Integer> arrayofAdjacencyLists[];
		
		Graph(int vertices){
			this.vertices = vertices;
			arrayofAdjacencyLists = new LinkedList[vertices];
	        for (int i = 0; i <vertices ; i++) {
	        	arrayofAdjacencyLists[i] = new LinkedList<>();
	        }
		}
		
	    public void addEdge(int source, int destination){
	    	arrayofAdjacencyLists[source].addFirst(destination);
	    }

		public void DFS(int startVertex) {
			boolean visited[] = new boolean[vertices];
			Stack<Integer> stack = new Stack<>();
			stack.add(startVertex);
			visited[startVertex] = true;
			
			while(!stack.isEmpty()) {
				Integer currentVertex = stack.pop();
                System.out.print(currentVertex + " ");
					LinkedList<Integer> neighbors = arrayofAdjacencyLists[currentVertex];
					for(int i = 0; i < neighbors.size(); i++) {
						if (visited[neighbors.get(i)] == false) {
							visited[neighbors.get(i)] = true;
							stack.add(neighbors.get(i));
						}
					}
			}
		}
	}//Depth First Traversal: 0 1 3 4 2 

	public static void main(String[] args) {
		Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);
//        graph.addEdge(4, 0);
//        graph.addEdge(4, 1);
//        graph.addEdge(4, 5);
        int startVertex = 0;
        graph.DFS(startVertex);
	}
}
