package library;

import java.util.*;
import library.FastIO;

class QuickSelect {
	// O(N)
	// return k-th(0-indexed) smallest
	public static final long selectWithRandom(long[] a, int k) {
		while(true) {
			long pivot = a[(int)Math.floor(Math.random() * a.length)];
			int small = 0;
			int equal = 0;
			int large = 0;
			for(long crt : a) {
				if(crt < pivot) small ++;
				else if(crt > pivot) large ++;
				else equal ++;
			}
			if(k < small) {
				long a2[] = new long[small];
				int idx = 0;
				for(long crt : a) if(crt < pivot) a2[idx ++] = crt;
				a = a2;
			}else if(k >= small + equal) {
				long a2[] = new long[large];
				int idx = 0;
				for(long crt : a) if(crt > pivot) a2[idx ++] = crt;
				a = a2;
				k -= small + equal;
			}else {
				return pivot;
			}
		}
	}
	public static final long select(final long[] a, final int k) { return select(a, k, 0, a.length); }
	public static final long select(final long[] a, final int k, int start, int end) {
		FastIO.assertion(start <= k && k < end);
		if(end - start == 1) return a[start];
		if(end - start <= 10) {
			Arrays.sort(a, start, end);
			return a[k];
		}
		while(true) {
			long pivot = pivot(a, start, end);
			int l = start;
			int r = end;
			long tmp[] = new long[end - start];
			Arrays.fill(tmp, pivot);
			for(int i = start; i < end; i ++) {
				if(a[i] < pivot) tmp[(l ++) - start] = a[i];
				else if(a[i] > pivot) tmp[(-- r) - start] = a[i];
			}
			for(int i = start; i < end; i ++) a[i] = tmp[i - start];
			if(r <= k) start = r;
			else if(l > k) end = l;
			else return a[k];
		}
	}
	private static final long pivot(final long[] a, final int start, final int end) {
		long med[] = new long[(end - start + 4) / 5];
		for(int l = start, j = 0; l < end; l += 5, j ++) med[j] = med5(a, l, Math.min(l + 5, end));
		if(med.length == 1) return med[0];
		return select(med, med.length >> 1);
	}
	private static final long med5(final long[] a, final int start, final int end) {
		return select(a, (end + start) >> 1, start, end);
	}
}