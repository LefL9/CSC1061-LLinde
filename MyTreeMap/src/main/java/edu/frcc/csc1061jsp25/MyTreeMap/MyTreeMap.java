package edu.frcc.csc1061jsp25.MyTreeMap;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MyTreeMap<K, V> implements Map<K, V>, Iterable<K>{
	private Node root = null;
	private int size = 0;

	private class Node {
		private K key;
		private V value;
		private Node left;
		private Node right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	@Override
	public int size() {
		return size;
	}

	
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		if (get(key) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		Node current = root;
		Comparable<K> k = (Comparable<K>) key;

		while (current != null) {
			if (k.compareTo(current.key) < 0) {
				current = current.left;
			} else if (k.compareTo(current.key) > 0) {
				current = current.right;
			} else {
				return current.value;
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		if (root == null) {
			Node newNode = new Node(key, value);
			root = newNode;
			size++;
			return null;
		}

		Node parent = null;
		Node current = root;
		Comparable<K> k = (Comparable<K>) key; // cast key to comparable, can call compareto on it
		while (current != null) {
			if (k.compareTo(current.key) < 0) {
				parent = current;
				current = current.left;
			} else if (k.compareTo(current.key) > 0) {
				parent = current;
				current = current.right;
			} else {
				V oldVal = current.value;
				current.value = value;
				return oldVal;
			}
		}

		Node newNode = new Node(key, value);
		if (k.compareTo(parent.key) < 0) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}

		size++;
		return null;
	}
//Homework
	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {

		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Iterator<K> iterator() {
		
		return new RecursiveIterator();
	}
	
	private class RecursiveIterator implements Interator<K>{
		private Queue<K> list = new ArrayDeque<>();
		
		public RecursiveIterator() {
			preorder(root);
		}
		
		private void preorder(Node node) {
			if (node == null) {
				return;
			}
			list.add(node.key);
			preorder(node.left);
			preorder(node.right);
		}
		
		private void postorder(Node node) {
			if (node == null) {
				return;
			}
			postorder(node.left);
			postorder(node.right);
			list.add(node.key);
		}
		private void inorder(Node node) {
			if (node == null) {
				return;
			}
			inorder(node.left);
			list.add(node.key);
			inorder(node.right);
		}
		
	}

}
