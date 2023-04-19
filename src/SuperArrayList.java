import Interfaces.MyListInterface;

public class SuperArrayList<T> implements MyListInterface
{
	private int size;
	private T[] arr;
	public SuperArrayList(int size)
	{
		this.arr = (T[])new Object[size];
		this.size = 0;
	}
	@Override
	public int size()
	{
		return this.size;
	}
	
	@Override
	public boolean contains(Object o)
	{
		for(int i = 0; i < size; i ++)
		{
			if(arr[i].equals(o))
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void add(Object item)
	{
		if(size == arr.length)
		{
			expand();
		}
		arr[size++] = (T)item;
	}
	
	private void expand()
	{
		T[] temp;
		temp = (T[]) new Object[size + 5];
		for(int i = 0; i < size; i ++)
		{
			temp[i] = arr[i];
		}
		arr = temp;
	}
	
	@Override
	public void add(Object item, int index)
	{
		if(index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		if(index >= size)
		{
			add(item);
		}
		if(size == arr.length)
		{
			expand();
		}
		for(int i = size - 1; i >= index; i --)
		{
			arr[i + 1] = arr[i];
		}
		arr[index] = (T)item;
		size ++;
	}
	
	@Override
	public boolean remove(Object item)
	{
		for(int i = 0; i < size; i ++)
		{
			if(arr[i].equals(item))
			{
				remove(i);
				size --;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Object remove(int index)
	{
		T temp = arr[index];
		
	}
	
	@Override
	public void clear()
	{
		arr = (T[]) new Object[5];
		size = 0;
	}
	
	@Override
	public Object get(int index)
	{
		validIndexChecker(index);
		return arr[index];
	}
	
	@Override
	public int indexOf(Object o)
	{
		for(int i = 0; i < size; i++)
		{
			if(arr[i].equals(o))
			{
				return i;
			}
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public int lastIndexOf(Object o)
	{
		for(int i = size - 1; i >= 0; i--)
		{
			if(arr[i].equals(o))
			{
				return i;
			}
		}
		throw new IndexOutOfBoundsException();
		
	}
	
	private void validIndexChecker(int index)
	{
		if(index >= size || index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
	}
	
	@Override
	public void sort()
	{
	
	}
	
	@Override
	public String toString()
	{
		String res = "[";
		for(int i = 1; i < size; i++)
		{
			res += arr[i];
			if(i < size - 1)
			{
				res += ", ";
			}
		}
		res += "]";
		return res;
	}
}
