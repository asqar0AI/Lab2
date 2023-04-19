import Interfaces.MyListInterface;

public class SuperLinkedList<E> implements MyListInterface
{
	private int size = 0;
	
	private class Node<E>
	{
		private E value;
		Node<E> next;
		Node<E> previous;
		
		public Node(E value)
		{
			this.value = value;
		}
		public Node() {}
	}
	
	private Node head;
	public SuperLinkedList()
	{
		this.head = null;
	}
	@Override
	public int size()
	{
		return size;
	}
	
	@Override
	public boolean contains(Object o)
	{
		Node currentNode = this.head;
		while(currentNode != null)
		{
			if(currentNode.value.equals((E)o))
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void add(Object item)
	{
	
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
	
	public void printList()
	{
		Node currentNode = this.head;
		while(currentNode != null)
		{
			System.out.print(currentNode.value + " ");
			currentNode = currentNode.next;
		}
		System.out.println();
	}
}
