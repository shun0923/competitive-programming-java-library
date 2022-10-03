package library;

import java.util.*;
import library.SimpleUtil;

class Permutation implements Iterator<int[]>, Iterable<int[]> { // N=next.length
	private int next[];

	// O(N)
	public Permutation(int n) {
		SimpleUtil.nonNegativeCheck(n);
		next = new int[n];
		for(int i = 0; i < n; i ++) next[i] = i;
	}
	public Permutation(int[] a) {
		next = a.clone();
	}

	@Override
	public final boolean hasNext() { return next != null; } // O(1)

	@Override
	public final int[] next() { // O(1)
		int[] r = next.clone();
		next = nextPermutation(next);
		return r;
	}

	@Override
	public final Iterator<int[]> iterator() { return this; } // O(1)

	public final int[] nextPermutation(int[] a) { // O(N)
		if(a == null || a.length < 2) return null;
		int p = 0;
		for(int i = a.length - 2; i >= 0; i --) {
			if(a[i] >= a[i + 1]) continue;
			p = i;
			break;
		}
		int q = 0;
		for(int i = a.length - 1; i > p; i --) {
			if(a[i] <= a[p]) continue;
			q = i;
			break;
		}
		if(p == 0 && q == 0) return null;
		swap(a, p, q);
		int l = p;
		int r = a.length;
		while(++ l < -- r) swap(a, l, r);
		return a;
	}

	private static final void swap(int[] a, int l, int r) {
		int tmp = a[l];
		a[l] = a[r];
		a[r] = tmp;
	}
}