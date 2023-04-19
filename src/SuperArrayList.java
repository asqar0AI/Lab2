import Interfaces.MyListInterface;

public class SuperArrayList<T> implements MyListInterface
{
	private int size;
	private T[] arr;
	public SuperArrayList(int size)
	{
		this.arr = (T[])new Object[5];
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
		arr[size] = (T)item;
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
	
	}
	
	@Override
	public boolean remove(Object item)
	{
		return false;
	}
	
	@Override
	public Object remove(int index)
	{
		return null;
	}
	
	@Override
	public void clear()
	{
	
	}
	
	@Override
	public Object get(int index)
	{
		return null;
	}
	
	@Override
	public int indexOf(Object o)
	{
		return 0;
	}
	
	@Override
	public int lastIndexOf(Object o)
	{
		return 0;
	}
	
	@Override
	public void sort()
	{
	
	}
	
	@Override
	public String toString()
	{
		String res = "[";
		for(int i = 0; i < size; i++) {
			res += arr[i];
		}
		return res;
	}
}
