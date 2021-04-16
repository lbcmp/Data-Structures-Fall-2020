import java.util.Iterator;
import java.util.Vector;

public class BinarySearchTree<K extends Comparable<? super K>, V> implements Iterable<TreeItem<K, V>> {

	private TreeNode<K, V> root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public BinarySearchTree(TreeNode<K, V> root) {
		this.root = root;
	}

	public TreeNode<K, V> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<K, V> root) {
		this.root = root;
	}
 	
	public boolean isEmpty() {
		return (this.root == null);
	}
	
	public void makeEmpty() {
		this.root = null;
	}
	
	public TreeItem<K, V> getRootItem() throws TreeException {
		if (this.root == null) {
			throw new TreeException("TreeExcption: BinarySearchTree is empty, no TreeItem to return");
		} else {
			return this.root.getItem();
		}
	}
	
	public void insert(TreeItem<K, V> treeItem) {
		this.root = this.insertItem(this.root, null, treeItem);
	}
	
	public TreeItem<K, V> find(K key) {
		return this.findItem(this.root, key);
	}
	
	public void delete(K key) {
		this.root = this.deleteItem(this.root, key);
	}
	
	@Override
	public Iterator<TreeItem<K, V>> iterator() {
		return new TreeIterator<K, V>(new BinarySearchTree<K, V>(this.root));
	}
	
//	public void insert(TreeItem<K, V> treeItem) {
//		TreeNode<K, V> newNode = new TreeNode<K, V>(treeItem);
//		if (this.isEmpty()) {
//			this.root = newNode;
//		} else {
//			TreeNode<K, V> curNode = this.root;
//			while (curNode != null) {
//				if (this.compareKeys(curNode.getItem().getKey(), treeItem.getKey()) > 0) {
//					// treeItem.key < curNode.treeItem.key -----> go left
//					if (curNode.getLeftChild() == null) {
//						curNode.setLeftChild(newNode);
//						newNode.setParent(curNode);
//						return;
//					} else {
//						curNode = curNode.getLeftChild();
//					}
//				} else {
//					// treeItem.key >= curNode.treeItem.key -----> go right
//					if (curNode.getRightChild() == null) {
//						curNode.setRightChild(newNode);
//						newNode.setParent(curNode);
//						return;
//					} else {
//						curNode = curNode.getRightChild();
//					}
//				}
//			}
//		}
//	}
//	
//	
//	public TreeItem<K, V> find(K key) {
//		if (this.root == null) {
//			return null;
//		} else {
//			TreeNode<K, V> curNode = this.root;
//			while (curNode != null) {
//				if (this.compareKeys(curNode.getItem().getKey(), key) == 0) {
//					// key == curNode.treeItem.key -----> found it!
//					return curNode.getItem();
//				} else if (this.compareKeys(curNode.getItem().getKey(), key) > 0) {
//					// key < curNode.treeItem.key -----> go left
//					curNode = curNode.getLeftChild();
//				} else {
//					// key >= curNode.treeItem.key -----> go right
//					curNode = curNode.getRightChild();
//				}
//			}
//		}
//		
//		return null;
//	}
//	
//	
//	public void delete(K key) {
//		TreeNode<K, V> nodeToDelete = this.findNode(key);
//		this.deleteNode(nodeToDelete);
//	}

	/******************************************************************/
	/*              Private Methods									  */
	/******************************************************************/
	
	private TreeNode<K, V> insertItem(TreeNode<K, V> node,
									  TreeNode<K, V> parent,
									  TreeItem<K, V> treeItem) {
		if (node == null) {
			node = new TreeNode<K, V>(treeItem);
			node.setParent(parent);
		} else if (this.compareKeys(node.getItem().getKey(), treeItem.getKey()) > 0) {
			node.setLeftChild(insertItem(node.getLeftChild(), node, treeItem));
		} else {
			node.setRightChild(insertItem(node.getRightChild(), node, treeItem));
		}
		
		return node;
	}
	
	
	private TreeItem<K, V> findItem(TreeNode<K, V> node, K key) {
		if (node == null) {
			return null;
		} else if (this.compareKeys(node.getItem().getKey(), key) == 0) {
			return node.getItem();
		} else if (this.compareKeys(node.getItem().getKey(), key) > 0) {
			return findItem(node.getLeftChild(), key);
		} else {
			return findItem(node.getRightChild(), key);
		}
	}
	
	
	private TreeNode<K, V> deleteItem(TreeNode<K, V> node, K key) throws TreeException {
		
		if (node == null) {
			throw new TreeException("TreeException: Item to delete was not found in the tree");
		} else {
			TreeItem<K, V> item = node.getItem();
			if (this.compareKeys(item.getKey(), key) == 0) {
				node = this.deleteNode(node);
			} else if (this.compareKeys(item.getKey(), key) > 0) {
				node.setLeftChild(deleteItem(node.getLeftChild(), key));
				if (node.getLeftChild() != null) {
					node.getLeftChild().setParent(node);
				}
			} else {
				node.setRightChild(deleteItem(node.getRightChild(), key));
				if (node.getRightChild() != null) {
					node.getRightChild().setParent(node);
				}
			}
		}
		
		return node;
	}
	
	
	private TreeNode<K, V> deleteNode(TreeNode<K, V> node) {
		if (this.isLeafNode(node)) {
			// no children
			return null;
		} else if (this.hasNoLeftChild(node)) {
			// one child, a right child
			return node.getRightChild();
		} else if (this.hasNoRightChild(node)) {
			// one child, a left child
			return node.getLeftChild();
		} else {
			// two children
			TreeNode<K, V> successor = this.findSuccessor(node.getRightChild());
			node.setItem(successor.getItem());
			node.setRightChild(this.deleteSuccessorNode(node.getRightChild()));
			return node;
 		}
	}
	

	private TreeNode<K, V> deleteSuccessorNode(TreeNode<K, V> node) {
		if (node.getLeftChild() == null) {
			return node.getRightChild();
		} else {
			node.setLeftChild(this.deleteSuccessorNode(node.getLeftChild()));
			return node;
		}
	}
	 
	
	
	private int compareKeys(K k1, K k2) {
		// k1 > k2	returns positive number
		// k1 == k2	returns zero
		// k1 < k2	returns negative numbers
		return k1.compareTo(k2);
	}

	
	private TreeNode<K, V> findSuccessor(TreeNode<K, V> node) {
		if (node.getLeftChild() == null) {
			return node;
		} else {
			return findSuccessor(node.getLeftChild());
		}
	}
	
	private boolean isLeafNode(TreeNode<K, V> node) {
		return ((node.getLeftChild() == null) && (node.getRightChild() == null));
	}

	
	private boolean hasNoLeftChild(TreeNode<K, V> node) {
		return (node.getLeftChild() == null);
	}
	
	
	private boolean hasNoRightChild(TreeNode<K, V> node) {
		return (node.getRightChild() == null);
	}
	
	
