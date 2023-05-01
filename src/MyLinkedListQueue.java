import java.util.NoSuchElementException;

public class MyLinkedListQueue<T extends Comparable>
{
	private MyLinkedList<T> list;
	
	public MyLinkedListQueue()
	{
		list = new MyLinkedList<>();
	}
	
	public void enqueue(T item)
	{
		// adding element to queue
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
	
	public T peek()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		return (T)list.get(0);
	}
	
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	public int size()
	{
		return list.size();
	}
}
