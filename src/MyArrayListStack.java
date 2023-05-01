import java.util.ArrayList;
import java.util.EmptyStackException;
public class MyArrayListStack<T extends Comparable>
{
	private MyArrayList<T> list;
	
	/**
	 * Constructs an empty stack.
	 */
	public MyArrayListStack(int size)
	{
		list = new MyArrayList<T>(size);
	}
	
	/**
	 * Pushes an element onto the top of the stack.
	 */
	public void push(T item)
	{
		list.add(item);
	}
	
	/**
	 * Returns true if the stack is empty, false otherwise.
	 */
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	/**
	 * Gets the number of elements in the stack.
	 */
	public int size()
	{
		return list.size();
	}
}