package net.devstudy.jse.lection01_classes_objects;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class Leaf {
	private int value;
	private Leaf[] leaves;
	public Leaf(int value) {
		super();
		this.value = value;
		this.leaves = new Leaf[0];
	}
	public void addLeaf(Leaf leaf) {
		Leaf[] array = new Leaf[leaves.length + 1];
		for(int i=0;i<leaves.length;i++){
			array[i] = leaves[i];
		}
		array[leaves.length] = leaf;
		leaves = array;
	}
	public Leaf[] getLeaves() {
		return leaves;
	}
	public int getLeavesCount(){
		return leaves.length;
	}
	public int getValue() {
		return value;
	}
}
