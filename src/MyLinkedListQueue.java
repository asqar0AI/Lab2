import java.util.NoSuchElementException;

public class MyLinkedListQueue<T extends Comparable>
{
	private MyLinkedList<T> list;
	
	public MyLinkedListQueue()
	{
		// creating an object
		list = new MyLinkedList<>();
	}
	
	public void enqueue(T item)
	{
		// adding an item to the end of the queue
		list.add(item);
	}
	public T dequeue()
	{
		// getting the value of the first element of the queue & removing an item from the front of the queue
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		return (T)list.remove(0);
	}
	
	public T peek()
	{
		// just getting the value of the first element of the queue
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		return (T)list.get(0);
	}
	
	public boolean isEmpty()
	{
		// checks if the queue is empty
		return list.isEmpty();
	}
	
	public int size()
	{
		// getting the value of size of queue
		return list.size();
	}
}
