import java.util.*;
public abstract class Test {

   public static void main(String[] args) {
   
      Set<Vertex> vertices = new HashSet<Vertex>();
      vertices.add(new Vertex("A"));
      vertices.add(new Vertex("B"));
      vertices.add(new Vertex("C"));
      vertices.add(new Vertex("D"));
      vertices.add(new Vertex("E"));
      vertices.add(new Vertex("F"));
      vertices.add(new Vertex("G"));
      
      Set<Edge> edges = new HashSet<Edge>();
      edges.add(new Edge(new Vertex("A"), new Vertex("B"), 10));
      edges.add(new Edge(new Vertex("A"), new Vertex("E"), 18));
      edges.add(new Edge(new Vertex("A"), new Vertex("D"), 7));
      edges.add(new Edge(new Vertex("B"), new Vertex("D"), 20));
      edges.add(new Edge(new Vertex("D"), new Vertex("B"), 5));
      edges.add(new Edge(new Vertex("E"), new Vertex("B"), 19));
      edges.add(new Edge(new Vertex("A"), new Vertex("C"), 35));
      edges.add(new Edge(new Vertex("C"), new Vertex("F"), 9));
      edges.add(new Edge(new Vertex("F"), new Vertex("G"), 8));
      edges.add(new Edge(new Vertex("G"), new Vertex("F"), 11));
      edges.add(new Edge(new Vertex("F"), new Vertex("C"), 6));
      edges.add(new Edge(new Vertex("C"), new Vertex("B"), 32));
      edges.add(new Edge(new Vertex("C"), new Vertex("B"), 28));
      edges.add(new Edge(new Vertex("C"), new Vertex("B"), 32));
      edges.add(new Edge(new Vertex("E"), new Vertex("A"), 2));
      
      MyGraph g = new MyGraph(vertices, edges);
      System.out.println(g.adjacentVertices(new Vertex("E")).toString());
      System.out.println(g.edgeCost(new Vertex("G"), new Vertex("F")));
      System.out.println(g.vertices());
      System.out.println(g.edges());
   }   
}   






