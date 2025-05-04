package edu.frcc.csc1061jsp25.MyAVLTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyAVLTree<K,V> implements Map<K,V>, Iterable<MyAVLTree<K, V>.Node>{
	
	private Node root = null;
	private int size = 0;
	private List<Node> path = new ArrayList<>();
	
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

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
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
	    Node current = root;
	    Comparable<K> k = (Comparable<K>) key;

	    while (current != null) {
	        if (k.compareTo(current.key) < 0) {
	            current = current.left;
	        } else if (k.compareTo(current.key) > 0) {
	            current = current.right;
	        } else {
	            return true;
	        }
	    }
	    return false;
	}

	@Override
	public boolean containsValue(Object value) {
		
		return false;
	}

	@Override
	public V get(Object key) {
		
		Node current = root;
		Comparable<K> k = (Comparable<K>) key;
		
		while(current != null) {
			if(k.compareTo(current.key) < 0) {
				current = current.left;
			}
			else if(k.compareTo(current.key) > 0) {
				current = current.right;
			}
			else {
				return current.value;
			}
		}
		
		return null;
	}

	@Override
	public V put(K key, V value) {
	    if (root == null) {
	        root = new Node(key, value);
	        size++;
	        return null;
	    }

	    Node parent = null;
	    Node current = root;
	    path.clear();

	    Comparable<K> k = (Comparable<K>) key;

	    while (current != null) {
	        path.add(current);
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

	    path.add(newNode);  // Add to path for balancing
	    balancePath();
	    size++;
	    return null;
	}
	
	private void updateHeight(Node node) {
	    int leftHeight = node.left != null ? node.left.height : -1;
	    int rightHeight = node.right != null ? node.right.height : -1;
	    node.height = Math.max(leftHeight, rightHeight) + 1;
	}
	
	private int balanceFactor(Node node) {
	    int leftHeight = node.left != null ? node.left.height : -1;
	    int rightHeight = node.right != null ? node.right.height : -1;
	    return rightHeight - leftHeight;
	}
	
	private void balancePath() {
		for(int i = path.size() - 1; i >= 0; i--) {
			Node current = path.get(i);
			updateHeight(current);
			Node parent = null;
			if(i > 0) {
				parent = path.get(i - 1);
			}
			switch(balanceFactor(current)) {
			case -2:
				if(balanceFactor(current.left) <= 0) {
					//LL imbalance
					balanceLL(current, parent);
				}
				else {
					//LR imbalance
					balanceLR(current, parent);
				}
				break;
			case 2:
				if(balanceFactor(current.right) >= 0) {
					//RR imbalance
					balanceRR(current,parent);
				}
				else {
					//RL imbalance
					balanceRL(current, parent);
				}
				break;
				
			}
		}
	}
	
	private void balanceLL(Node gp, Node parent) {
	    Node par = gp.left;
	    gp.left = par.right;
	    par.right = gp;

	    if (gp == root) {
	        root = par;
	    } else if (parent.left == gp) {
	        parent.left = par;
	    } else {
	        parent.right = par;
	    }

	    updateHeight(gp);
	    updateHeight(par);
	}
	
	
	private void balanceRR(Node node, Node parent) {
	    Node gp = node;       // grandparent (unbalanced node)
	    Node par = gp.right;  // parent of unbalanced node (right-heavy)
	    
	    if (gp == root) {
	        root = par;
	    } else {
	        if (parent.left == gp) {
	            parent.left = par;
	        } else {
	            parent.right = par;
	        }
	    }

	    gp.right = par.left;
	    par.left = gp;

	    updateHeight(gp);
	    updateHeight(par);
	}
	
	private void balanceLR(Node gp, Node parent) {
	    Node par = gp.left;
	    Node ch = par.right;
	   
	    par.right = ch.left;
	    gp.left = ch.right;

	    ch.left = par;
	    ch.right = gp;

	    if (gp == root) {
	        root = ch;
	    } else if (parent.left == gp) {
	        parent.left = ch;
	    } else {
	        parent.right = ch;
	    }

	    updateHeight(par);
	    updateHeight(gp);
	    updateHeight(ch);
	}
	
	private void balanceRL(Node node, Node parent) {
	    Node gp = node;
	    Node par = gp.right;
	    Node ch = par.left;

	    if (gp == root) {
	        root = ch;
	    } else {
	        if (parent.left == gp) {
	            parent.left = ch;
	        } else {
	            parent.right = ch;
	        }
	    }

	    par.left = ch.right;
	    gp.right = ch.left;

	    ch.right = par;
	    ch.left = gp;

	    updateHeight(gp);
	    updateHeight(par);
	    updateHeight(ch);
	}


	@Override
	public V remove(Object key) {
		
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		
		
	}

	@Override
	public void clear() {
		
		
	}

	@Override
	public Set<K> keySet() {
		
		return null;
	}

	@Override
	public Collection<V> values() {
		
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		
		return null;
	}

	@Override
	public Iterator iterator() {
		
		return new nonRecursiveIterator();
	}
	
	private class nonRecursiveIterator implements Iterator<Node> {
		//only push, pop, and isEmpty for a stack
		private Deque<Node> stack = new ArrayDeque<>();
		
		public nonRecursiveIterator() {
			pushOnStack(root);
				
		}
		
		public void pushOnStack(Node node) {
			Node current = node;
			while(current != null) {
				stack.push(current);
				current = current.left;
			}
			
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public Node next() {
			
			Node node = stack.pop();
			V value = node.value;
			pushOnStack(node.right);
			return node;
			
		}
			
	}
	
	private class RecursiveIterator implements Iterator<V> {
		
		private List<V> list = new LinkedList<>();
		
		public RecursiveIterator() {
			inorder(root);	
		}
		
		private void preorder(Node node) {
			if(node == null) {
				return;
			}
			list.add(node.value);
			preorder(node.left);
			preorder(node.right);
			
		}
		
		private void postorder(Node node) {
			if(node == null) {
				return;
			}
			postorder(node.left);
			postorder(node.right);
			list.add(node.value);
			
			
		}
		private void inorder(Node node) {
			if(node == null) {
				return;
			}
			inorder(node.left);
			list.add(node.value);
			inorder(node.right);
			
				
		}

		@Override
		public boolean hasNext() {
			
			return !list.isEmpty();
		}

		@Override
		public V next() {
			
			return list.remove(0);
		}
		
	}
	

}
