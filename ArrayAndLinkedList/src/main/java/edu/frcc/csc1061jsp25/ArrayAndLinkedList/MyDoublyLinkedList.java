package edu.frcc.csc1061jsp25.ArrayAndLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyDoublyLinkedList<E> implements List<E> {

	private Node head;
	private Node tail;
	private int size;
	

	private class Node {
		E data;
		Node next;
		Node prev;

		public Node(E data) {
			this.data = data;
			next = null;
		}
	}

	public MyDoublyLinkedList() {
		head = null;
		size = 0;
		tail = null;
	}

	@Override
	public int size() {
		int count = 0;
		for (Node node = head; node != null; node = node.next) {
			count++;
		}
		return count;
		// return size;
	}

	@Override
	public boolean isEmpty() {
		// if(head == null) <- asking, if yes return value
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		if(indexOf(o) != -1) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		int i = 0;
		for (Node node = head; node != null; node = node.next) {
			array[i++] = node.data;
			//i++ means incrementing AFTER, ++i increments before
		}
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		Node newNode = new Node(e);
		if (head == null) {
			head = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
		}
		tail = newNode;
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o); 
		if(index == -1) {
			return false;
		}
		remove(index);
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node.data;
	}

	@Override
	public E set(int index, E element) {
		Node node = getNode(index);
		E old = node.data;
		node.data = element;
		return old;
	}

	private Node getNode(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	@Override
	public void add(int index, E element) {
		Node newNode = new Node(element);

		if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			Node prevNode = getNode(index - 1);
			newNode.next = prevNode.next;
			prevNode.next = newNode;
		}
		size++;
	}

	@Override
	public E remove(int index) {
		Node node = getNode(index);
		E data = node.data;

		if (index == 0) {
			head = head.next;
		} else {
			Node prevNode = getNode(index - 1);
			prevNode.next = prevNode.next.next;
		}
		size--;
		return data;
	}

	@Override
	public int indexOf(Object o) {
		int index = 0;
		for (Node node = head; node != null; node = node.next) {
			if (o.equals(node.data)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = size -1;
		int foundIndex = -1;
		for (Node node = tail; node != null; node = node.prev) {
			if (o.equals(node.data)) {
				foundIndex = index;
				break;
			}
			index++;
		}
		return foundIndex;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
