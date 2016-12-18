package net.devstudy.jse.lection01_classes_objects;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class LinkedList {
	private Item first;
	private int size;

	public void add(int element) {
		if (size == 0) {
			first = new Item(element);
		} else {
			Item item = new Item(element);
			Item last = findItem(size - 1);
			last.setNext(item);
		}
		size++;
	}

	private Item findItem(int index) {
		int i = 0;
		Item current = first;
		while (i < size) {
			if (i == index) {
				return current;
			} else {
				i++;
				current = current.getNext();
			}
		}
		return null;
	}

	public int get(int index) {
		Item current = findItem(index);
		return current != null ? current.getValue() : 0;
	}

	public int remove(int index) {
		if (index == 0) {
			Item current = first;
			first = first.getNext();
			decrementSize();
			return current.getValue();
		} else {
			Item prevToRemove = findItem(index - 1);
			Item current = prevToRemove.getNext();
			prevToRemove.setNext(current.getNext());
			decrementSize();
			return current.getValue();
		}
	}

	private void decrementSize() {
		size--;
		if (size == 0) {
			first = null;
		}
	}

	public int size() {
		return size;
	}

	public void clear() {
		size = 0;
		first = null;
	}

	public int[] toArray() {
		int[] array = new int[size];
		int i = 0;
		Item current = first;
		while (i < size) {
			array[i++] = current.getValue();
			current = current.getNext();
		}
		return array;
	}
}
