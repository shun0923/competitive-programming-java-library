package library;

import java.util.*;
import java.util.function.*;
import library.SimpleUtil;

class DualSegmentTree {
	long e2;
	LongBinaryOperator g;

	int n;
	int height;
	long lazy[];
	int rangeL[];
	int rangeR[];

	// O(N)
	DualSegmentTree(long[] a, long e2, LongBinaryOperator g) {
		this(a.length, e2, g);
		System.arraycopy(a, 0, lazy, n, a.length);
	}
	DualSegmentTree(int len, long x, long e2, LongBinaryOperator g) {
		this(len, e2, g);
		SimpleUtil.nonNegativeCheck(len);
		Arrays.fill(lazy, n, n + len, x);
	}
	DualSegmentTree(int len, long e2, LongBinaryOperator g) {
		SimpleUtil.nonNegativeCheck(len);
		this.e2 = e2;
		this.g = g;
		n = 1;
		height = 0;
		while(n < len) { n <<= 1; height ++; }
		lazy = new long[n << 1];
		Arrays.fill(lazy, e2);
		rangeL = new int[n << 1];
		rangeR = new int[n << 1];
		for(int i = 0; i < n; i ++) { rangeL[i + n] = i; rangeR[i + n] = i + 1; }
		for(int i = n - 1; i > 0; i --) { rangeL[i] = rangeL[i << 1]; rangeR[i] = rangeR[(i << 1) + 1]; }
	}

	void eval(int k) { // O(1)
		if(lazy[k] != e2) {
			if(k < n) {
				lazy[k << 1] = g.applyAsLong(lazy[k << 1], lazy[k]);
				lazy[(k << 1) + 1] = g.applyAsLong(lazy[(k << 1) + 1], lazy[k]);
				lazy[k] = e2;
			}
		}
	}

	void update(int l, int r, long val) { // O(logN)
		SimpleUtil.inclusiveRangeCheck(l, n);
		SimpleUtil.inclusiveRangeCheck(r, n);
		SimpleUtil.assertion(l <= r, "l is larger than r.");
		l += n; r += n - 1;
		for(int i = height; i > 0; i --) { eval(l >> i); eval(r >> i); }
		r ++;
		while(l < r) {
			if((l & 1) != 0) { lazy[l] = g.applyAsLong(lazy[l], val); eval(l); l ++; }
			if((r & 1) != 0) { r --; lazy[r] = g.applyAsLong(lazy[r], val); eval(r); }
			l >>= 1; r >>= 1;
		}
	}

	long get(int j) { // O(logN)
		SimpleUtil.inclusiveRangeCheck(j, n);
		j += n;
		for(int i = height; i > 0; i --) eval(j >> i);
		return lazy[j];
	}
}