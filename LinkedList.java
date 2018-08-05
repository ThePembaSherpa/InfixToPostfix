import java.util.*;

public class LinkedList<E> implements Iterable<E>{
	private Node<E> top;
	int size = 0; 
   
   //Constructor
   public LinkedList(){
      top = null; // top : first term in the list
   }

   //Inserts a new node to the end of this list.
   public void add(E element){
		if( top == null)
			addFirst(element);
		else{
			Node<E> tmp = top;
			while(tmp.next != null) tmp = tmp.next;

			tmp.next = new Node<E>(element, null);
		}
		size ++;
   }
   
   //Inserts a new node before a node containing the element.
	public void insertAt(E element, int index){
		
		Node<E> tmp = top;
		if(index > this.size){
			System.out.println("Index out of bound");
		}
		else{
			Node<E> newNode = new Node<E>(element, null);
			for(int i =0; i< index; i++){
				tmp = tmp.next;
			}
			Node<E> nextNode = tmp.next;
			tmp.setNextNode(newNode);
			newNode.setNextNode(nextNode);
		}
		
		size++;
		
	}
   
    //Removes the first occurrence of the specified element in this list.
    public void remove(E element){
		
		if(top == null)
			throw new RuntimeException("cannot delete");

		if( top.data.equals(element) ){
			top = top.next;
			return;
		}

		Node<E> current  = top;
		Node<E> previous = null;

		while(current != null && !current.data.equals(element) ){
         previous = current;
         current = current.next;
		}

		if(current == null)
			throw new RuntimeException("cannot delete");

		//delete current node
		previous.next = current.next;
		size--;
   }
   
    
	//Removes all nodes from the list.
    public void clear(){
      top = null;
   }

   
    //Returns true if the list is empty
	public boolean isEmpty(){
      return top == null;
   }
	
	
	//Returns the nth term from the first term(0)
    public E getNthFromFirst(int n){
      int pos = n;
	  return get(n);
   }
 
 
	//Returns the nth term from the last term(size-1)
   public E getNthFromLast(int n){
		int pos = size-n;
	    return get(n);
   }
   
   
   //Returns a string representation
	public String toString(){
		StringBuffer result = new StringBuffer();
		for(Object x : this)
      	result.append(x + " ");

		return result.toString();
   }   

   //Adds element to the first location
	public void addFirst(E element){
		top = new Node<E>(element, null);
	}
   
    public E getFirst(){
		//System.out.println(top.getValue());
		if(top == null) throw new NoSuchElementException();

		return top.data;
	}
 
	public E removeFirst(){
		E tmp = getFirst();
		top = top.next;
		return tmp;
	}
	
	
	public E getLast(){
		
		if(top == null) throw new NoSuchElementException();

		Node<E> tmp = top;
		while(tmp.next != null) tmp = tmp.next;

		return tmp.data;	
	}
	//Returns the data at the specified position in the list.
	public E get(int pos){
		if (top == null) throw new IndexOutOfBoundsException();
	
		Node<E> tmp = top;
		for (int k = 0; k < pos; k++) tmp = tmp.next;

		if( tmp == null) throw new IndexOutOfBoundsException();

		return tmp.data;
	}

	//Node class
	private static class Node<E>{
		private E data;
		private Node<E> next;

		public Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
		
		public E getValue(){
			return this.data;
		}
		
		public Node<E> getNextNode(){
			return this.next;
		}
		
		public void setValue(E element){
			this.data = element;
		}
		
		public void setNextNode(Node<E> givenNode){
			this.next = givenNode;
		}
	}

	
	public Iterator<E> iterator(){
		return new LinkedListIterator();
	}

	
	//Iterator Class	
	private class LinkedListIterator  implements Iterator<E>{
		private Node<E> next;

		public LinkedListIterator(){
			next = top;
		}

		public boolean hasNext(){
			return next != null;
		}

		public E next(){
			if (!hasNext()) throw new NoSuchElementException();
			E res = next.data;
			next = next.next;
			return res;
        }

		public void remove() { throw new UnsupportedOperationException(); }
	}	
}