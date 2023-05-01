import java.util.EmptyStackException;

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
	
	public T pop()
	{
		if(list.size() == 0)
		{
			throw new EmptyStackException();
		}
		return (T)list.remove(0);
	}
}
