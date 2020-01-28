public class Node<T>{

public T data;
public Node<T> next;
public Node<T> previous;


public Node(){
data=null;
next=null;
previous=null;
}

public Node(T d){
data=d;
next=null;
previous=null;
}

}