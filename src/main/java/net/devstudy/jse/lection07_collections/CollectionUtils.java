package net.devstudy.jse.lection07_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@SuppressWarnings("unchecked") 
public class CollectionUtils {

	public static <T> List<T> union(Collection<T>... collections) {
		Set<T> union = new LinkedHashSet<>();
		for (Collection<T> collection : collections) {
			union.addAll(collection);
		}
		return new ArrayList<>(union);
	}

	public static <T> List<T> intersection(Collection<T>... collections) {
		if (collections.length > 0) {
			Set<T> union = new LinkedHashSet<>(collections[0]);
			for (int i = 1; i < collections.length; i++) {
				union.retainAll(collections[i]);
			}
			return new ArrayList<>(union);
		} else {
			return Collections.emptyList();
		}
	}

	public static void main(String[] args) {
		System.out.println(union(Arrays.asList(new Integer[] { 1, 1, 2, 3, 4 })));
		System.out.println(union(Arrays.asList(new Integer[] { 1, 1, 2, 3, 4 }), new TreeSet<Integer>(Arrays.asList(new Integer[] { 1, 1, 2, 3, 4, 5, 6 }))));
		System.out.println(intersection(Arrays.asList(new Integer[] { 1, 1, 2, 3, 4 })));
		System.out.println(intersection(Arrays.asList(new Integer[] { 1, 1, 2 }), new TreeSet<Integer>(Arrays.asList(new Integer[] { 2, 3, 4, 5, 6 }))));
		System.out.println(intersection(Arrays.asList(new Integer[] { 1, 1, 2 }), new TreeSet<Integer>(Arrays.asList(new Integer[] { 2, 3, 4, 5, 6 })), new LinkedList<>(Arrays.asList(new Integer[] { 4, 6 }))));
	}
}
