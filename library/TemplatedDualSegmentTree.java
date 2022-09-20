package library;

import java.util.function.*;
import library.SimpleUtil;

class TemplatedDualSegmentTree<T> {
	@FunctionalInterface
	interface BinaryConsumer<T> extends BiConsumer<T, T> {  }

	Supplier<T> e2Supplier;
	T e2;
	BinaryConsumer<T> g;

	int n;
	int height;
	T lazy[];
	int rangeL[];
	int rangeR[];

	// O(N)
	TemplatedDualSegmentTree(T[] a, Supplier<T> e2Supplier, BinaryConsumer<T> g) {
		this(a.length, e2Supplier, g);
		System.arraycopy(a, 0, lazy, n, a.length);
	}
	TemplatedDualSegmentTree(int len, Supplier<T> xSupplier, Supplier<T> e2Supplier, BinaryConsumer<T> g) {
		this(len, e2Supplier, g);
		for(int i = 0; i < len; i ++) lazy[i + n] = xSupplier.get();
	}
	@SuppressWarnings("unchecked")
	TemplatedDualSegmentTree(int len, Supplier<T> e2Supplier, BinaryConsumer<T> g) {
		SimpleUtil.nonNegativeCheck(len);
		this.e2Supplier = e2Supplier;
		this.e2 = e2Supplier.get();
		this.g = g;
		n = 1;
		height = 0;
		while(n < len) { n <<= 1; height ++; }
		lazy = (T[]) new Object[n << 1];
		for(int i = 0; i < lazy.length; i ++) lazy[i] = e2Supplier.get();
		rangeL = new int[n << 1];
		rangeR = new int[n << 1];
		for(int i = 0; i < n; i ++) { rangeL[i + n] = i; rangeR[i + n] = i + 1; }
		for(int i = n - 1; i > 0; i --) { rangeL[i] = rangeL[i << 1]; rangeR[i] = rangeR[(i << 1) + 1]; }
	}

	void eval(int k) { // O(1)
		if(!lazy[k].equals(e2)) {
			if(k < n) {
				g.accept(lazy[k << 1], lazy[k]);
				g.accept(lazy[(k << 1) + 1], lazy[k]);
				lazy[k] = e2Supplier.get();
			}
		}
	}

	void update(int l, int r, T val) { // O(logN)
		SimpleUtil.inclusiveRangeCheck(l, n);
		SimpleUtil.inclusiveRangeCheck(r, n);
		SimpleUtil.assertion(l <= r, "l is larger than r.");
		l += n; r += n - 1;
		for(int i = height; i > 0; i --) { eval(l >> i); eval(r >> i); }
		r ++;
		while(l < r) {
			if((l & 1) != 0) { g.accept(lazy[l], val); eval(l); l ++; }
			if((r & 1) != 0) { r --; g.accept(lazy[r], val); eval(r); }
			l >>= 1; r >>= 1;
		}
	}

	T get(int j) { // O(logN)
		SimpleUtil.inclusiveRangeCheck(j, n);
		j += n;
		for(int i = height; i > 0; i --) eval(j >> i);
		return lazy[j];
	}
}