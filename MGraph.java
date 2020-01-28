public class MGraph<K extends Comparable<K>> implements Graph<K>{
	public Map<K, List<K>> adj; // Do not change this
  
  public MGraph(){
  adj=new BSTMap<K, List<K>>();}
	
	// Add a node to the graph if it does not exist and return true. If the node already exists, return false.
   public boolean addNode(K i){
   try{
  if (i == null) return false;
  if(adj.retrieve(i).first == true) return false;
  List<K> keys=new LinkedList<K>();
  adj.insert(i,keys);}catch(Exception c){}
   return true;
   }

	// Check if i is a node
	public boolean isNode(K i){
   try{
   if(i==null) return false;
   if(adj == null ) return false;
   if(adj.size()== 0)return false;
   }catch(Exception c){}return adj.retrieve(i).first;}

	// Add an edge to the graph if it does not exist and return true. If i or j do not exist or the edge (i, j) already exists, return false.
	public boolean addEdge(K i, K j){
   try{
   if (isNode(i)==false || isNode(j) == false) return false;
   
   if (adj.retrieve(i).second.exists(j))return false;
   adj.retrieve(i).second.insert(j);
   
   if (adj.retrieve(j).second.exists(i))return false;}catch(Exception c){}
   adj.retrieve(j).second.insert(i);
   
   return true;}

	// Check if (i, j) is an edge.
	public boolean isEdge(K i, K j){
   try{
   if(adj.size()==0)return false;
   
   if (adj.retrieve(i).second.exists(j))
   if (adj.retrieve(j).second.exists(i))
   return true;
   }catch(Exception c){}
   return false;}

	// Return the set of neighbors of node i. If i does not exist, the method returns null.
	public List<K> neighb(K i){
  
   if(isNode(i)==false) return null;
   List<K> list=adj.retrieve(i).second;
   return list;
   }

	// Return the degree (the number of neighbors) of node i. If i does not exist, the method returns -1.
	public int deg(K i){
   try{
   if(isNode(i)==false) return -1;}catch(Exception c){}
   return adj.retrieve(i).second.size();
   }

	// Return a list containing the nodes in increasing order.
	public List<K> getNodes(){
   List<K> keys=new LinkedList<K>();
   if(adj==null) return keys;
   return adj.getKeys();}

}
