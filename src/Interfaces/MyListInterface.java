package Interfaces;

public interface MyListInterface<T>
{
	int size();
	
	boolean contains(Object o);
	
	void add(T item);
	
	void add(T item, int index);
	
	void addAll(T[] item);
	
	boolean remove(T item);
	
	T remove(int index);
	
	void clear();
	
	T get(int index);
	
	int indexOf(Object o);
	
	int lastIndexOf(Object o);
	
	void sort();
}