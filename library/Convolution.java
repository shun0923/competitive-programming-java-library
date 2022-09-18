package library;

import java.util.*;
import library.Util;
import library.Mod;

class Convolution { // M=MOD
	public Mod md;
	private long g;
	static final int SIZE = 30;
	protected final long sumE[] = new long[SIZE];
	protected final long sumIE[] = new long[SIZE];
	static final int NAIVE_THRESHOLD = 512;
	public Convolution(Mod md) { // O(logM)
		this.md = md;
		g = md.primitiveRoot();
		prepareSum();
	}

	private final void prepareSum() { // O(logM)
		final long[] es = new long[SIZE];
		final long[] ies = new long[SIZE];
		final int len = Long.numberOfTrailingZeros(md.MOD - 1);
		long e = md.pow(g, (md.MOD - 1) >> len);
		long ie = md.inv(e);
		for(int i = len - 2; i >= 0; i --) {
			es[i] = e;
			ies[i] = ie;
			e = md.mul(e, e);
			ie = md.mul(ie, ie);
		}
		long tmpE = 1;
		long tmpIE = 1;
		for(int i = 0; i < len - 2; i++) {
			sumE[i] = md.mul(es[i], tmpE);
			tmpE = md.mul(tmpE, ies[i]);
			sumIE[i] = md.mul(ies[i], tmpIE);
			tmpIE = md.mul(tmpIE, es[i]);
		}
	}

	public long[] butterfly(final long[] a) { // O(NlogN)
		final int n = a.length;
		int h = 0;
		while((1L << h) < n) h ++;

		for(int ph = 1; ph <= h; ph ++) {
			final int w = 1 << ph - 1;
			final int p = 1 << h - ph;
			long tmp = 1;
			for(int s = 0; s < w; s ++) {
				final int offset = s << h - ph + 1;
				for(int i = 0; i < p; i ++) {
					final long l = a[i + offset];
					final long r = md.mul(a[i + offset + p], tmp);
					a[i + offset] = md.add(l, r);
					a[i + offset + p] = md.sub(l, r);
				}
				tmp = md.mul(tmp, sumE[Integer.numberOfTrailingZeros(~ s)]);
			}
		}
		return a;
	}
	public long[] butterflyInv(final long[] a) { // O(NlogN)
		final int n = a.length;
		int h = 0;
		while((1L << h) < n) h ++;

		for(int ph = h; ph >= 1; ph --) {
			final int w = 1 << ph - 1;
			final int p = 1 << h - ph;
			long tmp = 1;
			for(int s = 0; s < w; s ++) {
				int offset = s << h - ph + 1;
				for(int i = 0; i < p; i ++) {
					final long l = a[i + offset];
					final long r = a[i + offset + p];
					a[i + offset] = md.add(l, r);
					a[i + offset + p] = md.mul(md.sub(l, r), tmp);
				}
				tmp = md.mul(tmp, sumIE[Integer.numberOfTrailingZeros(~ s)]);
			}
		}
		return a;
	}

	// O((N_1+N_2)log(N_1+N_2))
	public final long[] cnv(final long[] a, final long[] b) { return cnv(a, b, Math.max(0, a.length + b.length - 1)); }
	public long[] cnv(final long[] a, final long[] b, final int l) {
		Util.nonNegativeCheck(l);
		if(a.length == 0 || b.length == 0) return new long[l];

		int len = 1;
		while(len < a.length + b.length - 1) len <<= 1;
		if(len <= NAIVE_THRESHOLD) return naiveCnv(a, b, l);

		final long g[] = new long[len];
		System.arraycopy(a, 0, g, 0, a.length);
		final long h[] = new long[len];
		System.arraycopy(b, 0, h, 0, b.length);

		butterfly(g);
		butterfly(h);

		long f[] = new long[len];
		for(int i = 0; i < len; i ++) f[i] = md.mul(g[i], h[i]);
		butterflyInv(f);
		final long f2[] = new long[l];
		System.arraycopy(f, 0, f2, 0, Math.min(l, len));

		final long invLen = md.inv(len);
		for(int i = 0; i < Math.min(l, len); i ++) f2[i] = md.mul(f2[i], invLen);
		return f2;
	}

