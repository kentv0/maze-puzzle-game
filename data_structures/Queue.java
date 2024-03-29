package data_structures;

import java.util.Iterator;

/**
 * The Queue interface Class for {@link LinearList.class}.
 *
 * @version     0.1.0 01 Oct 2015
 * @author      Alan Riggins
 */
public class Queue<E> {
    private LinearListADT<E> queue;
    
    public Queue() {
        queue = new LinearList<E>(); 
    }
    
    // inserts the object obj into the queue
    public void enqueue(E obj) {
        queue.addLast(obj);
    }
     
    // removes and returns the object at the front of the queue   
    public E dequeue() {
        return queue.removeFirst();
    }
    
    // returns the number of objects currently in the queue    
    public int size()  {
        return queue.size();
    }
    
    // returns true if the queue is empty, otherwise false   
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    // returns but does not remove the object at the front of the queue   
    public E peek() {
        return queue.peekFirst();
    }
    
    // returns true if the Object obj is in the queue    
    public boolean contains(E obj) {
        return queue.contains(obj);
    }
    
    // returns the queue to an empty state  
    public void makeEmpty() {
        queue.clear();
    }
    
    // removes the Object obj if it is in the queue and
    // returns true, otherwise returns false.
    public boolean remove(E obj) {
        if(queue.remove(obj) != null)
            return true;
        return false;
    }
    // returns an iterator of the elements in the queue.  The elements
    // must be in the same sequence as dequeue would return them.    
    public Iterator<E> iterator() {
        return queue.iterator();
    }
}
