package library;

import library.SimpleUtil;
import library.Mod;
import library.Convolution;

abstract class ExtendedConvolution {
	protected static final long MOD1 = 754974721; // 2^24
	protected static final long MOD2 = 167772161; // 2^25
	protected static final long MOD3 = 469762049; // 2^26
	protected static final long M2M3 = MOD2 * MOD3;
	protected static final long M1M3 = MOD1 * MOD3;
	protected static final long M1M2 = MOD1 * MOD2;
	protected static final long M1M2M3 = MOD1 * MOD2 * MOD3;
	protected static final long M1INVM2 = 95869806; // inv(MOD1, MOD2);
	protected static final long INV1 = 190329765; // inv(MOD2 * MOD3, MOD1);
	protected static final long INV2 = 58587104; // inv(MOD1 * MOD3, MOD2);
	protected static final long INV3 = 187290749; // inv(MOD1 * MOD2, MOD3);
	protected final Mod MD1 = Mod754974721.md;
	protected final Mod MD2 = Mod167772161.md;
	protected final Mod MD3 = Mod469762049.md;
	protected final Convolution cnv1 = Convolution754974721.cnv;
	protected final Convolution cnv2 = Convolution167772161.cnv;
	protected final Convolution cnv3 = Convolution469762049.cnv;

	public final long[] cnv(final long[] a, final long[] b) { return cnv(a, b, Math.max(0, a.length + b.length - 1)); }
	public abstract long[] cnv(final long[] a, final long[] b, final int l);
}
final class ArbitraryConvolution extends ExtendedConvolution {
	private final Mod md;
	public ArbitraryConvolution(final Mod md) { this.md = md; }
	// O((N_1+N_2)log(N_1+N_2))
	@Override
	public final long[] cnv(final long[] a, final long[] b, final int l) {
		SimpleUtil.nonNegativeCheck(l);
		final long M1M2MOD = md.mod(MOD1 * MOD2);

		if(a.length == 0 || b.length == 0) return new long[l];
		long f1[] = cnv1.cnv(a, b, l);
		long f2[] = cnv2.cnv(a, b, l);
		long f3[] = cnv3.cnv(a, b, l);

		long f[] = new long[l];
		for(int i = 0; i < Math.min(l, a.length + b.length - 1); i ++) {
			long v1 = MD2.mod((f2[i] - f1[i]) * M1INVM2);
			long v2 = MD3.mod(MD3.mod(f3[i] - f1[i] - MOD1 * v1) * INV3);
			f[i] = md.mod(f1[i] + MOD1 * v1 + M1M2MOD * v2);
		}
		return f;
	}
}
final class LongConvolution extends ExtendedConvolution {
	public static final LongConvolution cnv = new LongConvolution();
	@Override
	public final long[] cnv(final long[] a, final long[] b, final int l) {
		SimpleUtil.nonNegativeCheck(l);
		if(a.length == 0 || b.length == 0) return new long[l];

		long f1[] = cnv1.cnv(a, b);
		long f2[] = cnv2.cnv(a, b);
		long f3[] = cnv3.cnv(a, b);

		long f[] = new long[l];
		for(int i = 0; i < Math.min(l, a.length + b.length - 1); i ++) {
			long x = 0;
			x += (f1[i] * INV1) % MOD1 * M2M3;
			x += (f2[i] * INV2) % MOD2 * M1M3;
			x += (f3[i] * INV3) % MOD3 * M1M2;
			long diff = f1[i] - (x % MOD1);
			if(diff < 0) diff += MOD1;
			long offset[] = {0, 0, M1M2M3, 2 * M1M2M3, 3 * M1M2M3};
			x -= offset[(int)(diff % 5)];
			f[i] = x;
		}
		return f;
	}
}
final class Convolution107 extends ExtendedConvolution {
	public static final Convolution107 cnv = new Convolution107();
	private static final long M1M2MOD = MOD1 * MOD2 % 1_000_000_007;
	@Override
	public final long[] cnv(final long[] a, final long[] b, final int l) {
		SimpleUtil.nonNegativeCheck(l);

		if(a.length == 0 || b.length == 0) return new long[l];

		long f1[] = cnv1.cnv(a, b, l);
		long f2[] = cnv2.cnv(a, b, l);
		long f3[] = cnv3.cnv(a, b, l);

		long f[] = new long[l];
		for(int i = 0; i < Math.min(l, a.length + b.length - 1); i ++) {
			long v1 = (f2[i] - f1[i]) * M1INVM2 % MOD2; if(v1 < 0) v1 += MOD2;
			long v2 = (f3[i] - f1[i] - MOD1 * v1) % MOD3 * INV3 % MOD3; if(v2 < 0) v2 += MOD3;
			f[i] = (f1[i] + MOD1 * v1 + M1M2MOD * v2) % 1_000_000_007;
		}
		return f;
	}
}