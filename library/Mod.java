package library;

import java.util.*;

abstract class Mod {
	public final long MOD;
	public Mod(long mod) { MOD = mod; }

	public abstract long mod(long x);
	public final long[] mod(final long[] a) { for(int i = 0; i < a.length; i ++) a[i] = mod(a[i]); return a; }
	public final long[][] mod(final long[][] a) { for(int i = 0; i < a.length; i ++) mod(a[i]); return a; }
	public final long[][][] mod(final long[][][] a) { for(int i = 0; i < a.length; i ++) mod(a[i]); return a; }

	public long add(long x, final long y) { return (x += y) >= MOD * 2 || x < 0 ? mod(x) : x >= MOD ? x - MOD : x; }
	public final long sum(final long... x) { long sum = 0; for(long ele : x) sum = add(sum, ele); return sum; }
	public long sub(long x, final long y) { return (x -= y) < - MOD || x >= MOD ? mod(x) : x < 0 ? x + MOD : x; }
	public final long pow(long x, long y) {
		Util.nonNegativeCheck(y);
		x = mod(x);
		long ans = 1;
		for(; y > 0; y >>= 1) {
			if((y & 1) != 0) ans = mul(ans, x);
			x = mul(x, x);
		}
		return ans;
	}
	public abstract long mul(long x, long y);
	public final long mul(final long... x) { long ans = 1; for(long ele : x) ans = mul(ans, ele); return ans; }
	public final long div(final long x, final long y) { return mul(x, inv(y)); }

	public final long[] pows(long x, final int n) {
		x = mod(x);
		long pow[] = new long[n + 1];
		pow[0] = 1;
		for(int i = 0; i < n; i ++) pow[i + 1] = mul(pow[i], x);
		return pow;
	}
	public final long fact(final int n) {
		Util.nonNegativeCheck(n);
		prepareFact();
		if(n < MAX_FACT1) return fact[n];
		else {
			long ans = fact[MAX_FACT1 - 1];
			for(int i = MAX_FACT1; i <= n; i ++) ans = mul(ans, i);
			return ans;
		}
	}
	public final long invFact(final int n) {
		Util.nonNegativeCheck(n);
		prepareFact();
		if(n < MAX_FACT1) return invFact[n];
		else return inv(fact(n));
	}

	private static final int MAX_INV_SIZE = 100_100;
	private final Map<Long, Long> invMap = new HashMap<>();
	public final long inv(long x) {
		x = mod(x);
		if(invMap.containsKey(x)) return invMap.get(x);
		if(invMap.size() >= MAX_INV_SIZE) return calInv(x);
		invMap.put(x, calInv(x));
		return invMap.get(x);
	}
	private final long calInv(final long x) { // O(logM)
		long s0 = MOD, s1 = 0;
		long t0 = mod(x), t1 = 1;
		while(t0 > 0) {
			final long tmp = s0 / t0;
			final long u0 = s0 - t0 * tmp;
			final long u1 = s1 - t1 * tmp;
			s0 = t0;
			s1 = t1;
			t0 = u0;
			t1 = u1;
		}
		if(s0 != 1) throw new ArithmeticException("/ by zero");
		if(s1 < 0) s1 += MOD;
		return s1;
	}
	public final long[] invs(final int n) { // O(N)
		Util.positiveCheck(n);
		long inv[] = new long[n + 1];
		inv[1] = 1;
		for(int i = 2; i <= n; i ++) inv[i] = mul(inv[(int)(MOD % i)], (MOD - MOD / i));
		return inv;
	}

	private long g;
	public final long primitiveRoot() { // O(1) or O(M^(1/2))
		if(MOD == 2) return 1;
		if(MOD == 167772161) return 3;
		if(MOD == 469762049) return 3;
		if(MOD == 754974721) return 11;
		if(MOD == 998244353) return 3;
		if(g != 0) return g;

		// PairLL factor[] = factor(MOD - 1);
		// outer: for(g = 2; ; g ++) {
		// 	for(PairLL p : factor) if(pow(g, (MOD - 1) / p.a) == 1) continue outer;
		// 	return g;
		// }
		return 0;
	}

	private static final int MAX_FACT1 = 5_000_100;
	private static final int MAX_FACT2 = 500_100;
	private static final int MAX_FACT_MAP_SIZE = 100;
	private long fact[];
	private long invFact[];
	private boolean isFactPrepared = false;
	private final Map<Long, long[]> factMap = new HashMap<>();
	private final void prepareFact() {
		if(isFactPrepared) return;
		fact = new long[MAX_FACT1];
		invFact = new long[MAX_FACT1];
		fact[0] = 1;
		int maxIndex = Math.min(MAX_FACT1, (int)MOD);
		for(int i = 1; i < maxIndex; i ++) fact[i] = mul(fact[i - 1], i);
		invFact[maxIndex - 1] = inv(fact[maxIndex - 1]);
		for(int i = maxIndex - 1; i > 0; i --) invFact[i - 1] = mul(invFact[i], i);

		isFactPrepared = true;
	}

