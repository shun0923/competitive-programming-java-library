// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_1_A

package library;

import java.util.*;
import library.Solver;
import library.Fps;
import library.Convolution;

public class Fps_random_test extends Solver {
	public static void main(final String[] args) { main(args, new Fps_random_test()); }

	public void solve() {
		Random rnd = new Random(0);
		FpsOperator op = new CnvFpsOperator(Convolution998.cnv);
		for(int i = 0; i < 100; i ++) {
			checkMul(op, randomFps(op, rnd, rnd.nextInt(5000)), randomFps(op, rnd, rnd.nextInt(5000)));
			checkInv(op, randomFps(op, rnd, rnd.nextInt(5000)));
			checkDiv(op, randomFps(op, rnd, rnd.nextInt(5000)), randomFps(op, rnd, rnd.nextInt(5000)));
			checkPow(op, randomFps(op, rnd, rnd.nextInt(10)), rnd.nextLong());
			checkExp(op, randomFps(op, rnd, rnd.nextInt(5000)));
			checkSqrt(op, randomFps(op, rnd, rnd.nextInt(5000)));
		}
		for(int i = 0; i < 100; i ++) {
			checkInv(op, randomFps(op, rnd, i));
			for(int n = - 100; n < 100; n ++) checkPow(op, randomFps(op, rnd, i), n);
			checkExp(op, randomFps(op, rnd, i));
			checkSqrt(op, randomFps(op, rnd, i));
			for(int j = 0; j < 100; j ++) {
				checkMul(op, randomFps(op, rnd, i), randomFps(op, rnd, j));
				checkDiv(op, randomFps(op, rnd, i), randomFps(op, rnd, j));
			}
		}
		prtln("Hello World");
	}
	public Fps randomFps(FpsOperator op, Random rnd, int n) {
		Fps f = new Fps(op, n);
		for(int i = 0; i < n; i ++) f.set(i, op.md.mod(rnd.nextLong()));
		return f;
	}
	public void check(Fps f, Fps g) {
		assertion(f == g || f.equals(g));
	}
	public void checkMul(FpsOperator op, Fps f, Fps g) {
		check(op.mul(f, g), op.naiveMul(f, g));
	}
	public void checkInv(FpsOperator op, Fps f) {
		check(op.inv(f), op.naiveInv(f));
	}
	public void checkDiv(FpsOperator op, Fps f, Fps g) {
		check(op.div(f, g), op.naiveDiv(f, g));
	}
	public void checkPow(FpsOperator op, Fps f, long n) {
		check(op.pow(f, n), op.naivePow(f, n));
		check(op.pow(f, n), op.binaryPow(f, n));
	}
	public void checkExp(FpsOperator op, Fps f) {
		check(op.exp(f), op.naiveExp(f));
	}
	public void checkSqrt(FpsOperator op, Fps f) {
		check(op.sqrt(f), op.naiveSqrt(f));
	}
}