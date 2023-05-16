import Interfaces.MyHashTableInterface;

public class MyHashTable<V, K extends Comparable> implements MyHashTableInterface
{
	private class HashNode<K, V>
	{
	
	}
	
	private HashNode<K, V>[] chainArray;
	private int              M = 11;
	private int              size;
	@Override
	public int hash(Object key)
	{
		return 0;
	}
	
	@Override
	public void put(Object key, Object value)
	{
	
	}
	
	@Override
	public Object get(Object key)
	{
		return null;
	}
	
	@Override
	public Object remove(Object key)
	{
		return null;
	}
	
	@Override
	public boolean constraints(Object value)
	{
		return false;
	}
	
	@Override
	public Object getKey(Object value)
	{
		return null;
	}
}
