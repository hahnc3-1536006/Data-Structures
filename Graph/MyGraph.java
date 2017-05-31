// Christian Hahn
// TA: James Wang
// CSE 373 Section AF
// 5/4/2017

import java.util.*;

/**
 * A representation of a graph.
 * Assumes that we do not have negative cost edges in the graph.
 */
public class MyGraph implements Graph {

   private Map<Vertex, Set<Edge>> myGraph;
   private final int INFINITE = Integer.MAX_VALUE;
   
   /**
    * Creates a MyGraph object with the given collection of vertices
    * and the given collection of edges.
    * @param v a collection of the vertices in this graph
    * @param e a collection of the edges in this graph
    */
   public MyGraph(Collection<Vertex> v, Collection<Edge> e) {  
      myGraph = new HashMap<Vertex, Set<Edge>>();
      for (Vertex vertex : v) {
         if (!myGraph.containsKey(vertex))
            myGraph.put(vertex, new HashSet<Edge>());
      }
      for (Edge edge: e) {
         if (edge.getWeight() < 0) {
            throw new IllegalArgumentException();
         }
         if (!myGraph.containsKey(edge.getSource()) || 
               !myGraph.containsKey(edge.getDestination())) {
            throw new IllegalArgumentException();
         }
         for (Edge currentEdge : myGraph.get(edge.getSource())) {
            boolean check = checkEdge(edge, currentEdge);
            if (check) {
               throw new IllegalArgumentException();
            }
         } 
         Set<Edge> current = myGraph.get(edge.getSource());
         current.add(edge);
         myGraph.put(edge.getSource(), current);
      }
   }
   
   private boolean checkEdge(Edge edge, Edge current) {
      boolean source = edge.getSource().equals(current.getSource());
      boolean destination = edge.getDestination().equals(current.getDestination());
      boolean weight = edge.getWeight() != current.getWeight();  
      return source && destination && weight;
   }
   
   /** 
    * Return the collection of vertices of this graph
    * @return the vertices as a collection (which is anything iterable)
    */
   public Collection<Vertex> vertices() {
      return myGraph.keySet();
   }

   /** 
    * Return the collection of edges of this graph
    * @return the edges as a collection (which is anything iterable)
    */
   public Collection<Edge> edges() {
	// YOUR CODE HERE
      Set<Edge> allEdges = new HashSet<Edge>();
      for (Vertex vertex : myGraph.keySet()) {
         allEdges.addAll(myGraph.get(vertex));
      }
      return allEdges;      
   }

   /**
    * Return a collection of vertices adjacent to a given vertex v.
    *   i.e., the set of all vertices w where edges v -> w exist in the graph.
    * Return an empty collection if there are no adjacent vertices.
    * @param v one of the vertices in the graph
    * @return an iterable collection of vertices adjacent to v in the graph
    * @throws IllegalArgumentException if v does not exist.
    */
   public Collection<Vertex> adjacentVertices(Vertex v) {
      if (!myGraph.containsKey(v)) {
         throw new IllegalArgumentException();
      }
      Set<Vertex> result = new HashSet<Vertex>();
      for (Edge edge : myGraph.get(v)) {
         result.add(edge.getDestination());
      }
      return result;      
   }

   /**
    * Test whether vertex b is adjacent to vertex a (i.e. a -> b) in a directed graph.
    * Assumes that we do not have negative cost edges in the graph.
    * @param a one vertex
    * @param b another vertex
    * @return cost of edge if there is a directed edge from a to b in the graph, 
    * return -1 otherwise.
    * @throws IllegalArgumentException if a or b do not exist.
    */
   public int edgeCost(Vertex a, Vertex b) {
      if (!myGraph.containsKey(a) || !myGraph.containsKey(b)) {
         throw new IllegalArgumentException();
      }
      Set<Edge> values = myGraph.get(a);
      for (Edge edge : values) {
         if (edge.getDestination().equals(b)) {
            return edge.getWeight();
         }
      }
      return -1;
   }


   /**
    * Returns the shortest path from a to b in the graph, or null if there is
    * no such path.  Assumes all edge weights are nonnegative.
    * Uses Dijkstra's algorithm.
    * @param a the starting vertex
    * @param b the destination vertex
    * @return a Path where the vertices indicate the path from a to b in order
    *   and contains a (first) and b (last) and the cost is the cost of 
    *   the path. Returns null if b is not reachable from a.
    * @throws IllegalArgumentException if a or b does not exist.
    */
   public Path shortestPath(Vertex a, Vertex b) {
	   // throws IllegalArgument Exception if a or b is not in the graph
      if (!myGraph.containsKey(a) || !myGraph.containsKey(b)) {
         throw new IllegalArgumentException();
      }
      // returns a cost 0 path if the start and end destination are 
      // the same 
      if (a.equals(b)) {
         List<Vertex> oneVertex = new ArrayList<Vertex>();
         oneVertex.add(a);
         return new Path(oneVertex, 0);
      }
      // keeps track of distances of each vertex from source
      Map<Vertex, Integer> costs = new HashMap<Vertex, Integer>();
      // keeps track of visited nodes
      List<Vertex> visited = new ArrayList<Vertex>();
      // keeps track of unvisited nodes
      List<Vertex> unvisited = new ArrayList<Vertex>();
      // keeps track of final path result by mapping current vertex to
      // previous vertex
      Map<Vertex, Vertex> result = new HashMap<Vertex, Vertex>();
      for (Vertex v : myGraph.keySet()) {
         if (v.equals(a)) {
            // make sure the path starts at a
            costs.put(v, 0);
         } else {
            // set all unseen vertices to high value
            costs.put(v, INFINITE);
         }
         unvisited.add(v);   
         result.put(v, null);        
      }
      // runs until every vertex is seen
      while (!unvisited.isEmpty()) {
         Vertex shortest = shortestDistance(unvisited, costs);
         findShortestAdjacent(shortest, costs, unvisited, visited, result);
         unvisited.remove(shortest);
         visited.add(shortest);
      }
      // check if there is a path to b
      if (result.get(b) == null) {
         return null;
      }
      // temporary stack to reverse the order
      Stack<Vertex> temp = new Stack<Vertex>();
      Vertex current = b;
      temp.add(b);
      while (result.get(current) != null) {
         current = result.get(current);
         temp.add(current);
      }    
      // puts elements in stack to list to make path in correct order
      List<Vertex> finalPath = new ArrayList<Vertex>();
      while (!temp.isEmpty()) {
         finalPath.add(temp.pop());
      }
      Path finalResult = new Path(finalPath, costs.get(b));
      return finalResult;    
   }
   
   // finds vertex with shortest distance from start vertex
   private Vertex shortestDistance(List<Vertex> notVisited, Map<Vertex, Integer> map) {
      Vertex result = notVisited.get(0);
      for (Vertex v : notVisited) {
         if (map.get(v) < map.get(result)) {
            result = v;
         }   
      }
      return result;
   }
   
   // finds shortest adjacent vertex and adds it to the path if it is less
   // than the cost of the path so far
   // updates unvisited list of vertices
   private void findShortestAdjacent(Vertex v, Map<Vertex,Integer> costs, 
                        List<Vertex> notVisited, List<Vertex> visited, 
                        Map<Vertex, Vertex> result) {
      Collection<Vertex> adjVert = adjacentVertices(v);
      for (Vertex adj : adjVert) {
         int cost = edgeCost(v, adj);
         int totalCost = costs.get(v) + cost;
         if (!visited.contains(adj) && costs.get(adj) > totalCost) {
            costs.put(adj, totalCost);
            result.put(adj, v);
            notVisited.add(adj);
         }
      }
   }
}
