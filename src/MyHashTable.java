

import java.util.Objects;

public class MyHashTable<K extends Comparable, V extends Comparable>
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
	
	public int hash(Object key)
	{
		int hashCode = key.hashCode();
		return (hashCode & 0x7fffffff) % M;
	}
	
	public void put(K key, V value)
	{
		int            index = hash(key);
		HashNode<K, V> node  = chainArray[index];
		while(node != null)
		{
			if(node.key.equals(key))
			{
				node.value = value;
				return;
			}
			node = node.next;
		}
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		newNode.next = chainArray[index];
		chainArray[index] = newNode;
		size++;
	}
	
	public V get(K key)
	{
		int            index = hash(key);
		HashNode<K, V> node  = chainArray[index];
		while(node != null)
		{
			if(node.key.equals(key))
			{
				return node.value;
			}
			node = node.next;
		}
		return null;
	}
	
	public Object remove(Object key)
	{
		return null;
	}
	
	public boolean constraints(Object value)
	{
		return false;
	}
	
	public Object getKey(Object value)
	{
		return null;
	}
}
