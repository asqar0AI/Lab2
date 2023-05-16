import Interfaces.MyHashTableInterface;

import java.util.Objects;

public class MyHashTable<K, V extends Comparable> implements MyHashTableInterface
{
	private class HashNode<K, V>
	{
		private K key;
		private V value;
		private HashNode<K, V> next;
		public HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public String toString()
		{
			return "{" + key + ' ' + value + "}";
		}
	}
	
	private HashNode<K, V>[] chainArray;
	private int              M = 11;
	private int              size;
	
	public MyHashTable()
	{
		chainArray = new HashNode[M];
		size = 0;
	}
	
	public MyHashTable(int capacity)
	{
		chainArray = new HashNode[capacity];
		size = 0;
	}
	
	@Override
	public int hash(Object key)
	{
		int hashCode = key.hashCode();
		return (hashCode & 0x7fffffff) % M;
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
