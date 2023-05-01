import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * A queue implementation based on ArrayList.
 */
public class MyArrayListQueue<T extends Comparable>
{
	private MyArrayList<T> list;
	
	/**
	 * Constructs an empty queue.
	 */
	public MyArrayListQueue(int size)
	{
		list = new MyArrayList<T>(size);
	}
	
	/**
	 * Adds an element to the back of the queue.
	 */
	public void enqueue(T item)
	{
		list.add(item);
	}
	
	/**
	 * Removes and returns the element at the front of the queue.
	 */
	public T dequeue()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		return (T)list.remove(0);
	}
	
	/**
	 * Returns the element at the front of the queue without removing it.
	 */
	public T peek()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		return (T)list.get(0);
	}
	
	/**
	 * Returns true if the queue is empty, false otherwise.
	 */
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	/**
	 * Returns the number of elements in the queue.
	 */
	public int size()
	{
		return list.size();
	}
}
