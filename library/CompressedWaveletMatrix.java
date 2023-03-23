package library;

import java.util.*;
import library.FastIO;
import library.WaveletMatrix;

class CompressedWaveletMatrix {
	int n;
	long val[];
	TreeMap<Long, Integer> tm = new TreeMap<>();
	WaveletMatrix wm;

	CompressedWaveletMatrix(long[] a) {
		n = a.length;
		Set<Long> ts = new TreeSet<>();
		for(int i = 0; i < n; i ++) ts.add(a[i]);
		val = new long[ts.size()];
		int j = 0;
		for(long x : ts) { val[j] = x; tm.put(x, j ++); }
		int a2[] = new int[n];
		for(int i = 0; i < n; i ++) a2[i] = tm.get(a[i]);
		wm = new WaveletMatrix(a2);
	}

	final long get(int k) { return val[wm.get(k)]; }
	final int rank(long x, int k) { return tm.containsKey(x) ? wm.rank(tm.get(x), k) : 0; }
	final int rank(long x, int l, int r) { return tm.containsKey(x) ? wm.rank(tm.get(x), l, r) : 0; }
	final int select(long x, int k) { return tm.containsKey(x) ? wm.select(tm.get(x), k) : n; }
	final long smallest(int l, int r, int k) { return val[wm.smallest(l, r, k)]; }
	final long largest(int l, int r, int k) { return val[wm.largest(l, r, k)]; }
	final int lessFreq(long x, int l, int r) { var e = tm.ceilingEntry(x); return e == null ? r - l : wm.lessFreq(e.getValue(), l, r); }
	final int greaterFreq(long x, int l, int r) { var e = tm.ceilingEntry(x); return e == null ? 0 : wm.greaterFreq(e.getValue(), l, r); }
	final int rangeFreq(long lower, long upper, int l, int r) { return lessFreq(upper, l, r) - lessFreq(lower, l, r); }
	final int freq(int x, int l, int r) { return rank(x, r) - rank(x, l); }
}