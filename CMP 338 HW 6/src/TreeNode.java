public class TreeNode<K extends Comparable<? super K>, V> {

	private TreeItem<K, V> item;
	private TreeNode<K, V> leftChild;
	private TreeNode<K, V> rightChild;
	private TreeNode<K, V> parent;
	
	public TreeNode(TreeItem<K, V> item) {
		this.item = item;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
	}

	public TreeItem<K, V> getItem() {
		return item;
	}

	public void setItem(TreeItem<K, V> item) {
		this.item = item;
	}

	public TreeNode<K, V> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<K, V> leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode<K, V> getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode<K, V> rightChild) {
		this.rightChild = rightChild;
	}

	public TreeNode<K, V> getParent() {
		return parent;
	}

	public void setParent(TreeNode<K, V> parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		String s = new String("TreeNode: ");
		s += "key = " + this.item.getKey() + "\n\t\t";
		
		if (this.parent == null) {
			s += "parent = null" + "\n\t\t";
		} else {
			s += "parent = " + this.parent.getItem().getKey()  + "\n\t\t";
		}
		
		if (this.leftChild == null) {
			s += "leftChild = null" + "\n\t\t";
		} else {
			s += "leftChild = " + this.leftChild.getItem().getKey()  + "\n\t\t";
		}
		
		if (this.rightChild == null) {
			s += "rightChild = null";
		} else {
			s += "rightChild = " + this.rightChild.getItem().getKey();
		}
		return s;
	}
	
}
