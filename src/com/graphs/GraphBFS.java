package com.graphs;

import java.util.LinkedList;
import java.util.Queue;
/**
 * BFS for a directed graph
 * @author vikrantmathure
 *
 */
public class GraphBFS {
	
	static class Graph {
		int vertices;
		LinkedList<Integer> arrayofadjacencyList[];
		
		Graph(int vertices){
			this.vertices = vertices;
			arrayofadjacencyList = new LinkedList[vertices];
			for(int i = 0; i < vertices; i++) {
				arrayofadjacencyList[i] = new LinkedList<>();
			}
		}

		public void addEdge(int source, int destination) {
			arrayofadjacencyList[source].addFirst(destination);
		}

		public void BFS(int startVertex) {
			boolean visited[] = new boolean[this.vertices];
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(startVertex);
			
			while(!queue.isEmpty()){
				Integer currentVertex = queue.remove();
				visited[currentVertex] = true;
				System.out.print(" " + currentVertex);
				
				LinkedList<Integer> neigbors = arrayofadjacencyList[currentVertex];
				for(int i = 0; i < neigbors.size(); i++) {
					if(!visited[neigbors.get(i)]) {
						queue.add(neigbors.get(i));
						visited[neigbors.get(i)] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        int startVertex = 0;
        graph.BFS(startVertex);
	}
}
