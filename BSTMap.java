public class BSTMap<K extends Comparable<K>, T> implements Map<K, T> {
	public BSTNode<K, T> root; // Do not change this
	public BSTNode<K, T> current;
   public int size;
	
   
public BSTMap(){
		root= null;
      size=0;}
   
   // Return the size of the map.
public int size(){
return size;}
   
public boolean empty(){
return root == null;}


	// Return true if the map is full.
public boolean full(){
   return false;}

	// Remove all elements from the map.
public void clear(){
root =null;
size=0;}

	// Update the data of the key k if it exists and return true. If k does not exist, the method returns false.
public boolean update(K k, T e){
    if(!retrieve(k).first) return false;
    remove(k);
    insert(k,e);//if true ? 
    return true;
   }

	// Search for element with key k and returns a pair containing true and its data if it exists. If k does not exist, the method returns false and null.
public Pair<Boolean, T> retrieve(K k){				
		Pair<Boolean, T> n=new Pair<Boolean, T>(false,null);
      if(k==null) return n;
      if(empty())
         return n;

     BSTNode<K, T> p = root;//, q = root;

		while(p != null) {
			//q = p;
			if(k.compareTo(p.key)== 0) {
				//current = p;
            Pair<Boolean, T> pp=new Pair<Boolean, T>(true,p.data);
				//return new Pair(true,p.data);
            return pp;
			}
			else if(k.compareTo(p.key) < 0){
				p = p.left;}
			else
				p = p.right;
		}
		//current = q;
      Pair<Boolean, T> t=new Pair<Boolean, T>(false,null);
		return t;
}

// Insert a new element if does not exist and return true. If k already exists, return false.
public boolean insert(K k, T e){		
if(retrieve(k).first){
return false;}
		
BSTNode<K, T> p = new BSTNode<K, T>(k, e);

if(empty()){
root = p;
size++;
return true;}

BSTNode<K, T> q = root;
BSTNode<K, T> r = null;
		
while(q!=null ){
r=q;
if (k.compareTo(q.key)<0)
q= q.left;
else
q = q.right ;}

if (k.compareTo(r.key)<0)
r.left=p;
else 
r.right=p;

size++;
return true;

}

// Remove the element with key k if it exists and return true. If the element does not exist return false.

//----------------------------------------------------------------
public boolean remove(K k){
if(!retrieve(k).first) return false;
size--;
      // Search for k      
      
BSTNode<K, T> p = root;     
BSTNode<K, T> q = null; // Parent of p      
K key=k;
while (p != null){// Search for k     
if (key.compareTo(p.key)<0){          
q =p;         
p = p.left;} 
else if (key.compareTo(p.key)>0){          
q = p;
p = p.right;} 
else { // Found the key            // Check the three cases            
if ((p.left != null) && (p.right != null)) { 
		// Case 3: two children               // Search for the min in the right subtree               
      BSTNode<K, T> min = p.right;             
      q = p;
       while (min.left != null){             
       q = min;               
       min = min.left;}            
       p.key = min.key;
       p.data = min.data;
       key = min.key;
       p = min;
       // Now fall back to either case 1 or 2            
       }

           // The subtree rooted at p will change here            
           
       if (p.left != null) { // One child               
       p = p.left;
       } else{// One or no children               
       p = p.right;}
       if (q == null){// No parent for p, root must change               
       root = p;  
       } else{          
       if (key.compareTo(q.key)<0){                
       q.left = p;    
       } else{             
       q.right = p;}}
       return true;}}
       return false; // Not found  
        }



//----------------------------------------------------------------


// Return the list of keys in increasing order.

public List<K> getKeys(){
List<K> keys=new LinkedList<K>();
treekeys(root,keys);
return keys;
}

private void treekeys(BSTNode<K, T> node,List<K> keys){
if (node != null) {
treekeys(node.left,keys);
keys.insert(node.key);
treekeys(node.right,keys);}
}
 


}
