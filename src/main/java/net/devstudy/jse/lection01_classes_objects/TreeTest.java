package net.devstudy.jse.lection01_classes_objects;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class TreeTest {

	public static void main(String[] args) {
		Tree tree = new Tree(0);
		for(int i=0;i<3;i++) {
			tree.add(0, i+1);
			for(int j=0;j<3;j++) {
				tree.add(i+1, 10 * (i+1) + j+1);
			}
		}
		tree.print();
		System.out.println("------------");
		tree.getSubTree(2).print();
		
		tree.add(100, 100);//Test not found
	}

}
