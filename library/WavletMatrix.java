package library;

import java.util.*;
import library.SimpleUtil;
import library.BitVector;

class WaveletMatrix {
	final int bitSize;
	final int n;
	BitVector mat[];
	int mid[];
	final int max;

	// O(NlogA)
	WaveletMatrix(int[] a) {
		n = a.length;
		long tmp = 1;
		for(int i = 0; i < n; i ++) tmp = Math.max(tmp, a[i]);
		bitSize = n == 0 ? 1 : Long.numberOfTrailingZeros(Long.highestOneBit(tmp)) + 1;
		max = 1 << bitSize;
		mat = new BitVector[bitSize];
		mid = new int[bitSize];
		for(int i = bitSize - 1; i >= 0; i --) {
			mat[i] = new BitVector(n);
			int a2[] = new int[n];
			int idx = 0;
			for(int j = 0; j < n; j ++) if((a[j] >> i & 1) == 0) a2[idx ++] = a[j];
			mid[i] = idx;
			for(int j = 0; j < n; j ++) if((a[j] >> i & 1) != 0) { a2[idx ++] = a[j]; mat[i].set(j); }
			a = a2;
			mat[i].init();
		}
	}

	// Query: O(logVloglogN)

	// a_i
	final int get(int k) {
		SimpleUtil.rangeCheck(k, n);
		int val = 0;
		for(int i = bitSize - 1; i >= 0; i --) {
			boolean b = mat[i].get(k);
			k = mat[i].rank(b, k);
			if(b) { val |= 1 << i; k += mid[i]; }
		}
		return val;
	}

	// count x in [0, k)
	final int rank(int x, int k) { return rank(x, 0, k); }
	// count x in [l, r)
	final int rank(int x, int l, int r) {
		SimpleUtil.inclusiveRangeCheck(l, n);
		SimpleUtil.inclusiveRangeCheck(r, n);
		SimpleUtil.assertion(l <= r);
		if(x < 0 || x >= max) return 0;
		for(int i = bitSize - 1; i >= 0; i --) {
			boolean b = (x >> i & 1) != 0;
			l = mat[i].rank(b, l); if(b) l += mid[i];
			r = mat[i].rank(b, r); if(b) r += mid[i];
		}
		return r - l;
	}

	// position of k-th occurrence of x
	final int select(int x, int k) {
		SimpleUtil.nonNegativeCheck(k);
		if(x < 0 || x >= max) return n;
		int l[] = new int[bitSize + 1];
		int l2[] = new int[bitSize + 1];
		int r = n;
		l[bitSize] = 0;
		for(int i = bitSize - 1; i >= 0; i --) {
			boolean b = (x >> i & 1) != 0;
			l2[i] = mat[i].rank(b, l[i + 1]);
			l[i] = l2[i];
			if(b) l[i] += mid[i];
			r = mat[i].rank(b, r);
			if(b) r += mid[i];
		}
		if(r - l[0] <= k) return n;
		for(int i = 0; i < bitSize; i ++) k = mat[i].select((x >> i & 1) != 0, k + l2[i]) - l[i + 1];
		return k;
	}

	// k-th smallest in [l, r)
	final int smallest(int l, int r, int k) {
		SimpleUtil.nonNegativeCheck(k);
		SimpleUtil.rangeCheck(l, n);
		SimpleUtil.inclusiveRangeCheck(r, n);
		SimpleUtil.assertion(k < r - l);
		int val = 0;
		for(int i = bitSize - 1; i >= 0; i --) {
			int l2 = mat[i].rank(false, l);
			int r2 = mat[i].rank(false, r);
			if(k < r2 - l2) {
				l = l2;
				r = r2;
			}else {
				l += mid[i] - l2;
				r += mid[i] - r2;
				val |= 1 << i;
				k -= r2 - l2;
			}
		}
		return val;
	}
	// k-th largest in [l, r)
	final int largest(int l, int r, int k) { return smallest(l, r, r - l - k - 1); }

	// count [0, x) in [l, r)
	final int less_freq(int x, int l, int r) {
		SimpleUtil.inclusiveRangeCheck(l, n);
		SimpleUtil.inclusiveRangeCheck(r, n);
		SimpleUtil.assertion(l <= r);
		if(x < 0) return 0;
		if(x >= max) return r - l;
		int cnt = 0;
		for(int i = bitSize - 1; i >= 0; i --) {
			boolean b = (x >> i & 1) != 0;
			int l2 = mat[i].rank(b, l);
			int r2 = mat[i].rank(b, r);
			if(b) cnt += r + l2 - r2 - l;
			l = l2; if(b) l += mid[i];
			r = r2; if(b) r += mid[i];
		}
		return cnt;
	}
	// count [x, ) in [l, r)
	final int greater_freq(int x, int l, int r) { return r - l - less_freq(x, l, r); }
	// count [lower, upper) in [l, r)
	final int range_freq(int lower, int upper, int l, int r) { return less_freq(upper, l, r) - less_freq(lower, l, r); }
}