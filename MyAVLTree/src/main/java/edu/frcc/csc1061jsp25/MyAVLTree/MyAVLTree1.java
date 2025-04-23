package edu.frcc.csc1061jsp25.MyAVLTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MyAVLTree1<K, V> implements Map<K, V>, Iterable<edu.frcc.csc1061jsp25.MyAVLTree.MyAVLTree.Node> {
	private Node root = null;
	private int size = 0;
	private List<Node> path = new ArrayList<>() ;

	protected class Node {
		private K key;
		private V value;
		private Node left;
		private Node right;
		private int height;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			height = 0;
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
		path.clear();
		Comparable<K> k = (Comparable<K>) key;

		while (current != null) {
			path.add(current);
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
			updateHeight(newNode);
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
		updateHeight(newNode);
		balancePath();
		size++;
		return null;
	}

	private void updateHeight(Node node) {
		if (node.left == null && node.right == null) {
			node.height = 0;
		} else if (node.left == null) {
			node.height = node.right.height + 1;
		} else if (node.right == null) {
			node.height = node.left.height + 1;
		} else {
			node.height = Math.max(node.left.height, node.right.height) + 1;
		}
	}
	
	private int balanceFactor(Node current) {
		int balanceFactor = 0;

		if (current.left == null) {
			balanceFactor = current.height;
		} else if (current.right == null) {
			balanceFactor = -current.height;
		} else {
			balanceFactor = current.right.height - current.left.height;
		}

		return balanceFactor;
	}
	
	private void balancePath() {
		for(int i = path.size() - 1; i >= 0; i--) {
			Node current = path.get(i);
			updateHeight(current);
			Node parent = null;
			if(i>0) {
				parent = path.get(i-1);
			}
			switch(balanceFactor(current)) {
			case -2:
				if(balanceFactor(current.left) <= 0) {
					//LL imbalance
					balanceLL(current,parent);
				}
				else {
					// LR imbalance
					balanceLR(current,parent);
				}
				break;
			case 2:
				if(balanceFactor(current.right) >= 0) {
					//RR imbalance
					balanceRR(current,parent);
				}
				else {
					// RL imbalance
				}
				break;
			}
		}
	}
	
	private void balanceLL(Node node, Node parent) {
		Node ggp = parent;
		Node gp = node;
		Node par = gp.left;
		Node ch = par.left;
		
		if(gp == root) {
			root = par;
		}
		if(ggp.right == gp) {
			ggp.right = par;
		}
		else {
			ggp.left = par;
		}
		gp.left = par.right;
		par.right = gp;
		
		updateHeight(gp);
		updateHeight(ch);
		updateHeight(par);
	}
	
	private void balanceRR(Node node, Node parent) {
		
	}
	
	private void balanceLR(Node node, Node parent) {
		Node ggp = parent;
		Node gp = node;
		Node par = gp.left;
		Node ch = par.right;
		
		if(gp == root) {
			root = ch;
		}
		else {
			if(ggp.left == par) {
				ggp.left = ch;
			}
			else {
				ggp.right = ch;
			}
		}
		par.right = ch.left;
		gp.left = ch.right;
		
		ch.left = par;
		ch.right = gp;
		
		updateHeight(gp);
		updateHeight(par);
		updateHeight(ch);
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
	public Iterator iterator() {

		return new nonRecursiveIterator();
	}

	private class nonRecursiveIterator implements Iterator<Node> {
		private Queue<Node> list = new ArrayDeque<>();

		public nonRecursiveIterator() {
			preorder(root);
		}

		private void preorder(Node node) {
			if (node == null) {
				return;
			}
			list.add(node.value);
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
