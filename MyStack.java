import java.util.*;

public class MyStack<E> {
	private LinkedList<E> newList;
	
	public MyStack(){
		newList = new LinkedList<E>(); ;
	}

	public void push(E element) {
		newList.add(element);
	}

	public E pop() {
		//newList = new LinkedList<E>();
		//System.out.println("Just Entered pop.");
		E tmp = newList.getLast();
		newList.remove(tmp);
		//System.out.println("Value of tmp: " + tmp);
		//if(!newList.isEmpty()){
		//	newList.removeLast();		
		//}
		return tmp;
	}
	
	public boolean isEmpty(){
		//newList = new LinkedList<E>();
		return newList.isEmpty();
	}
	
	public String toString(){
		return newList.toString();
	}
}
	
	