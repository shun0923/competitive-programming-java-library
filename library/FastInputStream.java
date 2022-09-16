import java.util.*;
import java.io.*;

final class FastInputStream {
	private static final int BUF_SIZE = 1 << 14;
	private final InputStream in;
	private final byte buf[] = new byte[BUF_SIZE];
	private int pos = 0;
	private int count = 0;
	private static final int TOKEN_SIZE = 1 << 20;
	private final byte tokenBuf[] = new byte[TOKEN_SIZE];

	public FastInputStream(final InputStream in) {
		this.in = in;
	}
	private final void readBuf() {
		pos = 0;
		try { count = in.read(buf); }
		catch(IOException e) { e.printStackTrace(); }
	}
	private final boolean hasNextByte() {
		if(pos < count) return true;
		readBuf();
		return count > 0;
	}
	private final byte read() { if(hasNextByte()) return buf[pos ++]; else throw new NoSuchElementException(); }
	private final boolean isPrintableChar(final byte c) { return 33 <= c && c <= 126; }
	private final boolean isNumber(final byte c) { return 48 <= c && c <= 57; }
	private final void skipUnprintable() {
		while(true) {
			for(int i = pos; i < count; i ++) {
				if(isPrintableChar(buf[i])) { pos = i; return; }
			}
			readBuf();
			if(count <= 0) throw new NoSuchElementException();
		}
	}
	private final boolean readEOL() {
		if(!hasNextByte()) return true;
		if(buf[pos] == 13) {
			pos ++;
			if(hasNextByte() && buf[pos] == 10) pos ++;
			return true;
		}
		if(buf[pos] == 10) {
			pos ++;
			return true;
		}
		return false;
	}

	public final char nextChar() {
		skipUnprintable();
		return (char)buf[pos ++];
	}
	public final String next() {
		skipUnprintable();
		int tokenCount = 0;
		outer: while(count > 0) {
			for(int i = pos; i < count; i ++) {
				final byte b = buf[i];
				if(!isPrintableChar(b)) { pos = i; break outer; }
				tokenBuf[tokenCount ++] = b;
			}
			readBuf();
		}
		return new String(tokenBuf, 0, tokenCount);
	}
	public final String nextLine() {
		readEOL();
		if(!hasNextByte()) throw new NoSuchElementException();
		int tokenCount = 0;
		while(!readEOL()) tokenBuf[tokenCount ++] = read();
		return new String(tokenBuf, 0, tokenCount);
	}
	public final int nextInt() {
		skipUnprintable();
		int n = 0;
		boolean minus = false;
		if(buf[pos] == 45) {
			minus = true;
			pos ++;
			if(!hasNextByte() || !isNumber(buf[pos])) throw new InputMismatchException();
		}
		outer: while(count > 0) {
			for(int i = pos; i < count; i ++) {
				final byte b = buf[i];
				if(!isPrintableChar(b)) { pos = i; break outer; }
				if(!isNumber(b)) throw new InputMismatchException();
				if(minus) {
					if(n < - 214748364) throw new ArithmeticException("int overflow");
					if(n == - 214748364 && b > 56) throw new ArithmeticException("int overflow");
					n = (n << 3) + (n << 1) + 48 - b;
				}else {
					if(n > 214748364) throw new ArithmeticException("int overflow");
					if(n == 214748364 && b >= 56) throw new ArithmeticException("int overflow");
					n = (n << 3) + (n << 1) - 48 + b;
				}
			}
			readBuf();
		}
		return n;
	}
	public final long nextLong() {
		skipUnprintable();
		long n = 0;
		boolean minus = false;
		if(buf[pos] == 45) {
			minus = true;
			pos ++;
			if(!hasNextByte() || !isNumber(buf[pos])) throw new InputMismatchException();
		}
		outer: while(count > 0) {
			for(int i = pos; i < count; i ++) {
				final byte b = buf[i];
				if(!isPrintableChar(b)) { pos = i; break outer; }
				if(!isNumber(b)) throw new InputMismatchException();
				if(minus) {
					if(n < - 922337203685477580l) throw new ArithmeticException("long overflow");
					if(n == - 922337203685477580l && b > 56) throw new ArithmeticException("long overflow");
					n = (n << 3) + (n << 1) + 48 - b;
				}else {
					if(n > 922337203685477580l) throw new ArithmeticException("long overflow");
					if(n == 922337203685477580l && b >= 56) throw new ArithmeticException("long overflow");
					n = (n << 3) + (n << 1) - 48 + b;
				}
			}
			readBuf();
		}
		return n;
	}
	public final double nextDouble() { return Double.parseDouble(next()); }

	public final void close() {
		try { in.close(); }
		catch(IOException e) { e.printStackTrace(); }
	}
}