package library;

import java.util.*;
import library.FastIO;

abstract class AbstractGrids<Grid extends AbstractGrid> {
	public final int h, w;
	public final Grid[][] gs;
	public final Grid[] gi;

	protected abstract Grid[] createGrids(final int n);
	protected abstract Grid[][] create2dGrids(final int n, final int m);
	protected abstract Grid createGrid(final int i, final int j);

	public AbstractGrids(final int h, final int w) {
		FastIO.nonNegativeCheck(h);
		FastIO.nonNegativeCheck(w);
		this.h = h;
		this.w = w;
		gs = create2dGrids(h, w);
		gi = createGrids(h * w);
		for(int x = 0; x < h; x ++) {
			for(int y = 0; y < w; y ++) {
				gs[x][y] = createGrid(x, y);
				gi[gs[x][y].i] = gs[x][y];
			}
		}
	}

	public final Grid get(final int x, final int y) { return isValid(x, y, h, w) ? gs[x][y] : null; }
	public final Grid get(final int i) { return get(i / w, i % w); }

	public static final int dx[] = {0, -1, 1, 0, 0, -1, 1, -1, 1};
	public static final int dy[] = {0, 0, 0, -1, 1, -1, -1, 1, 1};
	public final Grid next(final int x, final int y, final int i) { return next(gs[x][y], i); }
	public final Grid next(final Grid g, final int i) { return get(g.x + dx[i], g.y + dy[i]); }

	public static final boolean isValid(final int x, final int y, final int h, final int w) { return x >= 0 && x < h && y >= 0 && y < w; }
	public static final boolean isValid(final AbstractGrid g) { return isValid(g.x, g.y, g.h, g.w); }
}

final class SimpleGrids extends AbstractGrids<SimpleGrid> {
	public SimpleGrids(final int h, final int w) { super(h, w); }
	@Override protected final SimpleGrid[] createGrids(final int n) { return new SimpleGrid[n]; }
	@Override protected final SimpleGrid[][] create2dGrids(final int n, final int m) { return new SimpleGrid[n][m]; }
	@Override protected final SimpleGrid createGrid(final int i, final int j) { return new SimpleGrid(i, j, h, w); }
}
final class BooleanGrids extends AbstractGrids<BooleanGrid> {
	boolean val[][] = null;
	public BooleanGrids(final int h, final int w) { super(h, w); }
	public BooleanGrids(final int h, final int w, final boolean[][] val) { super(h, w); this.val = val; }
	@Override protected final BooleanGrid[] createGrids(final int n) { return new BooleanGrid[n]; }
	@Override protected final BooleanGrid[][] create2dGrids(final int n, final int m) { return new BooleanGrid[n][m]; }
	@Override protected final BooleanGrid createGrid(final int i, final int j) { return new BooleanGrid(i, j, h, w, val == null ? false : val[i][j]); }
	public final void init(boolean[][] val) {
		this.val = val;
		for(int x = 0; x < h; x ++) for(int y = 0; y < w; y ++) gs[x][y].b = val[x][y];
	}
	public final BooleanGrid set(final int x, final int y, final boolean b) { if(AbstractGrids.isValid(x, y, h, w)) { gs[x][y].b = b; return gs[x][y]; }else return null; }
	public final BooleanGrid set(final int i, final boolean b) { return set(i / w, i % w, b); }
}
final class LongGrids extends AbstractGrids<LongGrid> {
	long val[][] = null;
	public LongGrids(final int h, final int w) { super(h, w); }
	public LongGrids(final int h, final int w, final long[][] val) { super(h, w); this.val = val; }
	@Override protected final LongGrid[] createGrids(final int n) { return new LongGrid[n]; }
	@Override protected final LongGrid[][] create2dGrids(final int n, final int m) { return new LongGrid[n][m]; }
	@Override protected final LongGrid createGrid(final int i, final int j) { return new LongGrid(i, j, h, w, val == null ? 0 : val[i][j]); }
	public final void init(long[][] val) {
		this.val = val;
		for(int x = 0; x < h; x ++) for(int y = 0; y < w; y ++) gs[x][y].v = val[x][y];
	}
	public final LongGrid set(final int x, final int y, final long v) { if(AbstractGrids.isValid(x, y, h, w)) { gs[x][y].v = v; return gs[x][y]; }else return null; }
	public final LongGrid set(final int i, final long v) { return set(i / w, i % w, v); }
}
final class TemplateGrids<T> extends AbstractGrids<TemplateGrid<T>> {
	T val[][] = null;
	public TemplateGrids(final int h, final int w) { super(h, w); }
	public TemplateGrids(final int h, final int w, final T[][] val) { super(h, w); this.val = val; }
	@Override @SuppressWarnings("unchecked") protected final TemplateGrid<T>[] createGrids(final int n) { return new TemplateGrid[n]; }
	@Override @SuppressWarnings("unchecked") protected final TemplateGrid<T>[][] create2dGrids(final int n, final int m) { return new TemplateGrid[n][m]; }
	@Override protected final TemplateGrid<T> createGrid(final int i, final int j) { return new TemplateGrid<T>(i, j, h, w, val == null ? null : val[i][j]); }
	public final void init(T[][] val) {
		this.val = val;
		for(int x = 0; x < h; x ++) for(int y = 0; y < w; y ++) gs[x][y].v = val[x][y];
	}
	public final TemplateGrid<T> set(final int x, final int y, final T v) { if(AbstractGrids.isValid(x, y, h, w)) { gs[x][y].v = v; return gs[x][y]; }else return null; }
	public final TemplateGrid<T> set(final int i, final T v) { return set(i / w, i % w, v); }
}

