package library;

import java.util.*;

class Sort {
	// N=array.length N>=10^5
	public static final <T extends Comparable<? super T>> void quickSort(final T[] array) { quickSort(array, 0, array.length, Comparator.naturalOrder()); } // O(NlogN)
	public static final <T extends Comparable<? super T>> void quickSort(final T[] array, final Comparator<? super T> c) { quickSort(array, 0, array.length, c); } // O(NlogN)
	public static final <T extends Comparable<? super T>> void quickSort(final T[] array, final int from, final int to, final Comparator<? super T> c) { // O(NlogN)
		if(from >= to) return;
		int range = to - from;
		T pivot = median3(array[from], array[(from + to) / 2], array[to - 1], c);
		int curFrom = from;
		int curTo = to - 1;
		do {
			while(c.compare(array[curFrom], pivot) < 0) curFrom ++;
			while(c.compare(pivot, array[curTo]) < 0) curTo --;
			if(curFrom <= curTo) {
				T tmp = array[curFrom];
				array[curFrom] = array[curTo];
				array[curTo] = tmp;
				curFrom ++;
				curTo --;
			}
		}while(curFrom <= curTo);
	
		if(from < curTo + 1) quickSort(array, from, curTo + 1, c);
		if(curFrom < to - 1) quickSort(array, curFrom, to, c);
	}
	private static final <T extends Comparable<? super T>> T median3(final T x, final T y, final T z, final Comparator<? super T> c) {
		return c.compare(x, y) < 0 ? c.compare(y, z) < 0 ? y : c.compare(z, x) < 0 ? x : z
			: c.compare(z, y) < 0 ? y : c.compare(x, z) < 0 ? x : z;
	}

	public static final <T extends Comparable<T>> void mergeSort(final T[] a){ mergeSort(a, 0, a.length); } // O(NlogN) N=a.length
	public static final <T extends Comparable<T>> void mergeSort(final T[] a, final int l, final int r){ // O(NlogN)
		if(r - l > 1) {
			int m = (l + r) / 2;
			mergeSort(a, l, m);
			mergeSort(a, m, r);
			merge(a, l, m, r);
		}
	}
	private static final <T extends Comparable<T>> void merge(final T[] a, final int l, final int m, final int r){
		int i = l;
		int j = m;
		Deque<T> s = new ArrayDeque<>();
		while(i < m || j < r){
			if(j >= r) {
				s.addLast(a[i]);
				i ++;
			}else if(i >= m) {
				s.addLast(a[j]);
				j ++;
			}else if(a[i].compareTo(a[j]) < 0) {
				s.addLast(a[i]);
				i ++;
			}else {
				s.addLast(a[j]);
				j ++;
			}
		}
		for(int k = l; k < r; k ++) a[k] = s.removeFirst();
	}
}