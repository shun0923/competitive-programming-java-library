package library;

import java.util.function.*;
import library.FastIO;

class SparseTable {
	LongBinaryOperator f;

	int n;
	int m;
	long table[][];

	SparseTable(long[] a, LongBinaryOperator f) { // O(NlogN)
		this.f = f;
		n = a.length;
		m = 1;
		while(1 << m < n) m ++;
		table = new long[m][n];
		for(int i = 0; i < n; i ++) table[0][i] = a[i];
		for(int i = 1; 1 << i < n; i ++) {
			for(int j = 1 << i; j < n + (1 << i); j += 1 << i + 1) {
				for(int k = 0; k < 1 << i && j + k < n; k ++) {
					table[i][j + k] = k == 0 ? a[j + k] : f.applyAsLong(table[i][j + k - 1], a[j + k]);
				}
				int k0 = Math.max(1, j - n + 1);
				for(int k = k0; k <= 1 << i; k ++) {
					table[i][j - k] = k == k0 ? a[j - k] : f.applyAsLong(a[j - k], table[i][j - k + 1]);
				}
			}
		}
	}

	long get(int i) { FastIO.rangeCheck(i, n); return table[0][i]; } // O(1)

	long find(int l, int r) { // O(1)
		r --;
		FastIO.rangeCheck(l, n);
		FastIO.rangeCheck(r, n);
		FastIO.assertion(l <= r, "l is larger than r.");
		int log = Long.numberOfTrailingZeros(Integer.highestOneBit(l ^ r));
		return l == r ? get(l) : f.applyAsLong(table[log][l], table[log][r]);
	}
}