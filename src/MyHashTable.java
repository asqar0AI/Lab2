

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
	
	/**
	 * Inserts a key-value pair into the hash table.
	 * If the key already exists, the corresponding value is updated.
	 */
	public void put(K key, V value)
	{
		int            index = hash(key);
		HashNode<K, V> node  = chainArray[index];
		
		// Search for the key in the chain
		while(node != null)
		{
			if(node.key.equals(key))
			{
				// Key found, update the value
				node.value = value;
				return;
			}
			node = node.next;
		}
		
		// Key not found, create a new node and add it to the beginning of the chain
		HashNode<K, V> newNode = new HashNode<>(key, value);
		newNode.next = chainArray[index];
		chainArray[index] = newNode;
		size++;
	}
	
	/**
	 * Retrieves the value associated with the specified key from the hash table.
	 */
	public V get(K key)
	{
		int            index = hash(key);
		HashNode<K, V> node  = chainArray[index];
		
		// Search for the key in the chain
		while(node != null)
		{
			if(node.key.equals(key))
			{
				// Key found, return the associated value
				return node.value;
			}
			node = node.next;
		}
		
		// Key not found
		return null;
	}
	
	/**
	 * Removes the key-value pair with the specified key from the hash table
	 * and returns its associated value.
	 */
	public V remove(K key)
	{
		int            index = hash(key);
		HashNode<K, V> node  = chainArray[index];
		HashNode<K, V> prev  = null;
		
		// Search for the key in the chain
		while(node != null)
		{
			if(node.key.equals(key))
			{
				if(prev == null)
				{
					// Key found at the beginning of the chain
					chainArray[index] = node.next;
				}
				else
				{
					// Key found in the middle or end of the chain
					prev.next = node.next;
				}
				size--;
				return node.value;
			}
			prev = node;
			node = node.next;
		}
		
		// Key not found
		return null;
	}
	
	/**
	 * Checks if the hash table contains the specified key.
	 */
	public boolean containsKey(K key)
	{
		int            index = hash(key);
		HashNode<K, V> node  = chainArray[index];
		while(node != null)
		{
			if(node.key.equals(key))
			{
				// Key found in the hash table
				return true;
			}
			node = node.next;
		}
		
		// Key not found
		return false;
	}
	
	/**
	 * Checks if the hash table contains the specified value.
	 */
	public boolean containsValue(V value)
	{
		for(int i = 0; i < chainArray.length; i++)
		{
			HashNode<K, V> node = chainArray[i];
			while(node != null)
			{
				if(node.value.equals(value))
				{
					// Value found in the hash table
					return true;
				}
				node = node.next;
			}
		}
		
		// Value not found
		return false;
	}
	
	/**
	 * Retrieves the key associated with the specified value from the hash table.
	 */
	public K getKey(V value)
	{
		for(int i = 0; i < chainArray.length; i++)
		{
			HashNode<K, V> node = chainArray[i];
			while(node != null)
			{
				if(node.value.equals(value))
				{
					// Value found, return the associated key
					return node.key;
				}
				node = node.next;
			}
		}
		
		// Value not found
		return null;
	}
}
