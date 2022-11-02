package library;

import java.util.*;
import library.SimpleUtil;
import library.Util;
import library.Pair;
import library.Mod;

class ExtendedMath {
	long[] slideMin(long[] array, int len) { // O(N) N=len
		SimpleUtil.nonNegativeCheck(len);
		Deque<Integer> s = new ArrayDeque<>();
		long slideMin[] = new long[array.length - len + 1];
		for(int i = 0; i < array.length; i ++) {
			while(!s.isEmpty() && array[s.getLast()] >= array[i]) s.removeLast();
			s.addLast(i);
			while(!s.isEmpty() && s.getFirst() + len <= i) s.removeFirst();
			slideMin[Math.max(0, i - len + 1)] = array[s.getFirst()];
		}
		return slideMin;
	}
	// O(NlogN)
	int[] lis(long[] a) { return lis(a, true); }
	int[] lis(long[] a, boolean increasing) {
		int len = a.length;
		long increase[] = new long[len];
		Arrays.fill(increase, increasing ? SimpleUtil.INF : - SimpleUtil.INF);
		int lis[] = new int[len];
		for(int i = 0; i < len; i ++) {
			lis[i] = Util.cntBS(increase, a[i], increasing, !increasing, false) + 1;
			increase[lis[i] - 1] = a[i];
		}
		return lis;
	}

	private static final int signum(long x) { return x == 0 ? 0 : x > 0 ? 1 : -1; }
	public static final int quadrant[][] = {{6, 5, 4}, {7, 0, 3}, {8, 1, 2}};
	public static final int quadrant2[][] = {{0, 8, 7}, {1, 4, 6}, {2, 3, 5}};
	public static final Comparator<long[]> argC = (sort1, sort2) -> {
		int c = Integer.compare(quadrant[signum(sort1[0]) + 1][signum(sort1[1]) + 1],
								quadrant[signum(sort2[0]) + 1][signum(sort2[1]) + 1]);
		if(c == 0) c = Long.compare(sort1[1] * sort2[0], sort1[0] * sort2[1]);
		if(c == 0) c = Long.compare(Math.abs(sort1[0]) + Math.abs(sort2[1]), Math.abs(sort2[0]) + Math.abs(sort2[1]));
		return c;
	};
	public static final Comparator<long[]> argC2 = (sort1, sort2) -> {
		int c = Integer.compare(quadrant2[signum(sort1[0]) + 1][signum(sort1[1]) + 1],
								quadrant2[signum(sort2[0]) + 1][signum(sort2[1]) + 1]);
		if(c == 0) c = Long.compare(sort1[1] * sort2[0], sort1[0] * sort2[1]);
		if(c == 0) c = Long.compare(Math.abs(sort1[0]) + Math.abs(sort2[1]), Math.abs(sort2[0]) + Math.abs(sort2[1]));
		return c;
	};

	public static final long[] mul(final Mod md, final long[][] mat1, final long[] mat2) { // O(N^2)
		long mul[] = new long[mat2.length];
		for(int i = 0; i < mul.length; i ++) {
			for(int j = 0; j < mat2.length; j ++) {
				mul[i] = md.add(mul[i], md.mul(mat1[i][j], mat2[j]));
			}
		}
		return mul;
	}
	public static final long[][] mul(final Mod md, final long[][] mat1, final long[][] mat2) { // O(N^3)
		long mul[][] = new long[mat1.length][mat2[0].length];
		for(int i = 0; i < mul.length; i ++) {
			for(int j = 0; j < mul[i].length; j ++) {
				for(int k = 0; k < mat2.length; k ++) {
					mul[i][j] = md.add(mul[i][j], md.mul(mat1[i][k], mat2[k][j]));
				}
			}
		}
		return mul;
	}
	public static final long[][] pow(final Mod md, final long[][] mat, long y) { // O(N^3logY)
		SimpleUtil.nonNegativeCheck(y);
		int num = mat.length;
		long[][] ans = new long[num][num];
		for(int i = 0; i < num; i ++) ans[i][i] = 1;
		long[][] x = new long[num][num];
		for(int i = 0; i < num; i ++) for(int j = 0; j < num; j ++) x[i][j] = mat[i][j];
		for(; y > 0; y /= 2) {
			if(y % 2 != 0) ans = mul(md, ans, x);
			x = mul(md, x, x);
		}
		return ans;
	}

	// sum in [0,n) of floor((ai+b)/m)
	public static final long floorSum(final long n, final long m, long a, long b) { // O(log(N+M+A+B))
		SimpleUtil.nonNegativeCheck(n);
		SimpleUtil.positiveCheck(m);
		SimpleUtil.nonNegativeCheck(a);
		SimpleUtil.nonNegativeCheck(b);
		long ans = 0;
		if(a >= m) {
			ans += (n - 1) * n * (a / m) / 2;
			a %= m;
		}
		if(b >= m) {
			ans += n * (b / m);
			b %= m;
		}
	
		long y_max = (a * n + b) / m, x_max = (y_max * m - b);
		if(y_max == 0) return ans;
		ans += (n - (x_max + a - 1) / a) * y_max;
		ans += floorSum(y_max, a, m, (a - x_max % a) % a);
		return ans;
	}

