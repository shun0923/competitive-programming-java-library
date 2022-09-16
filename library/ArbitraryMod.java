package library;

final class ArbitraryMod extends Mod {
	private static final long MASK = 0xffff_ffffl;
	private final long MH;
	private final long ML;
	public ArbitraryMod(long mod) { super(mod); long a = (1l << 32) / MOD; long b = (1l << 32) % MOD; long m = a * a * MOD + 2 * a * b + (b * b) / MOD; MH = m >>> 32; ML = m & MASK; }

	private final long reduce(long x) {
		if(MOD == 1) return 0;
		if(x < 0) return (x = reduce(- x)) == 0 ? 0 : MOD - x;
		long z = (x & MASK) * ML;
		z = (x & MASK) * MH + (x >>> 32) * ML + (z >>> 32);
		z = (x >>> 32) * MH + (z >>> 32);
		x -= z * MOD;
		return x < MOD ? x : x - MOD;
	}
	@Override
	public long mod(long x) {
		if(0 <= x && x < MOD) return x;
		if(- MOD <= x && x < 0) return x + MOD;
		return reduce(x);
	}
	@Override
	public long mul(long x, long y) {
		if(x >= 0 && x < MOD && y >= 0 && y < MOD) return reduce(x * y);
		x = mod(x);
		y = mod(y);
		return reduce(x * y);
	}
}