	public final long P(final long n, final long r) {
		if(!isFactPrepared) prepareFact();
		if(n < 0 || r < 0 || n < r) return 0;
		if(n < MAX_FACT1 && n < MOD) return mul(fact[(int)n], invFact[(int)(n - r)]);
		if(!factMap.containsKey(n)) {
			long largeFact[] = new long[MAX_FACT2];
			factMap.put(n, largeFact);
			Arrays.fill(largeFact, -1);
			largeFact[0] = 1;
		}
		long largeFact[] = factMap.get(n);
		if(r >= MAX_FACT2) {
			long ans = 1;
			for(long i = n - r + 1; i <= n; i ++) ans = mul(ans, i);
			return ans;
		}else {
			int i = (int)r;
			while(largeFact[i] < 0) i --;
			for(; i < r; i ++) largeFact[i + 1] = mul(largeFact[i], n - i);
			if(factMap.size() > MAX_FACT_MAP_SIZE) factMap.remove(n);
			return largeFact[(int)r];
		}
	}
	public final long C(long n, long r) {
		if(!isFactPrepared) prepareFact();
		if(n < 0) return mod(C(- n + r - 1, - n - 1) * ((r & 1) == 0 ? 1 : -1));
		if(r < 0 || n < r) return 0;
		r = Math.min(r, n - r);
		if(n < MOD) return mul(P(n, r), r < MAX_FACT1 ? invFact[(int)r] : inv(fact((int)r)));

		long ans = 1;
		while(n > 0) {
			final long n2 = n / MOD;
			final long r2 = r / MOD;
			ans = mul(ans, C(n - n2 * MOD, r - r2 * MOD));
			n = n2;
			r = r2;
		}
		return ans;
	}
	public final long H(final long n, final long r) { return C(n - 1 + r, r); }

	public final long sqrt(long x) {
		x = mod(x);
		long p = (MOD - 1) >> 1;
		if(pow(x, p) != 1) return -1;
		long q = MOD - 1;
		int m = 1;
		while(((q >>= 1) & 1) == 0) m ++;
		long z = 1;
		while(pow(z, p) == 1) z = (long)Math.floor(Math.random() * (MOD - 1)) + 1;
		long c = pow(z, q);
		long t = pow(x, q);
		long r = pow(x, (q + 1) >> 1);
		if(t == 0) return 0;
		m -= 2;
		while(t != 1) {
			long pows[] = new long[m + 1];
			pows[0] = t;
			for(int i = 0; i < m; i ++) pows[i + 1] = mul(pows[i], pows[i]);
			while(pows[m --] == 1) c = mul(c, c);
			r = mul(r, c);
			c = mul(c, c);
			t = mul(t, c);
		}
		return r;
	}
}
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
final class Mod107 extends Mod {
	public static final Mod107 md = new Mod107();
	public static final long MOD = 1_000_000_007;
	private Mod107() { super(MOD); }

	@Override
	public final long mod(long x) {
		if(0 <= x && x < MOD) return x;
		if(- MOD <= x && x < 0) return x + MOD;
		return (x %= MOD) < 0 ? x + MOD : x;
	}
	@Override
	public final long mul(long x, long y) {
		if(x >= 0 && x < MOD && y >= 0 && y < MOD) return (x * y) % MOD;
		x = mod(x);
		y = mod(y);
		return (x * y) % MOD;
	}
}
final class Mod998 extends Mod {
	public static final Mod998 md = new Mod998();
	public static final long MOD = 998_244_353;
	private Mod998() { super(MOD); }

	@Override
	public final long mod(long x) {
		if(0 <= x && x < MOD) return x;
		if(- MOD <= x && x < 0) return x + MOD;
		return (x %= MOD) < 0 ? x + MOD : x;
	}
	@Override
	public final long mul(long x, long y) {
		if(x >= 0 && x < MOD && y >= 0 && y < MOD) return (x * y) % MOD;
		x = mod(x);
		y = mod(y);
		return (x * y) % MOD;
	}
}
final class Mod754974721 extends Mod {
	public static final Mod754974721 md = new Mod754974721();
	public static final long MOD = 754_974_721;
	private Mod754974721() { super(MOD); }

	@Override
	public final long mod(long x) {
		if(0 <= x && x < MOD) return x;
		if(- MOD <= x && x < 0) return x + MOD;
		return (x %= MOD) < 0 ? x + MOD : x;
	}
	@Override
	public final long mul(long x, long y) {
		if(x >= 0 && x < MOD && y >= 0 && y < MOD) return (x * y) % MOD;
		x = mod(x);
		y = mod(y);
		return (x * y) % MOD;
	}
}
final class Mod167772161 extends Mod {
	public static final Mod167772161 md = new Mod167772161();
	public static final long MOD = 167_772_161;
	private Mod167772161() { super(MOD); }

	@Override
	public final long mod(long x) {
		if(0 <= x && x < MOD) return x;
		if(- MOD <= x && x < 0) return x + MOD;
		return (x %= MOD) < 0 ? x + MOD : x;
	}
	@Override
	public final long mul(long x, long y) {
		if(x >= 0 && x < MOD && y >= 0 && y < MOD) return (x * y) % MOD;
		x = mod(x);
		y = mod(y);
		return (x * y) % MOD;
	}
}
final class Mod469762049 extends Mod {
	public static final Mod469762049 md = new Mod469762049();
	public static final long MOD = 469_762_049;
	private Mod469762049() { super(MOD); }

	@Override
	public final long mod(long x) {
		if(0 <= x && x < MOD) return x;
		if(- MOD <= x && x < 0) return x + MOD;
		return (x %= MOD) < 0 ? x + MOD : x;
	}
	@Override
	public final long mul(long x, long y) {
		if(x >= 0 && x < MOD && y >= 0 && y < MOD) return (x * y) % MOD;
		x = mod(x);
		y = mod(y);
		return (x * y) % MOD;
	}
}