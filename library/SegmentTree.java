package library;

import java.util.*;
import java.util.function.*;
import library.SimpleUtil;

class SegmentTree {
	private long e;
	private LongBinaryOperator f;

	private int n;
	private long nodes[];
	private int rangeL[];
	private int rangeR[];

	// O(N)
	public SegmentTree(long[] a, long e, LongBinaryOperator f) {
		this(a.length, e, f);
		System.arraycopy(a, 0, nodes, n, a.length);
		for(int i = n - 1; i > 0; i --) nodes[i] = f.applyAsLong(nodes[i << 1], nodes[(i << 1) + 1]);
	}
	public SegmentTree(int len, long x, long e, LongBinaryOperator f) {
		this(len, e, f);
		Arrays.fill(nodes, n, n + len, x);
		for(int i = n - 1; i > 0; i --) nodes[i] = f.applyAsLong(nodes[i << 1], nodes[(i << 1) + 1]);
	}
	public SegmentTree(int len, long e, LongBinaryOperator f) {
		SimpleUtil.nonNegativeCheck(len);
		this.e = e;
		this.f = f;
		n = 1;
		while(n < len) n <<= 1;
		nodes = new long[n << 1];
		Arrays.fill(nodes, e);
		rangeL = new int[n << 1];
		rangeR = new int[n << 1];
		for(int i = 0; i < n; i ++) {
			rangeL[i + n] = i;
			rangeR[i + n] = i + 1;
		}
		for(int i = n - 1; i > 0; i --) {
			rangeL[i] = rangeL[i << 1];
			rangeR[i] = rangeR[(i << 1) + 1];
		}
	}

	// O(logN)
	public void set(int i, long val) {
		SimpleUtil.rangeCheck(i, n);
		i += n;
		nodes[i] = val;
		while(i > 1) {
			i >>= 1;
			nodes[i] = f.applyAsLong(nodes[i << 1], nodes[(i << 1) + 1]);
		}
	}
	public void update(int i, long val) { set(i, f.applyAsLong(nodes[i + n], val)); }

	public long get(int i) { SimpleUtil.rangeCheck(i, n); return nodes[i + n]; } // O(1)

	public long find(int l, int r) { // O(logN)
		SimpleUtil.inclusiveRangeCheck(l, n);
		SimpleUtil.inclusiveRangeCheck(r, n);
		SimpleUtil.assertion(l <= r, "l is larger than r.");
		l += n; r += n;
		long xL = e;
		long xR = e;
		while(l < r) {
			if((l & 1) != 0) xL = f.applyAsLong(xL, nodes[l ++]);
			if((r & 1) != 0) xR = f.applyAsLong(nodes[-- r], xR);
			l >>= 1; r >>= 1;
		}
		return f.applyAsLong(xL, xR);
	}

	// min idx s.t. a<=idx<b && check(find(a,idx)) && !check(find(a,idx+1)) // O(logN)
	public int findLeftmost(LongPredicate check) { return findLeftmost(0, check); }
	public int findLeftmost(int l, LongPredicate check) { return findLeftmost(l, n, check); }
	public int findLeftmost(int l, int r, LongPredicate check){
		SimpleUtil.inclusiveRangeCheck(l, n);
		SimpleUtil.inclusiveRangeCheck(r, n);
		SimpleUtil.assertion(l <= r, "l is larger than r.");
		long crt = e;
		int idx;
		for(idx = l + n; idx < n << 1 && l < r; ) {
			long tmp = f.applyAsLong(crt, nodes[idx]);
			if(rangeR[idx] <= r && check.test(tmp)) {
				crt = tmp;
				l = rangeR[idx ++];
				if((idx & 1) == 0) idx >>= 1;
			}else idx <<= 1;
		}
		return l >= r ? r : l;
	}
	// max idx s.t. a<=idx<b && !check(find(idx-1,b)) && check(find(idx,b)) // O(logN)
	public int findRightmost(LongPredicate check) { return findRightmost(n, check); }
	public int findRightmost(int r, LongPredicate check) { return findRightmost(0, r, check); }
	public int findRightmost(int l, int r, LongPredicate check) {
		SimpleUtil.inclusiveRangeCheck(l, n);
		SimpleUtil.inclusiveRangeCheck(r, n);
		SimpleUtil.assertion(l <= r, "l is larger than r.");
		long crt = e;
		int idx;
		for(idx = r + n - 1; idx < n << 1 && r > l; ) {
			long tmp = f.applyAsLong(nodes[idx], crt);
			if(rangeL[idx] >= l && check.test(tmp)) {
				crt = tmp;
				r = rangeL[idx --];
				if((idx & 1) != 0) idx >>= 1;
			}else idx = (idx << 1) + 1;
		}
		return r <= l ? l : r;
	}
}