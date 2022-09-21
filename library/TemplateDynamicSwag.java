package library;

import java.util.*;
import java.util.function.*;
import library.SimpleUtil;
import library.Pair;

class TemplateSwag<T> {
	int n;
	T val[];
	Supplier<T> eSupplier;
	BinaryOperator<T> f;

	T front;
	Deque<T> back = new ArrayDeque<>();
	int l = 0;
	int r = 0;

	// O(1)
	TemplateSwag(T[] val, Supplier<T> eSupplier, BinaryOperator<T> f) {
		n = val.length;
		this.val = val;
		this.eSupplier = eSupplier;
		this.f = f;
		front = eSupplier.get();
	}

	// O(N + QlogQ)
	@SuppressWarnings("unchecked")
	T[] query(Pair.II[] p) {
		Integer idx[] = new Integer[p.length];
		Arrays.sort(idx, (ele1, ele2) -> {
			int c = Integer.compare(p[ele1].a, p[ele2].a);
			if(c == 0) c = Integer.compare(p[ele1].b, p[ele2].b);
			if(c == 0) c = Integer.compare(ele1, ele2);
			return c;
		});
		T ans[] = (T[]) new Object[p.length];
		for(int i : idx) ans[i] = fold(p[i]);
		return ans;
	}
	// O(N + Q)
	// p is sorted
	@SuppressWarnings("unchecked")
	T[] sortedQuery(Pair.II[] p) {
		T ans[] = (T[]) new Object[p.length];
		for(int i = 0; i < p.length; i ++) ans[i] = fold(p[i]);
		return ans;
	}

	// return fold [i, j)
	T fold(Pair.II p) { return fold(p.a, p.b); }
	T fold(int i, int j) {
		SimpleUtil.rangeCheck(i, n);
		SimpleUtil.inclusiveRangeCheck(j, n);
		SimpleUtil.assertion(i >= l && j >= r);
		while(r < j) front = f.apply(front, val[r ++]);
		while(l < i) {
			if(back.isEmpty()) {
				T tmp = eSupplier.get();
				for(int u = r - 1; u >= l; u --) {
					tmp = f.apply(val[u], tmp);
					back.addLast(tmp);
				}
				front = eSupplier.get();
			}
			back.removeLast();
			l ++;
		}
		return back.isEmpty() ? front : f.apply(back.getLast(), front);
	}
}