abstract class AbstractGrid {
	public final int x, y, h, w, i;

	public AbstractGrid(final int x, final int y, final int h, final int w) { this.x = x; this.y = y; this.h = h; this.w = w; this.i = x * w + y; }

	@Override public abstract String toString();
	@Override public abstract int hashCode();
	@Override public abstract boolean equals(final Object obj);
}
final class SimpleGrid extends AbstractGrid {
	public SimpleGrid(final int x, final int y, final int h, final int w) { super(x, y, h, w); }

	@Override public final String toString() { return "("+x+", "+y+")"; }
	@Override public final int hashCode() { return Objects.hash(x, y); }
	@Override
	public final boolean equals(final Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		SimpleGrid that = (SimpleGrid) obj;
		if(this.x != that.x) return false;
		if(this.y != that.y) return false;
		if(this.h != that.h) return false;
		if(this.w != that.w) return false;
		return true;
	}
}
final class BooleanGrid extends AbstractGrid {
	public boolean b;
	public BooleanGrid(final int x, final int y, final int h, final int w, final boolean b) { super(x, y, h, w); this.b = b; }

	@Override public final String toString() { return "("+x+", "+y+")="+FastIO.booleanToChar(b); }
	@Override public final int hashCode() { return Objects.hash(x, y, b); }
	@Override
	public final boolean equals(final Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		BooleanGrid that = (BooleanGrid) obj;
		if(this.x != that.x) return false;
		if(this.y != that.y) return false;
		if(this.h != that.h) return false;
		if(this.w != that.w) return false;
		if(this.b != that.b) return false;
		return true;
	}
}
final class LongGrid extends AbstractGrid implements Comparable<LongGrid> {
	public long v;
	public LongGrid(final int x, final int y, final int h, final int w, final long v) { super(x, y, h, w); this.v = v; }

	@Override public final String toString() { return "("+x+", "+y+")="+v; }
	@Override public final int hashCode() { return Objects.hash(x, y, h, w, v); }
	@Override
	public final boolean equals(final Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		LongGrid that = (LongGrid) obj;
		if(this.x != that.x) return false;
		if(this.y != that.y) return false;
		if(this.h != that.h) return false;
		if(this.w != that.w) return false;
		if(this.v != that.v) return false;
		return true;
	}
	@Override
	public final int compareTo(final LongGrid that) {
		int c = Long.compare(this.v, that.v);
		if(c == 0) c = Integer.compare(this.x, that.x);
		if(c == 0) c = Integer.compare(this.y, that.y);
		return c;
	}
}
final class TemplateGrid<T> extends AbstractGrid {
	public T v;
	public TemplateGrid(final int x, final int y, final int h, final int w, final T v) { super(x, y, h, w); this.v = v; }

	@Override public final String toString() { return "("+x+", "+y+")="+v.toString(); }
	@Override public final int hashCode() { return Objects.hash(x, y, v); }
	@Override
	public final boolean equals(final Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		TemplateGrid that = (TemplateGrid) obj;
		if(this.x != that.x) return false;
		if(this.y != that.y) return false;
		if(this.h != that.h) return false;
		if(this.w != that.w) return false;
		if(!this.v.equals(that.v)) return false;
		return true;
	}
}