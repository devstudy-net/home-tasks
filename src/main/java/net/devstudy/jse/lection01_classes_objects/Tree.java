package net.devstudy.jse.lection01_classes_objects;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class Tree {

	private Leaf root;
	
	public Tree(int value){
		this(new Leaf(value));
	}
	
	private Tree(Leaf root) {
		super();
		this.root = root;
	}
	
	public void add(int parentValue, int value) {
		Leaf parent = findLeaf(parentValue);
		if(parent != null) {
			parent.addLeaf(new Leaf(value));
		} else {
			System.out.println("Parent with value="+parentValue+" not found in tree");
		}
	}
	
	public Tree getSubTree(int value) {
		Leaf subRoot = findLeaf(value);
		return subRoot != null ? new Tree(subRoot) : null;
	}
	
	public void print(){
		if(root != null) {
			print(root, 0);
		}
	}
	
	private void print(Leaf leaf, int offset) {
		for(int i=0;i<offset-1;i++ ) {
			System.out.print("| ");
		}
		if(offset > 0) {
			System.out.print("|-");
		}
		System.out.println(leaf.getValue());
		for(int i=0;i<leaf.getLeavesCount();i++) {
			print(leaf.getLeaves()[i], offset+1);
		}
	}
	
	private Leaf findLeaf(int value) {
		if(root != null) {
			if(root.getValue() == value) {
				return root;
			} else {
				return findLeaf(root.getLeaves(), value);
			}
		}
		return null;
	}
	
	private Leaf findLeaf(Leaf[] leaves, int value) {
		if(leaves.length == 0) {
			return null;
		} else {
			for(int i=0;i<leaves.length;i++) {
				Leaf leaf = leaves[i];
				if(leaf.getValue() == value) {
					return leaf;
				} else {
					Leaf child = findLeaf(leaf.getLeaves(), value);
					if(child != null) {
						return child;
					}
				}
			}
			return null;
		}
	}
}
