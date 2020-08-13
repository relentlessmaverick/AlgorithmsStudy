package com.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Prims Algorithm using Adjacency List & Priority Q
 * @author vikrantmathure
 * O(|V| + |E| log |E|) — We need to initialize all |V| vertices, and we need to add each of our |E| edges to a Priority Queue 
 * 
 */
public class PrimsAlgorithmUsingPQ {

	// Edge of the Graph
	private static class Edge {
		private int source;
		private int destination;
		private int weight;

		private Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
	}

	// Pair for holding key (distance) & destination vertex
	private static class Tuple {
		int key;
		int value;

		private Tuple(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public int getValue() {
			return value;
		}
	}

	// Result holder for MST
	private static class ResultSet {
		int parent;
		int weight;
	}

	private static class Graph {
		int vertices;
		LinkedList<Edge> adjacencyList[];

		private Graph(int vertices) {
			this.vertices = vertices;
			adjacencyList = new LinkedList[vertices];
			for (int i = 0; i < vertices; i++) {
				adjacencyList[i] = new LinkedList<>();
			}
		}

		private void addEgde(int source, int destination, int weight) {
			Edge newEdge = new Edge(source, destination, weight);
			adjacencyList[source].addFirst(newEdge);

			// since undirected graph
			newEdge = new Edge(destination, source, weight);
			adjacencyList[destination].addFirst(newEdge);
		}

		private void findMinimumSpanningTree(int fromVertex) {
			// define pq - sort based on keys (or distances)
			Comparator<Tuple> comparator = (a, b) -> a.getKey() - b.getKey();
			PriorityQueue<Tuple> priorityQ = new PriorityQueue<>(this.vertices, comparator);

			// define visited to keep track of visited vertices
			boolean[] visited = new boolean[this.vertices];

			// key array used to store the key to know whether priority queue update is
			// required
			int[] key = new int[this.vertices];

			ResultSet[] resultSet = new ResultSet[this.vertices];

			// Initialization
			Arrays.fill(key, Integer.MAX_VALUE);
			for (int i = 0; i < this.vertices; i++) {
				resultSet[i] = new ResultSet();
			}

			// starting from index=fromVertex
			key[fromVertex] = 0;

			// starting pair of distance(key) & fromVertex
			Tuple startingPair = new Tuple(key[fromVertex], 0);
			priorityQ.offer(startingPair);
			resultSet[fromVertex].parent = -1;

			while (!priorityQ.isEmpty()) {
				// remove minimum edge
				Tuple tuple = priorityQ.remove();
				int vertex = tuple.getValue();
				visited[vertex] = true;

				// get all the neighbors for this visited vertex, put them in pQ so that you can
				// find the minimum edge
				LinkedList<Edge> neighbors = adjacencyList[vertex];
				for (int i = 0; i < neighbors.size(); i++) {
					Edge edge = neighbors.get(i);

					// if edge has not been visited OR edge destination is absent in visited array
					if (!visited[edge.destination]) {
						int destination = edge.destination;
						int newKey = edge.weight;

						if (key[destination] > newKey) {

							Tuple t = new Tuple(newKey, destination);
							priorityQ.offer(t);
							key[destination] = newKey;

							resultSet[destination].parent = vertex;
							resultSet[destination].weight = newKey;
						}
					}
				}
			}
			// print mst
			displayMST(resultSet);
		}

		public void displayMST(ResultSet[] resultSet) {
			int total_min_weight = 0;
			System.out.println("Minimum Spanning Tree: ");
			for (int i = 1; i < vertices; i++) {
				System.out.println("Edge: " + i + " - " + resultSet[i].parent + " key: " + resultSet[i].weight);
				total_min_weight += resultSet[i].weight;
			}
			System.out.println("Total minimum key: " + total_min_weight);
		}

		public static void main(String[] args) {
			int vertices = 6;
			Graph graph = new Graph(vertices);
			graph.addEgde(0, 1, 4);
			graph.addEgde(0, 2, 3);
			graph.addEgde(1, 2, 1);
			graph.addEgde(1, 3, 2);
			graph.addEgde(2, 3, 4);
			graph.addEgde(3, 4, 2);
			graph.addEgde(4, 5, 6);
			int fromVertex = 0;
			graph.findMinimumSpanningTree(fromVertex);
		}
	}
}

//Graph of vertices & adjList
//adjList is a list of Edges
//define Edge class
//definf PQ to pick up minimum of all connected edges to a fromVertex

//in driver
//instantiate graph
//create edges
//run the algo for finding MST
