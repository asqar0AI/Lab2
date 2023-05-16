package Interfaces;

public interface MyHashTableInterface<K, V>
{
	int hash(K key);
	void put(K key, V value);
	V get(K key);
	V remove(K key);
	boolean constraints(V value);
	K getKey(V value);
}
