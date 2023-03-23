package library;

import library.FastIO;

class FftConvolution {
	public static final double[][] butterfly(double[][] f, boolean inv){ // O(NlogN)
		int n = f.length;
		if(n <= 1) return f;
		int bit = 0;
		int digit = 0;
		int n2 = n;
		while(n2 > 1) { n2 /= 2; digit ++; }
		for(int i = 1; i < n; i ++) {
			for(int j = digit - 1; j >= 0; j --) {
				if((bit >> j & 1) != 0) bit &= ~(1 << j);
				else { bit |= 1 << j; break; }
			}
			if(i < bit) {
				double tmp[] = {f[i][0], f[i][1]};
				f[i][0] = f[bit][0];
				f[i][1] = f[bit][1];
				f[bit][0] = tmp[0];
				f[bit][1] = tmp[1];
			}
		}
		for(int i = 1; i <= digit; i ++) {
			int len = 1 << i;
			double theta = 2.0 * Math.PI / len * (inv ? -1 : 1);
			double z[] = {Math.cos(theta), Math.sin(theta)};
			for(int j = 0; j < n; j += len) {
				double pow[] = {1, 0};
				for(int k = 0; k < len >> 1; k ++) {
					double f0[] = {f[j + k][0], f[j + k][1]};
					double f1[] = {f[j + k + (len >> 1)][0], f[j + k + (len >> 1)][1]};
					f[j + k + len / 2][0] = f0[0];
					f[j + k + len / 2][1] = f0[1];

					double a = f1[0] * pow[0] - f1[1] * pow[1];
					double b = f1[0] * pow[1] + f1[1] * pow[0];
					f1[0] = a;
					f1[1] = b;

					f[j + k][0] += f1[0];
					f[j + k][1] += f1[1];
					f[j + k + (len >> 1)][0] -= f1[0];
					f[j + k + (len >> 1)][1] -= f1[1];

					a = pow[0] * z[0] - pow[1] * z[1];
					b = pow[0] * z[1] + pow[1] * z[0];
					pow[0] = a;
					pow[1] = b;
				}
			}
		}
		return f;
	}

	// O((N_1+N_2)log(N_1+N_2))
	public static final long[] cnv(final long[] a, final long[] b) { return cnv(a, b, Math.max(0, a.length + b.length - 1)); }
	public static final long[] cnv(final long[] a, final long[] b, final int l) {
		FastIO.nonNegativeCheck(l);
		if(a.length == 0 || b.length == 0) return new long[l];
		int len = 1;
		while(len < a.length + b.length - 1) len <<= 1;
		double g[][] = new double[len][2];
		double h[][] = new double[len][2];
		for(int i = 0; i < a.length; i ++) {
			g[i][0] = a[i];
			g[i][1] = 0;
		}
		for(int i = 0; i < b.length; i ++) {
			h[i][0] = b[i];
			h[i][1] = 0;
		}
		g = butterfly(g, false);
		h = butterfly(h, false);
		double f[][] = new double[len][2];
		for(int i = 0; i < len; i ++) {
			f[i][0] = g[i][0] * h[i][0] - g[i][1] * h[i][1];
			f[i][1] = g[i][0] * h[i][1] + g[i][1] * h[i][0];
		}
		f = butterfly(f, true);
		long ans[] = new long[l];
		for(int i = 0; i < l; i ++) {
			ans[i] = Math.round(f[i][0] / len);
		}
		return ans;
	}
}