	// O(N_1N_2)
	public final long[] naiveCnv(final long[] a, final long[] b) {
		return naiveCnv(a, b, Math.max(0, a.length + b.length - 1));
	}
	public long[] naiveCnv(final long[] a, final long[] b, final int l) {
		Util.nonNegativeCheck(l);
		if(a.length == 0 || b.length == 0) return new long[l];

		final long f[] = new long[l];
		for(int i = 0; i < a.length; i ++) {
			for(int j = 0; j < b.length && i + j < l; j ++) {
				f[i + j] = md.add(f[i + j], md.mul(a[i], b[j]));
			}
		}
		return f;
	}

	// O(NlogN)
	public final long[] doubling(final long[] a) {
		final int len = a.length;
		final long b[] = new long[len];
		for(int i = 0; i < len; i ++) b[i] = a[i];

		butterflyInv(b);
		final long invLen = md.inv(len);
		long r = 1;
		final long zeta = md.pow(g, (md.MOD - 1) / (len << 1));
		for(int i = 0; i < len; i ++) {
			b[i] = md.mul(b[i], invLen, r);
			r = md.mul(r, zeta);
		}

		butterfly(b);
		final long b2[] = new long[len << 1];
		System.arraycopy(b, 0, b2, len, len);
		System.arraycopy(a, 0, b2, 0, len);
		return b;
	}
}
final class Convolution998 extends Convolution { // M=MOD
	public static final Convolution998 cnv = new Convolution998();
	public Convolution998() { super(Mod998.md); }

	public final long[] butterfly(final long[] a) { // O(NlogN)
		final int n = a.length;
		int h = 0;
		while((1L << h) < n) h ++;
		for(int i = 0; i < n; i ++) a[i] %= 998_244_353;

		for(int ph = 1; ph <= h; ph ++) {
			final int w = 1 << ph - 1;
			final int p = 1 << h - ph;
			long tmp = 1;
			for(int s = 0; s < w; s ++) {
				int offset = s << h - ph + 1;
				for(int i = 0; i < p; i ++) {
					final long l = a[i + offset];
					final long r = a[i + offset + p] * tmp % 998_244_353;
					a[i + offset] = md.add(l, r);
					a[i + offset + p] = md.sub(l, r);
				}
				tmp = tmp * sumE[Integer.numberOfTrailingZeros(~ s)] % 998_244_353;
			}
		}
		return a;
	}
	public final long[] butterflyInv(final long[] a) { // O(NlogN)
		final int n = a.length;
		int h = 0;
		while((1L << h) < n) h ++;

		for(int ph = h; ph >= 1; ph --) {
			final int w = 1 << ph - 1;
			final int p = 1 << h - ph;
			long tmp = 1;
			for(int s = 0; s < w; s ++) {
				int offset = s << h - ph + 1;
				for(int i = 0; i < p; i ++) {
					final long l = a[i + offset];
					final long r = a[i + offset + p];
					a[i + offset] = l + r >= 998_244_353 ? l + r - 998_244_353 : l + r;
					a[i + offset + p] = (l - r + 998_244_353) * tmp % 998_244_353;
				}
				tmp = tmp * sumIE[Integer.numberOfTrailingZeros(~ s)] % 998_244_353;
			}
		}
		return a;
	}

