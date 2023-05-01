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
