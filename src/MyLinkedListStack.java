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
		// gets value of element at top and deletes the element
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		return (T)list.remove(0);
	}
	
	public T peek()
	{
		// just gets the value of element at top
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		return (T)list.get(0);
	}
	
	public boolean isEmpty()
	{
		// checks if the Stack is empty
		return list.isEmpty();
	}
	
	public int size()
	{
		// gets the value of size of Stack
		return list.size();
	}
	
}
