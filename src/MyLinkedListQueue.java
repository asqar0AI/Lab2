public class MyLinkedListQueue<T extends Comparable>
{
	private MyLinkedList<T> list;
	
	public MyLinkedListQueue()
	{
		list = new MyLinkedList<>();
	}
	
	public void enqueue(T item)
	{
		list.add(item);
	}
}
