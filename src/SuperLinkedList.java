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
		Node newNode = new Node<>((E)item);
		if(this.head == null)
		{
			this.head = newNode;
			size++;
			return;
		}
		Node curNode = this.head;
		while(curNode.next != null)
		{
			curNode = curNode.next;
		}
		curNode.next = newNode;
		newNode.previous = curNode;
		size++;
	}
	
	@Override
	public void add(Object item, int index)
	{
	
	}
	
	@Override
	public boolean remove(Object item)
	{
		Node curNode  = this.head;
		Node prevNode = new Node();
		if(curNode != null && curNode.value.equals((E)item))
		{
			this.head = curNode.next;
			size--;
			return true;
		}
		while(curNode != null && curNode.value.equals((E)item))
		{
			prevNode = curNode;
			curNode = curNode.next;
			
		}
		if(curNode == null)
		{
			return false;
		}
		
		prevNode.next = curNode.next;
		curNode.next.previous = prevNode;
		size--;
		return true;
	}
	
	@Override
	public Object remove(int index)
	{
		int  curIndex = 0;
		Node curNode  = this.head;
		Node prevNode = this.head;
		if(index == 0)
		{
			this.head = curNode.next;
			return curNode;
		}
		while(curNode != null)
		{
			if(index == curIndex)
			{
				prevNode.next = curNode.next;
				curNode.next.previous = prevNode;
				size--;
				return curNode.value;
			}
			curIndex++;
			prevNode = curNode;
			curNode = curNode.next;
			
		}
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