	// O(RC^2)
	public static final int gaussJordan(final Mod md, final long[][] mat) { return gaussJordan(md, mat, false); }
	public static final int gaussJordan(final Mod md, final long[][] mat, final boolean isExtended) {
		md.mod(mat);
		int row = mat.length;
		int col = mat[0].length;
		for(int r = 0; r < row; r ++) SimpleUtil.assertion(mat[r].length == col);
		int rank = 0;
		for(int c = 0; c < col; c ++) {
			if(isExtended && c == col - 1) continue;
			int pivot = -1;
			for(int r = rank; r < row; r ++) if(mat[r][c] != 0) { pivot = r; break; }
			if(pivot == -1) continue;
			for(int c2 = 0; c2 < col; c2 ++) {
				long tmp = mat[pivot][c2];
				mat[pivot][c2] = mat[rank][c2];
				mat[rank][c2] = tmp;
			}
			long inv = md.inv(mat[rank][c]);
			for(int c2 = 0; c2 < col; c2 ++) mat[rank][c2] = md.mul(mat[rank][c2], inv);
			for(int r = 0; r < row; r ++) {
				if(r != rank && mat[r][c] != 0) {
					long fac = mat[r][c];
					for(int c2 = 0; c2 < col; c2 ++) {
						mat[r][c2] = md.sub(mat[r][c2], md.mul(mat[rank][c2], fac));
					}
				}
			}
			rank ++;
		}
		return rank;
	}
	// O(RC^2)
	// solve ax=b; a:=(R,C), x:=(C,1), b:=(R,1)
	public static final int linearEquation(final Mod md, final long[][] a, final long[] b, final long[] ans) {
		int row = a.length;
		int col = a[0].length;
		for(int r = 0; r < row; r ++) SimpleUtil.assertion(a[r].length == col);
		SimpleUtil.assertion(b.length == row);
	
		long mat[][] = new long[row][col + 1];
		for(int r = 0; r < row; r ++) {
			for(int c = 0; c < col; c ++) {
				mat[r][c] = a[r][c];
			}
			mat[r][col] = b[r];
		}
	
		int rank = gaussJordan(md, mat, true);
		for(int r = rank; r < row; r ++) if(mat[r][col] != 0) return -1;
		for(int r = 0; r < rank; r ++) ans[r] = mat[r][col];
		return rank;
	}
	public static final class BitMatrix extends ArrayList<BitSet> {
		int row;
		int col;
		BitMatrix(int row, int col) {
			SimpleUtil.nonNegativeCheck(row);
			SimpleUtil.nonNegativeCheck(col);
			this.row = row;
			this.col = col;
			for(int r = 0; r < row; r ++) add(new BitSet(col));
		}
		
		public final boolean get(int r, int c) { return get(r).get(c); }
		public final void set(int r, int c) { get(r).set(c); }
	}
	// O(RC)
	public static final int bitGaussJordan(final BitMatrix mat) { return bitGaussJordan(mat, false); }
	public static final int bitGaussJordan(final BitMatrix mat, final boolean isExtended) {
		int row = mat.row;
		int col = mat.col;
		int rank = 0;
		for(int c = 0; c < col; c ++) {
			if(isExtended && c == col - 1) continue;
			int pivot = -1;
			for(int r = rank; r < row; r ++) if(mat.get(r, c)) { pivot = r; break; }
			if(pivot == -1) continue;
			{
				BitSet tmp = mat.get(pivot);
				mat.set(pivot, mat.get(rank));
				mat.set(rank, tmp);
			}
			for(int r = 0; r < row; r ++) {
				if(r != rank && mat.get(r, c)) mat.get(r).xor(mat.get(rank));
			}
			rank ++;
		}
		return rank;
	}
	// O(RC)
	// solve ax=b; a:=(R,C), x:=(C,1), b:=(R,1)
	public static final int bitLinearEquation(final boolean[][] a, final boolean[] b, final boolean[] ans) {
		int row = a.length;
		int col = a[0].length;
		for(int r = 0; r < row; r ++) SimpleUtil.assertion(a[r].length == col);
		SimpleUtil.assertion(b.length == row);
	
		BitMatrix mat = new BitMatrix(row, col + 1);
		for(int r = 0; r < row; r ++) {
			for(int c = 0; c < col; c ++) if(a[r][c]) mat.set(r, c);
			if(b[r]) mat.set(r, col);
		}
	
		int rank = bitGaussJordan(mat, true);
		for(int r = rank; r < row; r ++) if(mat.get(r, col)) return -1;
		for(int r = 0; r < rank; r ++) ans[r] = mat.get(r, col);
		return rank;
	}
	// O(RC)
	public static final int longBitGaussJordan(final long[] mat) { return longBitGaussJordan(mat, false); }
	public static final int longBitGaussJordan(final long[] mat, final boolean isExtended) {
		int row = mat.length;
		long base[] = new long[row];
		int rank = 0;
		for(int r = 0; r < row; r ++) {
			long v = mat[r];
			for(int e = 0; e < rank; e ++) v = Math.min(v, v ^ base[e]);
			if(v > 0) base[rank ++] = v;
		}
		Arrays.sort(base);
		for(int i = 0; i < row; i ++) mat[row - i - 1] = base[i];
		return rank;
	}

