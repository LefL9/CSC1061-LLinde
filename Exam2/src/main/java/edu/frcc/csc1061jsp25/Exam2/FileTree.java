package edu.frcc.csc1061jsp25.Exam2;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;



public class FileTree implements Iterable <FileNode> {

	private FileNode root;
	
	public FileTree(String path) {
		root = new FileNode(path);
		buildTree(root);
	}

	/**
	 * Return a depth first post-order traversal iterator 
	 */
	@Override
	public Iterator<FileNode> iterator() {

		return new DepthFirstIterator();
	}
	
	/**
	 * 	TODO for Exam 2
	 *  Use recursion to build the tree from the directory structure.
	 *  For each of node starting from the root node use listFiles() from File to get 
	 *  the list of files in that directory/folder.
	 *  Create a node for each of the files and add it to a list of child nodes for the node
	 *  Do this recursively for all the nodes.  
	 * 
	 * @param fileNode
	 */
	private void buildTree(FileNode fileNode) {
		File file = fileNode.getFile();
		File[] children = file.listFiles();

		if (children != null) {
			for (File child : children) {
				FileNode childNode = new FileNode(child);
				fileNode.getChildNodes().add(childNode);
				if (child.isDirectory()) {
					buildTree(childNode); // <-- recursion
				}
			}
		}
	}
	
	/**
	 * TODO for Exam 2
	 * Iterator that does a post order traversal of the tree.
	 * For post-order traversal use the 2 stack approach outlined here: 
	 * https://www.geeksforgeeks.org/iterative-postorder-traversal/
	 * 
	 * @return 
	 */
		
	private class DepthFirstIterator implements Iterator<FileNode> {
		private Deque<FileNode> stack1 = new ArrayDeque<>();
		private Deque<FileNode> stack2 = new ArrayDeque<>();

		public DepthFirstIterator() {
			stack1.push(root);

			while (!stack1.isEmpty()) {
				FileNode current = stack1.pop();
				stack2.push(current);
				for (FileNode child : current.getChildNodes()) {
					stack1.push(child);
				}
			}
		}

		@Override
		public boolean hasNext() {
			return !stack2.isEmpty();
		}

		@Override
		public FileNode next() {
			return stack2.pop();
		}
	}

	/**
	 *  Returns an iterator that does a breadth first traversal of the tree using a queue.
	 * 
	 * @return
	 */
	public Iterator<FileNode> breadthFirstIterator() {
		
		return new BreadthFirstIterator();

	}	
	
	/** 
	 * TODO for Exam 2
	 * Iterator that does a breadth first traversal of the tree using a queue.
	 * 
	 */
	private class BreadthFirstIterator implements Iterator<FileNode> {
		private Queue<FileNode> queue = new ArrayDeque<>();

		public BreadthFirstIterator() {
			queue.add(root);
		}

		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}

		@Override
		public FileNode next() {
			FileNode current = queue.poll();
			queue.addAll(current.getChildNodes());
			return current;
		}
	}
}
