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
	public void push(T item)
	{
		list.add(item);
	}
}