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
	public T dequeue()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		return (T)list.remove(0);
	}
	
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
