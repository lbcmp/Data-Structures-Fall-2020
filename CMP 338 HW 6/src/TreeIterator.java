import java.util.Iterator;
import java.util.Vector;

public class TreeIterator<K extends Comparable<? super K>, V> implements Iterator<TreeItem<K, V>> {

	BinarySearchTree<K, V> bst;
	Vector<TreeNode<K, V>> treeNodes;
	
	
	public TreeIterator(BinarySearchTree<K, V> bst) {
		this.bst = bst;
	}
	
	
	@Override
	public boolean hasNext() {
		if (this.treeNodes == null) {
			return false;
		} else {
			return !this.treeNodes.isEmpty();
		}
	}

	@Override
	public TreeItem<K, V> next() {
		TreeItem<K, V> item = this.treeNodes.elementAt(0).getItem();
		this.treeNodes.remove(0);
		if (treeNodes.isEmpty()) {
			this.treeNodes = null;
		}
		return item;
	}
	
	public void setPreorder() {
		this.treeNodes = new Vector<TreeNode<K, V>>();
		this.preorder(this.bst.getRoot());
	}
	
	public void setInorder() {
		this.treeNodes = new Vector<TreeNode<K, V>>();
		this.inorder(this.bst.getRoot());
	}
	
	public void setPostorder() {
		this.treeNodes = new Vector<TreeNode<K, V>>();
		this.postorder(this.bst.getRoot());
	}
	
	public int size() {
		if (bst.isEmpty()) {
			return 0;
		}
		return getSize(bst.getRoot());
	}

	/******************************************************************/
	/*              Private Methods									  */
	/******************************************************************/

	private void preorder(TreeNode<K, V> node) {
		if (node != null) {
			this.treeNodes.add(node);
			preorder(node.getLeftChild());
			preorder(node.getRightChild());
		}
	}

	private void inorder(TreeNode<K, V> node) {
		if (node != null) {
			inorder(node.getLeftChild());
			this.treeNodes.add(node);
			inorder(node.getRightChild());
		}
	}

	private void postorder(TreeNode<K, V> node) {
		if (node != null) {
			postorder(node.getLeftChild());
			postorder(node.getRightChild());
			this.treeNodes.add(node);
		}
	}
	
	private int getSize(TreeNode<K, V> node) {
		if (node == null) {
			return 0;
		} else {
			return (getSize(node.getLeftChild()) + getSize(node.getRightChild()) + 1);
		}
	}
	
	/*public static void main(String[] args) {
		BinarySearchTree<Integer,String> bst = new BinarySearchTree<Integer,String>();
		bst.insert(new TreeItem<Integer, String>(1, "a"));
		bst.insert(new TreeItem<Integer, String>(2, "b"));
		bst.insert(new TreeItem<Integer, String>(3, "c"));
		
		Iterator<TreeItem<Integer, String>> iterator = bst.iterator();
		
		TreeIterator<Integer, String> treeIterator = new TreeIterator<Integer, String>(bst);
		int size = treeIterator.size();
		System.out.println(size);
		
		
	}*/
}