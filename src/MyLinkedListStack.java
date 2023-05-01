public class MyLinkedListStack<T extends Comparable>
{
	private MyLinkedList<T> list;
	public MyLinkedListStack()
	{
		list = new MyLinkedList<>();
	}
	
	public void push(T item)
	{
		// adds element to the top
		list.add(item, 0);
	}
	
}