	// O((N_1+N_2)log(N_1+N_2))
	public final long[] cnv(final long[] a, final long[] b, final int l) {
		Util.nonNegativeCheck(l);
		if(a.length == 0 || b.length == 0) return new long[l];

		int len = 1;
		while(len < a.length + b.length - 1) len <<= 1;
		if(len <= NAIVE_THRESHOLD) return naiveCnv(a, b, l);

		final long g[] = new long[len];
		System.arraycopy(a, 0, g, 0, a.length);
		final long h[] = new long[len];
		System.arraycopy(b, 0, h, 0, b.length);

		butterfly(g);
		butterfly(h);

		final long f[] = new long[len];
		for(int i = 0; i < len; i ++) f[i] = g[i] * h[i] % 998_244_353;
		butterflyInv(f);
		final long f2[] = new long[l];
		System.arraycopy(f, 0, f2, 0, Math.min(l, len));

		final long invLen = md.inv(len);
		for(int i = 0; i < Math.min(l, len); i ++) f2[i] = f2[i] * invLen % 998_244_353;
		return f2;
	}

	public final long[] naiveCnv(final long[] a, final long[] b, final int l) {
		Util.nonNegativeCheck(l);
		if(a.length == 0 || b.length == 0) return new long[l];

		final long f[] = new long[l];
		for(int i = 0; i < a.length; i ++) {
			for(int j = 0; j < b.length && i + j < l; j ++) {
				f[i + j] = (f[i + j] + a[i] * b[j]) % 998_244_353;
			}
		}
		return f;
	}
}
final class Convolution754974721 extends Convolution { // M=MOD
	public static final Convolution754974721 cnv = new Convolution754974721();
	public Convolution754974721() { super(Mod754974721.md); }

	public final long[] butterfly(final long[] a) { // O(NlogN)
		final int n = a.length;
		int h = 0;
		while((1L << h) < n) h ++;
		for(int i = 0; i < n; i ++) a[i] %= 754_974_721;

		for(int ph = 1; ph <= h; ph ++) {
			final int w = 1 << ph - 1;
			final int p = 1 << h - ph;
			long tmp = 1;
			for(int s = 0; s < w; s ++) {
				int offset = s << h - ph + 1;
				for(int i = 0; i < p; i ++) {
					final long l = a[i + offset];
					final long r = a[i + offset + p] * tmp % 754_974_721;
					a[i + offset] = md.add(l, r);
					a[i + offset + p] = md.sub(l, r);
				}
				tmp = tmp * sumE[Integer.numberOfTrailingZeros(~ s)] % 754_974_721;
			}
		}
		return a;
	}
	public final long[] butterflyInv(final long[] a) { // O(NlogN)
		final int n = a.length;
		int h = 0;
		while((1L << h) < n) h ++;

		for(int ph = h; ph >= 1; ph --) {
			final int w = 1 << ph - 1;
			final int p = 1 << h - ph;
			long tmp = 1;
			for(int s = 0; s < w; s ++) {
				int offset = s << h - ph + 1;
				for(int i = 0; i < p; i ++) {
					final long l = a[i + offset];
					final long r = a[i + offset + p];
					a[i + offset] = l + r >= 754_974_721 ? l + r - 754_974_721 : l + r;
					a[i + offset + p] = (l - r + 754_974_721) * tmp % 754_974_721;
				}
				tmp = tmp * sumIE[Integer.numberOfTrailingZeros(~ s)] % 754_974_721;
			}
		}
		return a;
	}

	// O((N_1+N_2)log(N_1+N_2))
	public final long[] cnv(final long[] a, final long[] b, final int l) {
		Util.nonNegativeCheck(l);
		if(a.length == 0 || b.length == 0) return new long[l];

		int len = 1;
		while(len < a.length + b.length - 1) len <<= 1;
		if(len <= NAIVE_THRESHOLD) return naiveCnv(a, b, l);

		final long g[] = new long[len];
		System.arraycopy(a, 0, g, 0, a.length);
		final long h[] = new long[len];
		System.arraycopy(b, 0, h, 0, b.length);

		butterfly(g);
		butterfly(h);

		long f[] = new long[len];
		for(int i = 0; i < len; i ++) f[i] = g[i] * h[i] % 754_974_721;
		butterflyInv(f);
		final long f2[] = new long[l];
		System.arraycopy(f, 0, f2, 0, Math.min(l, len));

		final long invLen = md.inv(len);
		for(int i = 0; i < Math.min(l, len); i ++) f2[i] = f2[i] * invLen % 754_974_721;
		return f2;
	}

