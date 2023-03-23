package library;

import java.util.function.*;
import library.FastIO;

class TemplateSegmentTree<T> {
	private Supplier<T> eSupplier;
	private T e;
	private BinaryOperator<T> f;

	private int n;
	private T nodes[];
	private int rangeL[];
	private int rangeR[];

	// O(N)
	public TemplateSegmentTree(T[] a, Supplier<T> eSupplier, BinaryOperator<T> f) {
		this(a.length, eSupplier, f);
		System.arraycopy(a, 0, nodes, n, a.length);
		for(int i = n - 1; i > 0; i --) nodes[i] = f.apply(nodes[i << 1], nodes[(i << 1) + 1]);
	}
	public TemplateSegmentTree(int len, Supplier<T> xSupplier, Supplier<T> eSupplier, BinaryOperator<T> f) {
		this(len, eSupplier, f);
		for(int i = 0; i < len; i ++) nodes[n + i] = xSupplier.get();
		for(int i = n - 1; i > 0; i --) nodes[i] = f.apply(nodes[i << 1], nodes[(i << 1) + 1]);
	}
	@SuppressWarnings("unchecked")
	public TemplateSegmentTree(int len, Supplier<T> eSupplier, BinaryOperator<T> f) {
		FastIO.nonNegativeCheck(len);
		this.eSupplier = eSupplier;
		this.e = eSupplier.get();
		this.f = f;
		n = 1;
		while(n < len) n <<= 1;
		nodes = (T[]) new Object[n << 1];
		for(int i = 0; i < nodes.length; i ++) nodes[i] = eSupplier.get();
		rangeL = new int[n << 1];
		rangeR = new int[n << 1];
		for(int i = 0; i < n; i ++) { rangeL[i + n] = i; rangeR[i + n] = i + 1; }
		for(int i = n - 1; i > 0; i --) {
			rangeL[i] = rangeL[i << 1]; rangeR[i] = rangeR[(i << 1) + 1];
		}
	}


	// O(logN)
	public void set(int i, T val) {
		FastIO.rangeCheck(i, n);
		i += n;
		nodes[i] = val;
		while(i > 1) {
			i >>= 1;
			nodes[i] = f.apply(nodes[i << 1], nodes[(i << 1) + 1]);
		}
	}
	public void update(int i, T val) { set(i, f.apply(nodes[i + n], val)); }

	public T get(int i) { return nodes[i + n]; } // O(1)

	public T find(int l, int r) { // O(logN)
		FastIO.inclusiveRangeCheck(l, n);
		FastIO.inclusiveRangeCheck(r, n);
		FastIO.assertion(l <= r, "l is larger than r.");
		l += n; r += n;
		T xL = eSupplier.get();
		T xR = eSupplier.get();
		while(l < r) {
			if((l & 1) != 0) xL = f.apply(xL, nodes[l ++]);
			if((r & 1) != 0) xR = f.apply(nodes[-- r], xR);
			l >>= 1; r >>= 1;
		}
		return f.apply(xL, xR);
	}

	// min idx s.t. a<=idx<b && check(find(a,idx)) && !check(find(a,idx+1)) // O(logN)
	public int findLeftmost(Predicate<T> check) { return findLeftmost(0, check); }
	public int findLeftmost(int l, Predicate<T> check) { return findLeftmost(l, n, check); }
	public int findLeftmost(int l, int r, Predicate<T> check) {
		FastIO.inclusiveRangeCheck(l, n);
		FastIO.inclusiveRangeCheck(r, n);
		FastIO.assertion(l <= r, "l is larger than r.");
		T crt = eSupplier.get();
		int idx;
		for(idx = l + n; idx < n << 1 && l < r; ){
			T tmp = f.apply(crt, nodes[idx]);
			if(rangeR[idx] <= r && check.test(tmp)) {
				crt = tmp;
				l = rangeR[idx ++];
				if((idx & 1) == 0) idx >>= 1;
			}else idx <<= 1;
		}
		return l >= r ? r : l;
	}
	// max idx s.t. a<=idx<b && !check(find(idx-1,b)) && check(find(idx,b)) // O(logN)
	public int findRightmost(Predicate<T> check) { return findRightmost(n, check); }
	public int findRightmost(int r, Predicate<T> check) { return findRightmost(0, r, check); }
	public int findRightmost(int l, int r, Predicate<T> check) {
		FastIO.inclusiveRangeCheck(l, n);
		FastIO.inclusiveRangeCheck(r, n);
		FastIO.assertion(l <= r, "l is larger than r.");
		T crt = eSupplier.get();
		int idx;
		for(idx = r + n - 1; idx < n << 1 && r > l; ){
			T tmp = f.apply(nodes[idx], crt);
			if(rangeL[idx] >= l && check.test(tmp)) {
				crt = tmp;
				r = rangeL[idx --];
				if((idx & 1) != 0) idx >>= 1;
			}else idx = (idx << 1) + 1;
		}
		return r <= l ? l : r;
	}
}