	// return (g,x) s.t. ax%mod=g=gcd(a,mod) && x>=0
	public static final Pair.LL invGcd(long a, long mod) { // O(loglcm(a,mod))
		SimpleUtil.positiveCheck(mod, "mod");
		Pair.LL s = new Pair.LL(mod, 0);
		Pair.LL t = new Pair.LL(a, 1);
		while(t.a > 0) {
			long tmp = s.a / t.a;
			Pair.LL u = new Pair.LL(s.a - t.a * tmp, s.b - t.b * tmp);
			s = t;
			t = u;
		}
		if(s.b < 0) s.b += mod / s.a;
		return s;
	}
	// return (g,x,y) s.t. ax+by=g=gcd(a,b) && |x|+|y| is minimal (primarily) && x<=y (secondarily)
	public static final Util.TupleLLL extGcd(long a, long b) { // O(loglcm(a,b))
		Util.TupleLLL s = new Util.TupleLLL(a, 1, 0);
		Util.TupleLLL t = new Util.TupleLLL(b, 0, 1);
		while(t.a > 0) {
			long tmp = s.a / t.a;
			Util.TupleLLL u = new Util.TupleLLL(s.a - t.a * tmp, s.b - t.b * tmp, s.c - t.c * tmp);
			s = t;
			t = u;
		}
		return s;
	}
	// return (x, lcm(p.b)) s.t. x%p.b=p.a && x>=0 if exists otherwise null
	public static final Pair.LL chineseRem(Pair.LL[] p) { // O(Nloglcm(ps.a))
		for(Pair.LL ele : p) SimpleUtil.positiveCheck(ele.b);
		int num = p.length;
		Pair.LL ans = new Pair.LL(0, 1);
		for(Pair.LL crt : p) {
			ans = chineseRem(ans, crt);
			if(ans == null) return null;
		}
		return ans;
	}
	// return (x,lcm(p1.b,p2.b)) s.t. x%p1.b=p1.a && x%p2.b=p2.a && x>=0 if exists otherwise null
	public static final Pair.LL chineseRem(Pair.LL p1, Pair.LL p2) { // O(loglcm(p1.a,p2.a))
		SimpleUtil.positiveCheck(p1.b);
		SimpleUtil.positiveCheck(p2.b);
		Util.TupleLLL ans = extGcd(p1.b, p2.b);
		p1.a = new ArbitraryMod(p1.b).mod(p1.a);
		p2.a = new ArbitraryMod(p2.b).mod(p2.a);
		if((p2.a - p1.a) % ans.a != 0) return null;
		long lcm = p1.b / ans.a * p2.b;
		long tmp = new ArbitraryMod(p2.b / ans.a).mul((p2.a - p1.a) / ans.a, ans.b);
		Mod md = new ArbitraryMod(lcm);
		return new Pair.LL(md.add(p1.a, md.mul(p1.b, tmp)), lcm);
	}
	// requirement: p.b is prime
	// return x%mod s.t. x%p.b=p.a && x>=0
	public static final long garner(Pair.LL[] p, long mod) { // O(N^2+Nlogmax(p.a)))
		SimpleUtil.positiveCheck(mod, "mod");
		for(Pair.LL ele : p) SimpleUtil.positiveCheck(ele.b);
		Pair.LL p2[] = new Pair.LL[p.length + 1];
		for(int i = 0; i < p.length; i ++) p2[i] = p[i];
		p = p2;
		p[p.length - 1] = new Pair.LL(0, mod);
		long coffs[] = new long[p.length];
		Arrays.fill(coffs, 1);
		long constants[] = new long[p.length];
		Mod md[] = new ArbitraryMod[p.length];
		for(int i = 0; i < p.length; i ++) md[i] = new ArbitraryMod(p[i].b);
		for(int i = 0; i < p.length - 1; i ++) {
			long v = md[i].mul(p[i].a - constants[i], md[i].inv(coffs[i]));
			for(int j = i + 1; j < p.length; j ++) {
				constants[j] = md[j].mod(constants[j] + md[j].mul(coffs[j], v));
				coffs[j] = md[j].mul(coffs[j], p[i].b);
			}
		}
		return constants[p.length - 1];
	}
}