	public final long[] naiveCnv(final long[] a, final long[] b, final int l) {
		Util.nonNegativeCheck(l);
		if(a.length == 0 || b.length == 0) return new long[l];

		final long f[] = new long[l];
		for(int i = 0; i < a.length; i ++) {
			for(int j = 0; j < b.length && i + j < l; j ++) {
				f[i + j] = (f[i + j] + a[i] * b[j]) % 754_974_721;
			}
		}
		return f;
	}
}
final class Convolution167772161 extends Convolution { // M=MOD
	public static final Convolution167772161 cnv = new Convolution167772161();
	public Convolution167772161() { super(Mod167772161.md); }

	public final long[] butterfly(final long[] a) { // O(NlogN)
		final int n = a.length;
		int h = 0;
		while((1L << h) < n) h ++;
		for(int i = 0; i < n; i ++) a[i] %= 167_772_161;

		for(int ph = 1; ph <= h; ph ++) {
			final int w = 1 << ph - 1;
			final int p = 1 << h - ph;
			long tmp = 1;
			for(int s = 0; s < w; s ++) {
				int offset = s << h - ph + 1;
				for(int i = 0; i < p; i ++) {
					final long l = a[i + offset];
					final long r = a[i + offset + p] * tmp % 167_772_161;
					a[i + offset] = md.add(l, r);
					a[i + offset + p] = md.sub(l, r);
				}
				tmp = tmp * sumE[Integer.numberOfTrailingZeros(~ s)] % 167_772_161;
			}
		}
		return a;
	}
	public final long[] butterflyInv(final long[] a) { // O(NlogN)
		final int n = a.length;
		int h = 0;
		while((1L << h) < n) h ++;

		for(int ph = h; ph >= 1; ph --) {
			final int w = 1 << ph - 1;
			final int p = 1 << h - ph;
			long tmp = 1;
			for(int s = 0; s < w; s ++) {
				int offset = s << h - ph + 1;
				for(int i = 0; i < p; i ++) {
					final long l = a[i + offset];
					final long r = a[i + offset + p];
					a[i + offset] = l + r >= 167_772_161 ? l + r - 167_772_161 : l + r;
					a[i + offset + p] = (l - r + 167_772_161) * tmp % 167_772_161;
				}
				tmp = tmp * sumIE[Integer.numberOfTrailingZeros(~ s)] % 167_772_161;
			}
		}
		return a;
	}

	// O((N_1+N_2)log(N_1+N_2))
	public final long[] cnv(final long[] a, final long[] b, final int l) {
		Util.nonNegativeCheck(l);
		if(a.length == 0 || b.length == 0) return new long[l];

		int len = 1;
		while(len < a.length + b.length - 1) len <<= 1;
		if(len <= NAIVE_THRESHOLD) return naiveCnv(a, b, l);

		final long g[] = new long[len];
		System.arraycopy(a, 0, g, 0, a.length);
		final long h[] = new long[len];
		System.arraycopy(b, 0, h, 0, b.length);

		butterfly(g);
		butterfly(h);

		long f[] = new long[len];
		for(int i = 0; i < len; i ++) f[i] = g[i] * h[i] % 167_772_161;
		butterflyInv(f);
		final long f2[] = new long[l];
		System.arraycopy(f, 0, f2, 0, Math.min(l, len));

		final long invLen = md.inv(len);
		for(int i = 0; i < Math.min(l, len); i ++) f2[i] = f2[i] * invLen % 167_772_161;
		return f2;
	}

