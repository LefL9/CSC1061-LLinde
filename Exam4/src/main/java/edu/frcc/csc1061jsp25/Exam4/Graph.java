package edu.frcc.csc1061jsp25.Exam4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class Graph<E> {
	public List<Vertex> vertices = new ArrayList<>();

	public class Vertex {
		private E elem;
		private List<Edge> neighbors = new ArrayList<>();

		public Vertex(E elem) {
			this.elem = elem;
		}

		public E getKey() {
			return elem;
		}

		@Override
		public boolean equals(Object other) {
			if (!(other instanceof Graph.Vertex))
				return false;

			if (elem.equals(((Vertex) other).elem)) {
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return elem.toString();
		}
	}

	private class Edge implements Comparable<Edge> {
		private Vertex s;
		private Vertex d;
		private int weight;

		public Edge(Vertex s, Vertex d, int weight) {
			this.s = s;
			this.d = d;
			this.weight = weight;
		}

		public boolean equals(Object edge) {
			return s.equals(((Edge) edge).s) && d.equals(((Edge) edge).d);
		}

		@Override
		public int compareTo(Graph<E>.Edge o) {
			return (int) (weight - o.weight);
		}
	}

	public Graph(List<Vertex> vertices) {
		for (Vertex vertex : vertices) {
			addVertex(new Vertex(vertex.getKey()));
		}
	}

	public Graph(List<E> vertices, E[][] edges) {
		for (E ver : vertices) {
			addVertex(new Vertex(ver));
		}
		createAdjacencyLists(edges);
	}

	public boolean addVertex(Vertex vertex) {
		if (!vertices.contains(vertex)) {
			vertices.add(vertex);
			return true;
		} else {
			return false;
		}

	}

	public boolean addEdge(Edge edge) {

		List<Edge> neighbors = edge.s.neighbors;
		if (!neighbors.contains(edge)) {
			neighbors.add(edge);
			return true;
		} else {
			return false;
		}
	}

	private Vertex findVertex(E key) {
		for (Vertex v : vertices) {
			if (v.elem.equals(key)) {
				return v;
			}
		}
		return null;
	}

	private void createAdjacencyLists(E[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			addEdge(new Edge(findVertex(edges[i][0]), findVertex(edges[i][1]), (int) edges[i][2]));
		}
	}

	public void printEdges() {
		for (int i = 0; i < vertices.size(); i++) {
			System.out.print("Vertex: " + vertices.get(i).toString() + ":");
			List<Edge> neighbors = vertices.get(i).neighbors;
			for (Edge edge : neighbors) {
				System.out.print("(" + edge.s + ", " + edge.d + ", " + edge.weight + ")");
			}
			System.out.println();
		}
	}

	public List<Vertex> getChildNodes(Vertex vertex) {
		List<Vertex> childNodes = new ArrayList<>();
		List<Edge> neighbors = vertex.neighbors;
		for (Edge edge : neighbors) {
			childNodes.add(edge.d);
		}
		return childNodes;
	}

	/*
	 * TODO: Implement the DFS algorithm for a graph either recursively or
	 * iteratively using a stack. It should return a list of all the vertices in the
	 * pre-order depth-first traversal.
	 */
	public List<Vertex> dfs(Vertex root) {
		List<Vertex> result = new ArrayList<>();
		if (root == null) return result;

		Deque<Vertex> stack = new ArrayDeque<>();
		List<Vertex> visited = new ArrayList<>();

		stack.push(root);

		while (!stack.isEmpty()) {
			Vertex current = stack.pop();
			if (!visited.contains(current)) {
				visited.add(current);
				result.add(current);
				List<Vertex> children = getChildNodes(current);
				
				
				children.sort(Comparator.comparing(v -> v.elem.toString()));
				Collections.reverse(children); 

				for (Vertex child : children) {
					if (!visited.contains(child)) {
						stack.push(child);
					}
				}
			}
		}
		return result;
	}

	/*
	 * TODO: Implement the BFS algorithm for a graph. It should return a list of all
	 * the vertices in the breadth-first traversal.
	 */
	public List<E> bfs() {
		List<E> result = new ArrayList<>();
		if (vertices.isEmpty())
			return result;

		List<Vertex> visited = new ArrayList<>();
		Deque<Vertex> queue = new ArrayDeque<>();

		Vertex root = vertices.get(0);
		queue.offer(root);
		visited.add(root);

		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			result.add(current.getKey());

			for (Vertex neighbor : getChildNodes(current)) {
				if (!visited.contains(neighbor)) {
					queue.offer(neighbor);
					visited.add(neighbor);
				}
			}
		}
		return result;
	}

	/*
	 * TODO: Create a spanning tree using Kruskal's Algorithm and return it. The
	 * spanning tree will be a new graph
	 */
	private class DisjointSet {
		private Vertex parent;

		public DisjointSet(Vertex parent) {
			this.parent = parent;
		}

		public Vertex findParent(Map<Vertex, DisjointSet> map) {
			if (map.get(this.parent).parent != this.parent) {
				map.get(this.parent).parent = map.get(map.get(this.parent).parent).findParent(map);
			}
			return map.get(this.parent).parent;
		}
	}

	public Graph<E> findMinimumSpanningTree() {
		List<Edge> allEdges = new ArrayList<>();
		for (Vertex v : vertices) {
			allEdges.addAll(v.neighbors);
		}
		Collections.sort(allEdges);

		Map<Vertex, DisjointSet> dsMap = new java.util.HashMap<>();
		for (Vertex v : vertices) {
			dsMap.put(v, new DisjointSet(v));
		}

		List<E> keys = new ArrayList<>();
		for (Vertex v : vertices) {
			keys.add(v.getKey());
		}
		@SuppressWarnings("unchecked")
		E[][] emptyEdges = (E[][]) new Object[0][0];
		Graph<E> mst = new Graph<>(keys, emptyEdges);

		for (Edge edge : allEdges) {
			Vertex root1 = dsMap.get(edge.s).findParent(dsMap);
			Vertex root2 = dsMap.get(edge.d).findParent(dsMap);
			if (!root1.equals(root2)) {
				Vertex from = mst.findVertex(edge.s.elem);
				Vertex to = mst.findVertex(edge.d.elem);
				mst.addEdge(new Edge(from, to, edge.weight));
				mst.addEdge(new Edge(to, from, edge.weight));

				dsMap.get(root2).parent = root1;
			}
		}
		return mst;
	}
}
