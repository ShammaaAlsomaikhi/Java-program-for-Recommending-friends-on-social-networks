public class PQKImp<P extends Comparable<P>, T> implements PQK<P, T> {
	private int size;
   private PQNode<P,T> head,tail;
   private int maxsize;
    
   

public PQKImp(int k) {
  head=tail=null;
   size=0;
   maxsize =k;
}
      
 
	// Return the length of the queue
public int length(){    
return size; }

	// Enqueue a new element. The queue keeps the k elements with the highest priority. In case of a tie apply FIFO.
public void enqueue(P pr, T e){
if(size<maxsize)
 enqueue2(pr,e);
 
 else if(size==maxsize){
 
 if(pr.compareTo(tail.priority)<=0)
 return;
 
 else{
 enqueue2(pr,e); // size increased by 1
 
 PQNode<P,T> node=head;
 
 if(node == null) return;
 if(node.next==null) return;
 
 while(node.next.next!=null)
 node=node.next;
 
 node.next=null;
 tail=node;
 size--;}//end else
 }//end if
}

private void enqueue2(P pr, T e){
 PQNode<P,T> node =new PQNode<P,T>(e,pr);
 
 if(head==null)
 head=tail=node;
 
 else{
 if(pr.compareTo(head.priority)>0){
 node.next=head;
 head=node;}
 
 else{
 PQNode<P,T> n=null;
 PQNode<P,T> m=head;
 
 while(m!=null&&pr.compareTo(m.priority)<=0){
 n=m; 
 m=m.next;}
 
 n.next=node;
 node.next=m;
 
 if(m==null)
 tail=node;}
}//end else

 size++;}
   
	// Serve the element with the highest priority. In case of a tie apply FIFO.
public Pair<P, T> serve(){
  if(head==null) return null;
  PQNode<P,T> h = head;

  head = head.next;
  
  size--;
  
Pair<P, T> n=new Pair<P, T>(h.priority,h.data);

return n ;}

}