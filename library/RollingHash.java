package library;

import library.FastIO;

final class RollingHash {
	static final long MASK30 = (1l << 30) - 1;
	static final long MASK31 = (1l << 31) - 1;
	static final long MODRH = (1l << 61) - 1;
	static final long MASK61 = MODRH;
	static final long POSITIVIZER = MODRH << 2;
	static final long BASE = (long) (Math.random() * (MODRH >>> 1)) + (MODRH >>> 1);
	private final long hash[];
	private final long pow[];
	public final int len;

	private static final long mul(final long a, final long b) { // O(1)
		long au = a >>> 31;
		long ad = a & MASK31;
		long bu = b >>> 31;
		long bd = b & MASK31;
		long mid = ad * bu + au * bd;
		long midu = mid >>> 30;
		long midd = mid & MASK30;
		return au * bu * 2 + midu + (midd << 31) + ad * bd;
	}
	private static final long mod(final long x) { // O(1)
		long xu = x >> 61;
		long xd = x & MASK61;
		long res = xu + xd;
		if(res >= MODRH) res -= MODRH;
		return res;
	}

	// O(|S|)
	public RollingHash(String s) { this(s.toCharArray()); }
	public RollingHash(char[] c) { this(FastIO.charToInt(c)); }
	public RollingHash(int[] a) {
		len = a.length;
		hash = new long[len + 1];
		pow = new long[len + 1];
		hash[0] = 0;
		pow[0] = 1;
		for(int i = 0; i < len; i ++) {
			hash[i + 1] = mod(mul(hash[i], BASE) + a[i]);
			pow[i + 1] = mod(mul(pow[i], BASE));
		}
	}

	// return the hash of S[l,r) // O(1)
	public final long get(int l, int r) {
		FastIO.inclusiveRangeCheck(l, len);
		FastIO.inclusiveRangeCheck(r, len);
		FastIO.assertion(l <= r, "l is larger than r.");
		long res = hash[r] - mul(hash[l], pow[r - l]);
		if(res < 0) res += POSITIVIZER;
		return mod(res);
	}
	public final long get() { return hash[len]; }

	public static final int lcp(RollingHash rh1, int a, RollingHash rh2, int b) { // O(max(|S_1|,|S_2|))
		FastIO.inclusiveRangeCheck(a, rh1.len);
		FastIO.inclusiveRangeCheck(b, rh2.len);
		int ok = 0;
		int ng = Math.min(rh1.len - a, rh2.len - b) + 1;
		while(ng - ok != 1) {
			int mid = ok + (ng - ok >> 1);
			if(rh1.get(a, a + mid) == rh2.get(b, b + mid)
				&& rh1.get(a, a + mid - 1) == rh2.get(b, b + mid - 1)) ok = mid; else ng = mid;
		}
		return ok;
	}
}