public class PQNode<P,T> {

public T data;
public P priority;
public PQNode<P,T> next;
public PQNode<P,T> previous;
	
public PQNode(){
data=null;
priority=null;
next = null;
previous=null;}
	
public PQNode(T e, P pr) {
data = e;
priority = pr;
next=null;
previous=null;}	

public PQNode(T e) {
data = e;
next=null;
previous=null;}

}
