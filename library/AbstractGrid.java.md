---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/FastIO.java
    title: library/FastIO.java
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: library/GridBfs.java
    title: library/GridBfs.java
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/GridBfs_test.java
    title: library/GridBfs_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n          \
    \         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 466, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 571, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.*;\nimport library.FastIO;\n\nabstract\
    \ class AbstractGrids<Grid extends AbstractGrid> {\n\tpublic final int h, w;\n\
    \tpublic final Grid[][] gs;\n\tpublic final Grid[] gi;\n\n\tprotected abstract\
    \ Grid[] createGrids(final int n);\n\tprotected abstract Grid[][] create2dGrids(final\
    \ int n, final int m);\n\tprotected abstract Grid createGrid(final int i, final\
    \ int j);\n\n\tpublic AbstractGrids(final int h, final int w) {\n\t\tFastIO.nonNegativeCheck(h);\n\
    \t\tFastIO.nonNegativeCheck(w);\n\t\tthis.h = h;\n\t\tthis.w = w;\n\t\tgs = create2dGrids(h,\
    \ w);\n\t\tgi = createGrids(h * w);\n\t\tfor(int x = 0; x < h; x ++) {\n\t\t\t\
    for(int y = 0; y < w; y ++) {\n\t\t\t\tgs[x][y] = createGrid(x, y);\n\t\t\t\t\
    gi[gs[x][y].i] = gs[x][y];\n\t\t\t}\n\t\t}\n\t}\n\n\tpublic final Grid get(final\
    \ int x, final int y) { return isValid(x, y, h, w) ? gs[x][y] : null; }\n\tpublic\
    \ final Grid get(final int i) { return get(i / w, i % w); }\n\n\tpublic static\
    \ final int dx[] = {0, -1, 1, 0, 0, -1, 1, -1, 1};\n\tpublic static final int\
    \ dy[] = {0, 0, 0, -1, 1, -1, -1, 1, 1};\n\tpublic final Grid next(final int x,\
    \ final int y, final int i) { return next(gs[x][y], i); }\n\tpublic final Grid\
    \ next(final Grid g, final int i) { return get(g.x + dx[i], g.y + dy[i]); }\n\n\
    \tpublic static final boolean isValid(final int x, final int y, final int h, final\
    \ int w) { return x >= 0 && x < h && y >= 0 && y < w; }\n\tpublic static final\
    \ boolean isValid(final AbstractGrid g) { return isValid(g.x, g.y, g.h, g.w);\
    \ }\n}\n\nfinal class SimpleGrids extends AbstractGrids<SimpleGrid> {\n\tpublic\
    \ SimpleGrids(final int h, final int w) { super(h, w); }\n\t@Override protected\
    \ final SimpleGrid[] createGrids(final int n) { return new SimpleGrid[n]; }\n\t\
    @Override protected final SimpleGrid[][] create2dGrids(final int n, final int\
    \ m) { return new SimpleGrid[n][m]; }\n\t@Override protected final SimpleGrid\
    \ createGrid(final int i, final int j) { return new SimpleGrid(i, j, h, w); }\n\
    }\nfinal class BooleanGrids extends AbstractGrids<BooleanGrid> {\n\tboolean val[][]\
    \ = null;\n\tpublic BooleanGrids(final int h, final int w) { super(h, w); }\n\t\
    public BooleanGrids(final int h, final int w, final boolean[][] val) { super(h,\
    \ w); this.val = val; }\n\t@Override protected final BooleanGrid[] createGrids(final\
    \ int n) { return new BooleanGrid[n]; }\n\t@Override protected final BooleanGrid[][]\
    \ create2dGrids(final int n, final int m) { return new BooleanGrid[n][m]; }\n\t\
    @Override protected final BooleanGrid createGrid(final int i, final int j) { return\
    \ new BooleanGrid(i, j, h, w, val == null ? false : val[i][j]); }\n\tpublic final\
    \ void init(boolean[][] val) {\n\t\tthis.val = val;\n\t\tfor(int x = 0; x < h;\
    \ x ++) for(int y = 0; y < w; y ++) gs[x][y].b = val[x][y];\n\t}\n\tpublic final\
    \ BooleanGrid set(final int x, final int y, final boolean b) { if(AbstractGrids.isValid(x,\
    \ y, h, w)) { gs[x][y].b = b; return gs[x][y]; }else return null; }\n\tpublic\
    \ final BooleanGrid set(final int i, final boolean b) { return set(i / w, i %\
    \ w, b); }\n}\nfinal class LongGrids extends AbstractGrids<LongGrid> {\n\tlong\
    \ val[][] = null;\n\tpublic LongGrids(final int h, final int w) { super(h, w);\
    \ }\n\tpublic LongGrids(final int h, final int w, final long[][] val) { super(h,\
    \ w); this.val = val; }\n\t@Override protected final LongGrid[] createGrids(final\
    \ int n) { return new LongGrid[n]; }\n\t@Override protected final LongGrid[][]\
    \ create2dGrids(final int n, final int m) { return new LongGrid[n][m]; }\n\t@Override\
    \ protected final LongGrid createGrid(final int i, final int j) { return new LongGrid(i,\
    \ j, h, w, val == null ? 0 : val[i][j]); }\n\tpublic final void init(long[][]\
    \ val) {\n\t\tthis.val = val;\n\t\tfor(int x = 0; x < h; x ++) for(int y = 0;\
    \ y < w; y ++) gs[x][y].v = val[x][y];\n\t}\n\tpublic final LongGrid set(final\
    \ int x, final int y, final long v) { if(AbstractGrids.isValid(x, y, h, w)) {\
    \ gs[x][y].v = v; return gs[x][y]; }else return null; }\n\tpublic final LongGrid\
    \ set(final int i, final long v) { return set(i / w, i % w, v); }\n}\nfinal class\
    \ TemplateGrids<T> extends AbstractGrids<TemplateGrid<T>> {\n\tT val[][] = null;\n\
    \tpublic TemplateGrids(final int h, final int w) { super(h, w); }\n\tpublic TemplateGrids(final\
    \ int h, final int w, final T[][] val) { super(h, w); this.val = val; }\n\t@Override\
    \ @SuppressWarnings(\"unchecked\") protected final TemplateGrid<T>[] createGrids(final\
    \ int n) { return new TemplateGrid[n]; }\n\t@Override @SuppressWarnings(\"unchecked\"\
    ) protected final TemplateGrid<T>[][] create2dGrids(final int n, final int m)\
    \ { return new TemplateGrid[n][m]; }\n\t@Override protected final TemplateGrid<T>\
    \ createGrid(final int i, final int j) { return new TemplateGrid<T>(i, j, h, w,\
    \ val == null ? null : val[i][j]); }\n\tpublic final void init(T[][] val) {\n\t\
    \tthis.val = val;\n\t\tfor(int x = 0; x < h; x ++) for(int y = 0; y < w; y ++)\
    \ gs[x][y].v = val[x][y];\n\t}\n\tpublic final TemplateGrid<T> set(final int x,\
    \ final int y, final T v) { if(AbstractGrids.isValid(x, y, h, w)) { gs[x][y].v\
    \ = v; return gs[x][y]; }else return null; }\n\tpublic final TemplateGrid<T> set(final\
    \ int i, final T v) { return set(i / w, i % w, v); }\n}\n\nabstract class AbstractGrid\
    \ {\n\tpublic final int x, y, h, w, i;\n\n\tpublic AbstractGrid(final int x, final\
    \ int y, final int h, final int w) { this.x = x; this.y = y; this.h = h; this.w\
    \ = w; this.i = x * w + y; }\n\n\t@Override public abstract String toString();\n\
    \t@Override public abstract int hashCode();\n\t@Override public abstract boolean\
    \ equals(final Object obj);\n}\nfinal class SimpleGrid extends AbstractGrid {\n\
    \tpublic SimpleGrid(final int x, final int y, final int h, final int w) { super(x,\
    \ y, h, w); }\n\n\t@Override public final String toString() { return \"(\"+x+\"\
    , \"+y+\")\"; }\n\t@Override public final int hashCode() { return Objects.hash(x,\
    \ y); }\n\t@Override\n\tpublic final boolean equals(final Object obj) {\n\t\t\
    if(this == obj) return true;\n\t\tif(obj == null) return false;\n\t\tif(this.getClass()\
    \ != obj.getClass()) return false;\n\t\tSimpleGrid that = (SimpleGrid) obj;\n\t\
    \tif(this.x != that.x) return false;\n\t\tif(this.y != that.y) return false;\n\
    \t\tif(this.h != that.h) return false;\n\t\tif(this.w != that.w) return false;\n\
    \t\treturn true;\n\t}\n}\nfinal class BooleanGrid extends AbstractGrid {\n\tpublic\
    \ boolean b;\n\tpublic BooleanGrid(final int x, final int y, final int h, final\
    \ int w, final boolean b) { super(x, y, h, w); this.b = b; }\n\n\t@Override public\
    \ final String toString() { return \"(\"+x+\", \"+y+\")=\"+FastIO.booleanToChar(b);\
    \ }\n\t@Override public final int hashCode() { return Objects.hash(x, y, b); }\n\
    \t@Override\n\tpublic final boolean equals(final Object obj) {\n\t\tif(this ==\
    \ obj) return true;\n\t\tif(obj == null) return false;\n\t\tif(this.getClass()\
    \ != obj.getClass()) return false;\n\t\tBooleanGrid that = (BooleanGrid) obj;\n\
    \t\tif(this.x != that.x) return false;\n\t\tif(this.y != that.y) return false;\n\
    \t\tif(this.h != that.h) return false;\n\t\tif(this.w != that.w) return false;\n\
    \t\tif(this.b != that.b) return false;\n\t\treturn true;\n\t}\n}\nfinal class\
    \ LongGrid extends AbstractGrid implements Comparable<LongGrid> {\n\tpublic long\
    \ v;\n\tpublic LongGrid(final int x, final int y, final int h, final int w, final\
    \ long v) { super(x, y, h, w); this.v = v; }\n\n\t@Override public final String\
    \ toString() { return \"(\"+x+\", \"+y+\")=\"+v; }\n\t@Override public final int\
    \ hashCode() { return Objects.hash(x, y, h, w, v); }\n\t@Override\n\tpublic final\
    \ boolean equals(final Object obj) {\n\t\tif(this == obj) return true;\n\t\tif(obj\
    \ == null) return false;\n\t\tif(this.getClass() != obj.getClass()) return false;\n\
    \t\tLongGrid that = (LongGrid) obj;\n\t\tif(this.x != that.x) return false;\n\t\
    \tif(this.y != that.y) return false;\n\t\tif(this.h != that.h) return false;\n\
    \t\tif(this.w != that.w) return false;\n\t\tif(this.v != that.v) return false;\n\
    \t\treturn true;\n\t}\n\t@Override\n\tpublic final int compareTo(final LongGrid\
    \ that) {\n\t\tint c = Long.compare(this.v, that.v);\n\t\tif(c == 0) c = Integer.compare(this.x,\
    \ that.x);\n\t\tif(c == 0) c = Integer.compare(this.y, that.y);\n\t\treturn c;\n\
    \t}\n}\nfinal class TemplateGrid<T> extends AbstractGrid {\n\tpublic T v;\n\t\
    public TemplateGrid(final int x, final int y, final int h, final int w, final\
    \ T v) { super(x, y, h, w); this.v = v; }\n\n\t@Override public final String toString()\
    \ { return \"(\"+x+\", \"+y+\")=\"+v.toString(); }\n\t@Override public final int\
    \ hashCode() { return Objects.hash(x, y, v); }\n\t@Override\n\tpublic final boolean\
    \ equals(final Object obj) {\n\t\tif(this == obj) return true;\n\t\tif(obj ==\
    \ null) return false;\n\t\tif(this.getClass() != obj.getClass()) return false;\n\
    \t\tTemplateGrid that = (TemplateGrid) obj;\n\t\tif(this.x != that.x) return false;\n\
    \t\tif(this.y != that.y) return false;\n\t\tif(this.h != that.h) return false;\n\
    \t\tif(this.w != that.w) return false;\n\t\tif(!this.v.equals(that.v)) return\
    \ false;\n\t\treturn true;\n\t}\n}"
  dependsOn:
  - library/FastIO.java
  isVerificationFile: false
  path: library/AbstractGrid.java
  requiredBy:
  - library/GridBfs.java
  timestamp: '2023-03-25 18:52:00+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/GridBfs_test.java
documentation_of: library/AbstractGrid.java
layout: document
redirect_from:
- /library/library/AbstractGrid.java
- /library/library/AbstractGrid.java.html
title: library/AbstractGrid.java
---
