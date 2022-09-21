package library;

import java.util.*;
import library.SimpleUtil;
import library.Pair;

class Swag {
	int n;
	long val[];
	long e;
	LongBinaryOperator f;

	long front;
	Deque<Long> back = new ArrayDeque<>();
	int l = 0;
	int r = 0;

	// O(1)
	Swag(long[] val, long e, LongBinaryOperator f) {
		n = val.length;
		this.val = val;
		this.e = e;
		this.f = f;
		front = e;
	}

	// O(N + QlogQ)
	long[] query(Pair.II[] p) {
		Integer idx[] = new Integer[p.length];
		Arrays.sort(idx, (ele1, ele2) -> {
			int c = Integer.compare(p[ele1].a, p[ele2].a);
			if(c == 0) c = Integer.compare(p[ele1].b, p[ele2].b);
			if(c == 0) c = Integer.compare(ele1, ele2);
			return c;
		});
		long ans[] = new long[p.length];
		for(int i : idx) ans[i] = fold(p[i]);
		return ans;
	}
	// O(N + Q)
	// p is sorted
	long[] sortedQuery(Pair.II[] p) {
		long ans[] = new long[p.length];
		for(int i = 0; i < p.length; i ++) ans[i] = fold(p[i]);
		return ans;
	}

	// return fold [i, j)
	long fold(Pair.II p) { return fold(p.a, p.b); }
	long fold(int i, int j) {
		SimpleUtil.rangeCheck(i, n);
		SimpleUtil.inclusiveRangeCheck(j, n);
		SimpleUtil.assertion(i >= l && j >= r);
		while(r < j) front = f.applyAsLong(front, val[r ++]);
		while(l < i) {
			if(back.isEmpty()) {
				long tmp = e;
				for(int u = r - 1; u >= l; u --) {
					tmp = f.applyAsLong(val[u], tmp);
					back.addLast(tmp);
				}
				front = e;
			}
			back.removeLast();
			l ++;
		}
		return back.isEmpty() ? front : f.applyAsLong(back.getLast(), front);
	}
}