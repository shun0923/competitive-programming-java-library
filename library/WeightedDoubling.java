package library;

import java.util.*;
import java.util.function.*;
import library.FastIO;
import library.AbstractGraph;

final class WeightedDoubling {
	private final long id;
	private final LongBinaryOperator f;
	public final int n;
	public final int log;
	public final int next[][];
	public final long val[][];

	private WeightedDoubling(final int n, final long max, final long id, final LongBinaryOperator f) { // O(1)
		FastIO.nonNegativeCheck(n);
		FastIO.nonNegativeCheck(max);
		this.id = id;
		this.f = f;
		this.n = n;
		log = Long.numberOfTrailingZeros(Long.highestOneBit(max)) + 1;
		next = new int[log][n];
		val = new long[log][n];
		Arrays.fill(next[0], -1);
	}
	// O(NlogM)
	public WeightedDoubling(final int n, final long max, final long id, final LongBinaryOperator f, final WeightedNode edges) {
		this(n, max, id, f);
		for(WeightedEdge e : edges) {
			next[0][e.source] = e.target;
			val[0][e.source] = e.cost;
		}
		init();
	}
	private final void init() {
		for(int k = 0; k + 1 < log; k ++) {
			for(int v = 0; v < n; v ++) {
				if(next[k][v] == -1) {
					next[k + 1][v] = -1;
					val[k + 1][v] = id;
				}else {
					next[k + 1][v] = next[k][next[k][v]];
					val[k + 1][v] = f.applyAsLong(val[k][v], val[k][next[k][v]]);
				}
			}
		}
	}

	WeightedEdge cal(int x, final long q) { // O(logQ)
		FastIO.rangeCheck(x, n);
		FastIO.nonNegativeCheck(q);
		WeightedEdge e = new WeightedEdge(x, x, id);
		for(int k = log - 1; k >= 0; k --) {
			if(e.target == -1) { e.cost = id; break; }
			if((q & 1l << k) != 0) {
				e.cost = f.applyAsLong(e.cost, val[k][e.target]);
				e.target = next[k][e.target];
			}
		}
		return e;
	}

	long bisect(int x, long q) { // O(logM)
		FastIO.rangeCheck(x, n);
		long ans = 0;
		WeightedEdge e = new WeightedEdge(x, x, id);
		for(int k = log - 1; k >= 0; k --) {
			if(e.target == -1) return -1;
			long tmp = f.applyAsLong(e.cost, val[k][e.target]);
			if(tmp <= q) {
				e.cost = tmp;
				e.target = next[k][e.target];
				ans |= 1l << k;
			}
		}
		return ans;
	}
}