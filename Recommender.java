import java.io.File;
import java.util.Scanner;

public class Recommender {

	// Return the top k recommended friends for user i using the popular nodes method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
	public static <K extends Comparable<K>> PQK<Double, K> recommendPop(Graph<K> g, K i, int k) {
      if(g.isNode(i)== false) return null;
      
      PQK<Double, K> friends= new PQKImp<Double, K>(k);
      List<K> nodes= g.getNodes();
      if(nodes.empty()== true) return null;
      if(nodes== null)return null;

      int size= nodes.size();

      nodes.findFirst();
      while(!nodes.last()){
      
      if(nodes.retrieve().compareTo(i)!=0){  //not the same node
      if(!g.isEdge(i, nodes.retrieve()))    //not friends now
      friends.enqueue((double)g.deg(nodes.retrieve()),nodes.retrieve()); }
     
      nodes.findNext();}

     //last element
     if(nodes.retrieve().compareTo(i)!=0){  
     if(!g.isEdge(i, nodes.retrieve()))
     friends.enqueue((double)g.deg(nodes.retrieve()),nodes.retrieve());}
     
     return friends;}

	// Return the top k recommended friends for user i using common neighbors method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
public static <K extends Comparable<K>> PQK<Double, K> recommendCN(Graph<K> g, K i, int k) {
				
 if(g.isNode(i)== false) return null;
      
 PQK<Double, K> friends= new PQKImp<Double, K>(k);
 List<K> nodes= g.getNodes();
 if(nodes.empty()== true) return null;
 List<K> neighbors=g.neighb(i);
 if(neighbors.empty()== true) return null;
 if(nodes== null)return null;
 List<K> neighbors2=null;
 
 
 //System.out.println("size:"+size);
 nodes.findFirst();
 
 while(!nodes.last()){
 if(nodes.retrieve().compareTo(i)!=0){ 
 if(!g.isEdge(i, nodes.retrieve())){

 neighbors2 = g.neighb(nodes.retrieve());
 int count=common(neighbors2, neighbors);
 friends.enqueue((double)count,nodes.retrieve());}}
 
 nodes.findNext();
 //System.out.println("the node"+nodes.retrieve());
 }

// System.out.println("the node"+nodes.retrieve());

 if(nodes.retrieve().compareTo(i)!=0){  
 if(!g.isEdge(i, nodes.retrieve())){
 
 neighbors2 =g.neighb(nodes.retrieve());
 int count=common(neighbors2, neighbors);
 friends.enqueue((double)count,nodes.retrieve());}}
 
return friends;}


 private static<K extends Comparable> int common(List<K> neighbors,List<K> friends){
 if(neighbors==null || friends==null)return 0;
 if(neighbors.empty()== true) return 0;
 if(friends.empty()== true) return 0;
 
 int common=0;

 neighbors.findFirst();
 
 for(int i=1;i<=neighbors.size();i++){
 if(friends.exists(neighbors.retrieve()))
 common++;
 
 neighbors.findNext();}
 
 return common;}

 // Read graph from file. The file is a text file where each line contains an edge. The end and start of the edge are separated by space(s) or tabs.
   public static Graph<Integer> read(String fileName) {

		try {
			Graph<Integer> g = new MGraph<Integer>();
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextInt()) {
				int i = scanner.nextInt();
				g.addNode(i);
				int j = scanner.nextInt();
				g.addNode(j);
				g.addEdge(i, j);
			}
			scanner.close();
			return g;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
