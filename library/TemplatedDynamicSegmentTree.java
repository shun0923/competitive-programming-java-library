package library;

import java.util.function.*;
import library.SimpleUtil;

class TemplatedDynamicSegmentTree<T> {
	class NodeST {
		T val;
		NodeST l = null;
		NodeST r = null;
		NodeST() { val = eSupplier.get(); }
		NodeST(T val) { this.val = val; }
	}

	long n;
	Supplier<T> eSupplier;
	T e;
	BinaryOperator<T> f;

	NodeST root;

	// O(1)
	TemplatedDynamicSegmentTree(long len, Supplier<T> eSupplier, BinaryOperator<T> f) {
		SimpleUtil.nonNegativeCheck(len);
		this.n = len; this.eSupplier = eSupplier; this.e = eSupplier.get(); this.f = f;
		root = new NodeST();
	}

	// O(logN)
	void set(long i, T val) { SimpleUtil.rangeCheck(i, n); update(i, val, false); }
	void update(long i, T val) { SimpleUtil.rangeCheck(i, n); update(i, val, true); }
	void update(long i, T val, boolean update) { update(root, 0, n, i, val, update); }
	NodeST update(NodeST t, long l, long r, long i, T val, boolean update) {
		if(t == null) t = new NodeST();
		if(r - l == 1) { t.val = update ? f.apply(t.val, val) : val; return t; }
		long mid = (l + r) >> 1;
		if(i < mid) t.l = update(t.l, l, mid, i, val, update);
		else t.r = update(t.r, mid, r, i, val, update);
		t.val = eSupplier.get();
		if(t.l != null) t.val = f.apply(t.val, t.l.val);
		if(t.r != null) t.val = f.apply(t.val, t.r.val);
		return t;
	}

	// O(logN)
	T get(long i) { SimpleUtil.rangeCheck(i, n); return get(root, 0, n, i); }
	T get(NodeST t, long l, long r, long i) {
		if(t == null) return e;
		if(r - l == 1) return t.val;
		long mid = (l + r) >> 1;
		return i < mid ? get(t.l, l, mid, i) : get(t.r, mid, r, i);
	}
	T find(long l0, long r0) {
		SimpleUtil.inclusiveRangeCheck(l0, n);
		SimpleUtil.inclusiveRangeCheck(r0, n);
		SimpleUtil.assertion(l0 <= r0, "l is larger than r.");
		return find(root, 0, n, l0, r0);
	}
	T find(NodeST t, long l, long r, long l0, long r0) {
		if(l == r || t == null || r0 <= l || r <= l0) return e;
		if(l0 <= l && r <= r0) return t.val;
		long mid = (l + r) >> 1;
		return f.apply(find(t.l, l, mid, l0, r0), find(t.r, mid, r, l0, r0));
	}
}