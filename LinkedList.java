public class LinkedList<T> implements List<T>{

private Node<T> head;
private Node<T> current;
int size=0;

public LinkedList(){
head = current =null;
size=0;}
public boolean empty(){
return head ==null;}

public boolean full(){
return false;}

public void findFirst(){
current = head;}

public void findNext(){
current=current.next;}

public boolean last(){
return current.next == null;}

public T retrieve(){
return current.data;}

public void update(T e){
current.data = e;}

public void insert(T e){
Node<T> tmp = new Node<T>(e);
if(empty()){
current = head = tmp;}

else {
tmp.next = current.next;
tmp.previous = current;
if(current.next != null)
current.next.previous = tmp;
current.next = tmp;
current = tmp;}
size++;
}

public void remove(){
if(current == head) {
head = head.next;
if(head != null)
head.previous = null;}

else {
current.previous.next = current.next;
if(current.next != null)
current.next.previous = current.previous;}

if(current.next == null)
current = head;

else
current = current.next;

size--;
}

// Return the number of elements in the list.
public int size(){
return size;}

// Searches for e in the list. Current must not change.
public boolean exists(T e){
if(head==null) return false;
Node<T> tmp = head;
boolean flag=false;

while(tmp !=null){
if(tmp.data.equals(e)){
flag =true; break;}
tmp=tmp.next;}

return flag;}


} 