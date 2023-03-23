package library;

import java.util.*;
import library.FastIO;
import library.AbstractGraph;

final class Doubling {
	public final int n;
	public final int log;
	public final int next[][];

	private Doubling(final int n, final long max) { // O(1)
		FastIO.nonNegativeCheck(n);
		FastIO.nonNegativeCheck(max);
		this.n = n;
		log = Long.numberOfTrailingZeros(Long.highestOneBit(max)) + 1;
		next = new int[log][n];
		Arrays.fill(next[0], -1);
	}
	// O(NlogM)
	public Doubling(final int n, final long max, final int[] edges) {
		this(n, max);
		System.arraycopy(edges, 0, next[0], 0, n);
		init();
	}
	public Doubling(final int n, final long max, final AbstractNode<? extends AbstractEdge> edges) {
		this(n, max);
		for(AbstractEdge e : edges) next[0][e.source] = e.target;
		init();
	}
	private final void init() {
		for(int k = 0; k + 1 < log; k ++) {
			for(int v = 0; v < n; v ++) {
				if(next[k][v] == -1) next[k + 1][v] = -1;
				else next[k + 1][v] = next[k][next[k][v]];
			}
		}
	}

	int cal(int x, final long q) { // O(logQ)
		FastIO.rangeCheck(x, n);
		FastIO.nonNegativeCheck(q);
		for(int k = log - 1; k >= 0; k --) {
			if(x == -1) break;
			if((q & 1l << k) != 0) x = next[k][x];
		}
		return x;
	}
}