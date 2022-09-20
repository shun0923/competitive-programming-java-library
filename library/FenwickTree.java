package library;

import library.SimpleUtil;

class FenwickTree {
	int n;
	long nodes[];

	FenwickTree(int n) { SimpleUtil.nonNegativeCheck(n); init(n); } // O(N)
	FenwickTree(long[] a) { init(a.length); for(int i = 0; i < n; i ++) add(i, a[i]); }// O(NlogN)
	void init(int n) {
		SimpleUtil.nonNegativeCheck(n);
		this.n = n;
		nodes = new long[n];
	}

	void add(int a, long x) { // O(logN)
		SimpleUtil.rangeCheck(a, n);
		a ++;
		while(a <= n) {
			nodes[a - 1] += x;
			a += a & - a;
		}
	}
	long sum(int r) { // return sum of [0, r) // O(logN)
		SimpleUtil.inclusiveRangeCheck(r, n);
		long sum = 0;
		while(r > 0) {
			sum += nodes[r - 1];
			r -= r & - r;
		}
		return sum;
	}
	long sum(int l, int r) { // return sum of [l, r) // O(logN)
		SimpleUtil.inclusiveRangeCheck(l, n);
		SimpleUtil.inclusiveRangeCheck(r, n);
		if(l > r) return 0;
		else return sum(r) - sum(l);
	}
}