//	private void deleteNode(TreeNode<K, V> nodeToDelete) {
//		if (nodeToDelete != null) {
//			if (this.isLeafNode(nodeToDelete)) {
//				System.out.println("Removing a leaf Node");
//				// removing a leaf node
//				TreeNode<K, V> parentNode = nodeToDelete.getParent();
//				if (this.hasNoParent(nodeToDelete)) {
//					System.out.println("Removing the root node");
//					// removing the root of a one-node tree
//					this.root = null;
//					return;
//				} else if ((parentNode.getLeftChild() != null) && (parentNode.getLeftChild().equals(nodeToDelete))) {
//					// removing the left child leaf node
//					System.out.println("Removing left child of parent node");
//					parentNode.setLeftChild(null);
//					return;
//				} else {
//					// removing the right child leaf node
//					System.out.println("Removing right child of parent node");
//					parentNode.setRightChild(null);
//					return;
//				}
//			} else if (this.hasLeftChild(nodeToDelete) && this.hasNoRightChild(nodeToDelete)) {
//				// removing a node with only one child
//				// promote left child
//				System.out.println("Removing node with one child, a left child");
//				TreeNode<K, V> parentNode = nodeToDelete.getParent();
//				nodeToDelete.getLeftChild().setParent(parentNode);
//				if (this.hasNoParent(nodeToDelete)) {
//					this.root = nodeToDelete.getLeftChild();
//					this.root.setParent(null);
//				} else if ((parentNode.getLeftChild() != null) && (parentNode.getLeftChild().equals(nodeToDelete))) {
//					parentNode.setLeftChild(nodeToDelete.getLeftChild());
//					
//				} else {
//					parentNode.setRightChild(nodeToDelete.getLeftChild());
//					
//				}
//			} else  if (this.hasNoLeftChild(nodeToDelete) && this.hasRightChild(nodeToDelete)) {
//				// removing a node with only one child
//				// promote right child
//				System.out.println("Removing node with one child, a right child");
//				TreeNode<K, V> parentNode = nodeToDelete.getParent();
//				nodeToDelete.getRightChild().setParent(parentNode);
//				if (this.hasNoParent(nodeToDelete)) {
//					this.root = nodeToDelete.getRightChild();
//					this.root.setParent(null);
//				} else if ((parentNode.getLeftChild() != null) && (parentNode.getLeftChild().equals(nodeToDelete))) {
//					parentNode.setLeftChild(nodeToDelete.getRightChild());
//				} else {
//					parentNode.setRightChild(nodeToDelete.getRightChild());
//				}
//			} else {
//				// removing a node with two children
//				System.out.println("Removing a node with 2 children");
//				TreeNode<K, V> successor = this.findSuccessor(nodeToDelete);
//				nodeToDelete.setItem(successor.getItem());
//				this.deleteNode(successor);
//			}
//		}
//	}
//	
//	
//	private TreeNode<K, V> findNode(K key) {
//		TreeNode<K, V> curNode = this.root;
//		
//		while (curNode != null) {
//			K curKey = curNode.getItem().getKey();
//			if (this.compareKeys(curKey, key) == 0) {
//				return curNode;
//			} else if (this.compareKeys(curKey, key) > 0) {
//				curNode = curNode.getLeftChild();
//			} else {
//				curNode = curNode.getRightChild();
//			}
//		}
//		
//		return null;
//	}
	
	
//	private TreeNode<K, V> findSuccessor(TreeNode<K, V> node) {
//		TreeNode<K, V> curNode = node.getRightChild();
//		while (curNode.getLeftChild() != null) {
//			curNode = curNode.getLeftChild();
//		}
//		return curNode;
//	}
	
	public int height() {
		/**
		 * This method is used to obtain the height of the BinarySearchTree.
		 * 
		 * @return the height of the BinarySearchTree.
		 */
		
		if (isEmpty()) {
			return -1;
		}
		
		return treeHeight(this.root);
		
	}
	
	private int treeHeight(TreeNode<K,V> node) {
		/**
		 * The private recursive method to calculate the height of a subtree rooted at the specified TreeNode. 
		 * This method is initially called by the height method and treeIsBalanced
		 * 
		 * @param node - The root node of the BinarySearchTree for which we are measuring the height.
		 * 
		 * @return the height of the BinarySearchTree.
		 */
		
		if (node == null) {
			return 0;
		}
		
		int heightToTheLeft = treeHeight(node.getLeftChild());
		int heightToTheRight = treeHeight(node.getRightChild());
		
		if (heightToTheLeft > heightToTheRight) {
			return heightToTheLeft + 1;
		} else {
			return heightToTheRight + 1;
		}
	}
	
	public boolean isBalanced() {
		/**
		 * This is the method the user calls to find out if the BinarySearchTree is balanced.
		 * 
		 * @return true if the BinarySearchTree is balanced, false otherwise.
		 */
		
		if (isEmpty()) {
			return true;
		}
		return treeIsBalanced(this.root);
	}
	
	private boolean treeIsBalanced(TreeNode<K,V> node) {
		/**
		 * The private recursive method to determine if the tree rooted at the given node is balanced. 
		 * This method is initially called by the isBalanced method
		 * 
		 * @param node - The root node of the BinarySearchTree that is being checked for balance.
		 * 
		 * @return true if the BinarySearchTree is balanced, false otherwise.
		 */
		
		if (node == null) {
			return true;
		}
		
		int heightToTheLeft = treeHeight(node.getLeftChild());
		int heightToTheRight = treeHeight(node.getRightChild());
		int leftAndRightDifference = Math.abs(heightToTheLeft - heightToTheRight);
		
		if ((leftAndRightDifference <= 1) && treeIsBalanced(node.getLeftChild()) && treeIsBalanced(node.getRightChild())) {
			return true;
		}
		return false;	
	}
	
	public void balance() {
		/**
		 * This method is used to balance the BinarySearchTree.
		 */
		
		if (!isBalanced()) {
			TreeIterator<K, V> iterator = new TreeIterator<K, V>(this);
			iterator.setInorder();
			Vector<TreeNode<K, V>> treeNodes = iterator.treeNodes;
			Object[] arr = treeNodes.toArray();
			
			makeEmpty();
			int first = 0;
			int last = arr.length - 1;
			
	        balanceTree(arr, first, last);
		}
	}
	
	@SuppressWarnings("unchecked")
	private TreeNode<K,V> balanceTree(java.lang.Object[] arr, int first, int last) {
		/**
		 * The private recursive method to balance the BinarySearchTree. This method is initially called by the balance method
		 * 
		 * @param arr - An array containing all the TreeItems for the BinarySearchTree in sorted order.
		 *        first - The first index of the array.
		 *        last - The last index of the array.
		 * 
		 * @return The root node for this level of the balanced tree.
		 */
		
		if (this.root == null) {
			int middle = (first + last) / 2;
			this.root = (TreeNode<K, V>) arr[middle];
		}
		
		if (first > last) {
			return null;
		}
		
		int middle = (first + last) / 2;
		TreeNode<K, V> middleNode = (TreeNode<K, V>) arr[middle];
		
		middleNode.setLeftChild(balanceTree(arr, first, middle - 1));
		middleNode.setRightChild(balanceTree(arr, middle + 1, last));
		
		return middleNode;
	}
}