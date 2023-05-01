import Interfaces.MyListInterface;

public class MyLinkedList<E extends Comparable> implements MyListInterface
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
	public MyLinkedList()
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
		Node curNode = this.head;
		while(curNode != null)
		{
			if(curNode.value.equals((E)o))
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
		Node curNode = this.head;
		Node newNode  = new Node<>((E)item);
		int  curIndex = 0;
		if(index == 0)
		{
			Node temp = this.head;
			this.head = newNode;
			this.head.next = temp;
			return;
		}
		else if(index >= size)
		{
			add((E)item);
			return;
		}
		
		while(curNode != null)
		{
			if(curIndex == index)
			{
				curNode.previous.next = newNode;
				newNode.next = curNode;
				size++;
				return;
			}
			curIndex++;
			curNode = curNode.next;
		}
		
		System.out.println("Couldn't add the element");
	}
	
	@Override
	public void addAll(Object[] item)
	{
		if(item.length == 0)
			return;
		Node newNode = new Node<>((E)item[0]);
		if(this.head == null)
		{
			this.head = newNode;
			size ++;
			if(item.length == 1)
				return;
		}
		Node curNode = this.head;
		while(curNode.next != null)
		{
			curNode = curNode.next;
		}
		for(int i = 1; i < item.length; i ++)
		{
			newNode = new Node<>((E)item[i]);
			curNode.next = newNode;
			newNode.previous = curNode;
			size ++;
		}
	}
	// Created 1st new method addAll for the 2nd assignment defence
	
	
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
		this.head = new Node<>();
		this.size = 0;
	}
	
	@Override
	public Object get(int index)
	{
		int  curIndex = 0;
		Node curNode  = this.head;
		while(curNode != null)
		{
			if(index == curIndex)
			{
				return curNode.value;
			}
			curIndex++;
			curNode = curNode.next;
		}
		return null;
	}
	
	@Override
	public int indexOf(Object o)
	{
		int  index   = 0;
		Node curNode = this.head;
		while(curNode != null)
		{
			if(curNode.value.equals((E)o))
			{
				return index;
			}
			index++;
			curNode = curNode.next;
		}
		return -1;
	}
	
	@Override
	public int lastIndexOf(Object o)
	{
		int  index   = 0;
		int  flag    = -1;
		Node curNode = this.head;
		while(curNode != null)
		{
			if(curNode.value.equals((E)o))
			{
				flag = index;
			}
			index++;
			curNode = curNode.next;
		}
		return flag;
	}
	
	@Override
	public void sort()
	{
		int  n       = 0;
		Node curNode = this.head;
		while(curNode != null)
		{
			n++;
			curNode = curNode.next;
		}
		
		for(int i = 0; i < n; i++)
		{
			curNode = this.head;
			while(curNode.next != null)
			{
				E data1 = (E)curNode.value;
				E data2 = (E)curNode.next.value;
				
				if(data1.compareTo(data2) > 0)
				{
					curNode.next.value = data1;
					curNode.value = data2;
				}
				curNode = curNode.next;
			}
		}
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