	public final long[] naiveCnv(final long[] a, final long[] b, final int l) {
		Util.nonNegativeCheck(l);
		if(a.length == 0 || b.length == 0) return new long[l];

		final long f[] = new long[l];
		for(int i = 0; i < a.length; i ++) {
			for(int j = 0; j < b.length && i + j < l; j ++) {
				f[i + j] = (f[i + j] + a[i] * b[j]) % 167_772_161;
			}
		}
		return f;
	}
}
final class Convolution469762049 extends Convolution { // M=MOD
	public static final Convolution469762049 cnv = new Convolution469762049();
	public Convolution469762049() { super(Mod469762049.md); }

	public final long[] butterfly(final long[] a) { // O(NlogN)
		final int n = a.length;
		int h = 0;
		while((1L << h) < n) h ++;
		for(int i = 0; i < n; i ++) a[i] %= 469_762_049;

		for(int ph = 1; ph <= h; ph ++) {
			final int w = 1 << ph - 1;
			final int p = 1 << h - ph;
			long tmp = 1;
			for(int s = 0; s < w; s ++) {
				int offset = s << h - ph + 1;
				for(int i = 0; i < p; i ++) {
					final long l = a[i + offset];
					final long r = a[i + offset + p] * tmp % 469_762_049;
					a[i + offset] = md.add(l, r);
					a[i + offset + p] = md.sub(l, r);
				}
				tmp = tmp * sumE[Integer.numberOfTrailingZeros(~ s)] % 469_762_049;
			}
		}
		return a;
	}
	public final long[] butterflyInv(final long[] a) { // O(NlogN)
		final int n = a.length;
		int h = 0;
		while((1L << h) < n) h ++;

		for(int ph = h; ph >= 1; ph --) {
			final int w = 1 << ph - 1;
			final int p = 1 << h - ph;
			long tmp = 1;
			for(int s = 0; s < w; s ++) {
				int offset = s << h - ph + 1;
				for(int i = 0; i < p; i ++) {
					final long l = a[i + offset];
					final long r = a[i + offset + p];
					a[i + offset] = l + r >= 469_762_049 ? l + r - 469_762_049 : l + r;
					a[i + offset + p] = (l - r + 469_762_049) * tmp % 469_762_049;
				}
				tmp = tmp * sumIE[Integer.numberOfTrailingZeros(~ s)] % 469_762_049;
			}
		}
		return a;
	}

	// O((N_1+N_2)log(N_1+N_2))
	public final long[] cnv(final long[] a, final long[] b, final int l) {
		Util.nonNegativeCheck(l);
		if(a.length == 0 || b.length == 0) return new long[l];

		int len = 1;
		while(len < a.length + b.length - 1) len <<= 1;
		if(len <= NAIVE_THRESHOLD) return naiveCnv(a, b, l);

		final long g[] = new long[len];
		System.arraycopy(a, 0, g, 0, a.length);
		final long h[] = new long[len];
		System.arraycopy(b, 0, h, 0, b.length);

		butterfly(g);
		butterfly(h);

		long f[] = new long[len];
		for(int i = 0; i < len; i ++) f[i] = g[i] * h[i] % 469_762_049;
		butterflyInv(f);
		final long f2[] = new long[l];
		System.arraycopy(f, 0, f2, 0, Math.min(l, len));

		final long invLen = md.inv(len);
		for(int i = 0; i < Math.min(l, len); i ++) f2[i] = f2[i] * invLen % 469_762_049;
		return f2;
	}

	public final long[] naiveCnv(final long[] a, final long[] b, final int l) {
		Util.nonNegativeCheck(l);
		if(a.length == 0 || b.length == 0) return new long[l];

		final long f[] = new long[l];
		for(int i = 0; i < a.length; i ++) {
			for(int j = 0; j < b.length && i + j < l; j ++) {
				f[i + j] = (f[i + j] + a[i] * b[j]) % 469_762_049;
			}
		}
		return f;
	}
}