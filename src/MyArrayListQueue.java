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
}
