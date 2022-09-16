package library;

import java.io.*;

final class FastOutputStream {
	private static final int BUF_SIZE = 1 << 13;
	private final byte buf[] = new byte[BUF_SIZE];
	private final OutputStream out;
	private int count = 0;
	private static final byte TRUE_BYTES[] = {116, 114, 117, 101};
	private static final byte FALSE_BYTES[] = {102, 97, 108, 115, 101};
	private static final byte INT_MIN_BYTES[] = {45, 50, 49, 52, 55, 52, 56, 51, 54, 52, 56};
	private static final byte LONG_MIN_BYTES[] = {45, 57, 50, 50, 51, 51, 55, 50, 48, 51,
												54, 56, 53, 52, 55, 55, 53, 56, 48, 56};
	private static final int TOKEN_SIZE = 20;
	private final byte tokenBuf[] = new byte[TOKEN_SIZE];
	private static final int PRECISION = 10;
	public FastOutputStream(OutputStream out) {
		this.out = out;
	}
	public final void print() {  }
	public final void write(final byte b) {
		if(count == BUF_SIZE) internalFlush();
		buf[count ++] = b;
	}
	public final void print(final char c) { write((byte) c); }
	public final void print(final boolean b) {
		if(b) {
			if(count + 4 > BUF_SIZE) internalFlush();
			System.arraycopy(TRUE_BYTES, 0, buf, count, TRUE_BYTES.length);
			count += TRUE_BYTES.length;
		}else {
			if(count + 5 > BUF_SIZE) internalFlush();
			System.arraycopy(FALSE_BYTES, 0, buf, count, FALSE_BYTES.length);
			count += FALSE_BYTES.length;
		}
	}
	public final void print(int x) {
		if(count + 11 > BUF_SIZE) internalFlush();
		if(x == Integer.MIN_VALUE) {
			System.arraycopy(INT_MIN_BYTES, 0, buf, count, INT_MIN_BYTES.length);
			count += INT_MIN_BYTES.length;
			return;
		}
		if(x == 0) {
			buf[count ++] = 48;
			return;
		}
		if(x < 0) {
			buf[count ++] = 45;
			x = - x;
		}
		int tokenCount = 11;
		while(x > 0) {
			final int y = x / 10;
			tokenBuf[-- tokenCount] = (byte) (x - (y << 3) - (y << 1) + 48);
			x = y;
		}
		System.arraycopy(tokenBuf, tokenCount, buf, count, 11 - tokenCount);
		count += 11 - tokenCount;
	}
	public final void print(long x) {
		if(count + 20 > BUF_SIZE) internalFlush();
		if(x == Long.MIN_VALUE) {
			System.arraycopy(LONG_MIN_BYTES, 0, buf, count, LONG_MIN_BYTES.length);
			count += LONG_MIN_BYTES.length;
			return;
		}
		if(x == 0) {
			buf[count ++] = 48;
			return;
		}
		if(x < 0) {
			buf[count ++] = 45;
			x = - x;
		}
		int tokenCount = 20;
		while(x > 0) {
			final long y = x / 10;
			tokenBuf[-- tokenCount] = (byte) (x - (y << 3) - (y << 1) + 48);
			x = y;
		}
		System.arraycopy(tokenBuf, tokenCount, buf, count, 20 - tokenCount);
		count += 20 - tokenCount;
	}
	public final void print(final double d) { print(d, PRECISION); }
	public final void print(double d, final int precision) {
		if(count == BUF_SIZE) internalFlush();
		if(d < 0) {
			buf[count ++] = 45;
			d = - d;
		}
		d += Math.pow(10, - precision) / 2;
		print((long)d);
		if(precision == 0) return;
		if(count + precision + 1 > BUF_SIZE) internalFlush();
		buf[count ++] = 46;
		d -= (long)d;
		for(int i = 0; i < precision; i ++) {
			d *= 10;
			buf[count ++] = (byte)((int)d + 48);
			d -= (int) d;
		}
	}
	public final void print(final String s) { print(s.getBytes()); }
	public final void print(final Object o) { print(o.toString()); }
	public final void print(final byte[] a) {
		if(count + a.length > BUF_SIZE) internalFlush();
		System.arraycopy(a, 0, buf, count, a.length);
		count += a.length;
	}
	public final void print(final char[] a) {
		if(count + a.length > BUF_SIZE) internalFlush();
		for(int i = 0; i < a.length; i ++) buf[count + i] = (byte)a[i];
		count += a.length;
	}
	public final void println() { print('\n'); }
	public final void println(final char c) { print(c); println(); }
	public final void println(final boolean b) { print(b); println(); }
	public final void println(final int x) { print(x); println(); }
	public final void println(final long x) { print(x); println(); }
	public final void println(final double d) { print(d); println(); }
	public final void println(final double d, final int precision) { print(d, precision); println(); }
	public final void println(final String s) { print(s); println(); }
	public final void println(final Object o) { print(o); println(); }
	public final void println(final char[] a) { print(a); println(); }
	public final void println(final int[] a) {
		for(int i = 0; i < a.length; i ++) {
			print(a[i]);
			print(i == a.length - 1 ? '\n' : ' ');
		}
	}
	public final void println(final long[] a) {
		for(int i = 0; i < a.length; i ++) {
			print(a[i]);
			print(i == a.length - 1 ? '\n' : ' ');
		}
	}
	public final void println(final double[] a) {
		for(int i = 0; i < a.length; i ++) {
			print(a[i]);
			print(i == a.length - 1 ? '\n' : ' ');
		}
	}
	public final void println(final double[] a, final int precision) {
		for(int i = 0; i < a.length; i ++) {
			print(a[i], precision);
			print(i == a.length - 1 ? '\n' : ' ');
		}
	}
	public final void println(final String[] a) {
		for(int i = 0; i < a.length; i ++) {
			print(a[i]);
			print(i == a.length - 1 ? '\n' : ' ');
		}
	}
	public final void println(final Object[] a) {
		for(int i = 0; i < a.length; i ++) {
			print(a[i]);
			print(i == a.length - 1 ? '\n' : ' ');
		}
	}
	private final void internalFlush() {
		try {
			out.write(buf, 0, count);
			count = 0;
		}
		catch(IOException e) { e.printStackTrace(); }
	}
	public final void flush() {
		try {
			out.write(buf, 0, count);
			out.flush();
			count = 0;
		}
		catch(IOException e) { e.printStackTrace(); }
	}
	public final void close() {
		try { out.close(); }
		catch(IOException e) { e.printStackTrace(); }
	}
}