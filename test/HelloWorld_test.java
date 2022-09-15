// verification-helper: PROBLEM https://onlinejudge.u-aizu.ac.jp/courses/lesson/2/ITP1/1/ITP1_1_A
package test;
import library.Main;

public class HelloWorld_test extends Main {
	public static void main(final String[] args) {
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { e.printStackTrace(); System.exit(1); });
		new Thread(null, new HelloWorld_test(), "", 1 << 31).start();
	}

	@Override
	public void solve() {
		System.out.println("HelloWorld");
	}
}