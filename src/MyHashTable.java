import Interfaces.MyHashTableInterface;

public class MyHashTable<K, V extends Comparable> implements MyHashTableInterface
{
	private class HashNode<K, V>
	{
		private K key;
		private V values;
		private HashNode<K, V> next;
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
