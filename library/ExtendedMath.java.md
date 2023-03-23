---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':heavy_check_mark:'
    path: library/Pair.java
    title: library/Pair.java
  - icon: ':warning:'
    path: library/Util.java
    title: library/Util.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':warning:'
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
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\nimport\
    \ library.Util;\nimport library.Pair;\nimport library.Mod;\n\nclass ExtendedMath\
    \ {\n\tpublic static final int functional(int[] next, int x, long q) { // O(N)\n\
    \t\tlong visited[] = new long[next.length];\n\t\tArrays.fill(visited, -1);\n\t\
    \tvisited[x] = 0;\n\t\tfor(long i = 1; i <= q; i ++) {\n\t\t\tx = next[x];\n\t\
    \t\tif(visited[x] >= 0 && q >= next.length + i) q = (q - i) % (i - visited[x])\
    \ + i;\n\t\t\telse visited[x] = i;\n\t\t}\n\t\treturn x;\n\t}\n\tpublic static\
    \ final long[] slideMin(long[] array, int len) { // O(N) N=len\n\t\tSimpleUtil.nonNegativeCheck(len);\n\
    \t\tDeque<Integer> s = new ArrayDeque<>();\n\t\tlong slideMin[] = new long[array.length\
    \ - len + 1];\n\t\tfor(int i = 0; i < array.length; i ++) {\n\t\t\twhile(!s.isEmpty()\
    \ && array[s.getLast()] >= array[i]) s.removeLast();\n\t\t\ts.addLast(i);\n\t\t\
    \twhile(!s.isEmpty() && s.getFirst() + len <= i) s.removeFirst();\n\t\t\tslideMin[Math.max(0,\
    \ i - len + 1)] = array[s.getFirst()];\n\t\t}\n\t\treturn slideMin;\n\t}\n\t//\
    \ O(NlogN)\n\tpublic static final int[] lis(long[] a) { return lis(a, true); }\n\
    \tpublic static final int[] lis(long[] a, boolean increasing) {\n\t\tint len =\
    \ a.length;\n\t\tlong increase[] = new long[len];\n\t\tArrays.fill(increase, increasing\
    \ ? SimpleUtil.INF : - SimpleUtil.INF);\n\t\tint lis[] = new int[len];\n\t\tfor(int\
    \ i = 0; i < len; i ++) {\n\t\t\tlis[i] = Util.cntBS(increase, a[i], increasing,\
    \ !increasing, false) + 1;\n\t\t\tincrease[lis[i] - 1] = a[i];\n\t\t}\n\t\treturn\
    \ lis;\n\t}\n\n\tprivate static final int signum(long x) { return x == 0 ? 0 :\
    \ x > 0 ? 1 : -1; }\n\tpublic static final int quadrant[][] = {{6, 5, 4}, {7,\
    \ 0, 3}, {8, 1, 2}};\n\tpublic static final int quadrant2[][] = {{0, 8, 7}, {1,\
    \ 4, 6}, {2, 3, 5}};\n\tpublic static final Comparator<long[]> argC = (sort1,\
    \ sort2) -> {\n\t\tint c = Integer.compare(quadrant[signum(sort1[0]) + 1][signum(sort1[1])\
    \ + 1],\n\t\t\t\t\t\t\t\tquadrant[signum(sort2[0]) + 1][signum(sort2[1]) + 1]);\n\
    \t\tif(c == 0) c = Long.compare(sort1[1] * sort2[0], sort1[0] * sort2[1]);\n\t\
    \tif(c == 0) c = Long.compare(Math.abs(sort1[0]) + Math.abs(sort2[1]), Math.abs(sort2[0])\
    \ + Math.abs(sort2[1]));\n\t\treturn c;\n\t};\n\tpublic static final Comparator<long[]>\
    \ argC2 = (sort1, sort2) -> {\n\t\tint c = Integer.compare(quadrant2[signum(sort1[0])\
    \ + 1][signum(sort1[1]) + 1],\n\t\t\t\t\t\t\t\tquadrant2[signum(sort2[0]) + 1][signum(sort2[1])\
    \ + 1]);\n\t\tif(c == 0) c = Long.compare(sort1[1] * sort2[0], sort1[0] * sort2[1]);\n\
    \t\tif(c == 0) c = Long.compare(Math.abs(sort1[0]) + Math.abs(sort2[1]), Math.abs(sort2[0])\
    \ + Math.abs(sort2[1]));\n\t\treturn c;\n\t};\n\n\tpublic static final long[]\
    \ mul(final Mod md, final long[][] mat1, final long[] mat2) { // O(N^2)\n\t\t\
    long mul[] = new long[mat2.length];\n\t\tfor(int i = 0; i < mul.length; i ++)\
    \ {\n\t\t\tfor(int j = 0; j < mat2.length; j ++) {\n\t\t\t\tmul[i] = md.add(mul[i],\
    \ md.mul(mat1[i][j], mat2[j]));\n\t\t\t}\n\t\t}\n\t\treturn mul;\n\t}\n\tpublic\
    \ static final long[][] mul(final Mod md, final long[][] mat1, final long[][]\
    \ mat2) { // O(N^3)\n\t\tlong mul[][] = new long[mat1.length][mat2[0].length];\n\
    \t\tfor(int i = 0; i < mul.length; i ++) {\n\t\t\tfor(int j = 0; j < mul[i].length;\
    \ j ++) {\n\t\t\t\tfor(int k = 0; k < mat2.length; k ++) {\n\t\t\t\t\tmul[i][j]\
    \ = md.add(mul[i][j], md.mul(mat1[i][k], mat2[k][j]));\n\t\t\t\t}\n\t\t\t}\n\t\
    \t}\n\t\treturn mul;\n\t}\n\tpublic static final long[][] pow(final Mod md, final\
    \ long[][] mat, long y) { // O(N^3logY)\n\t\tSimpleUtil.nonNegativeCheck(y);\n\
    \t\tint num = mat.length;\n\t\tlong[][] ans = new long[num][num];\n\t\tfor(int\
    \ i = 0; i < num; i ++) ans[i][i] = 1;\n\t\tlong[][] x = new long[num][num];\n\
    \t\tfor(int i = 0; i < num; i ++) for(int j = 0; j < num; j ++) x[i][j] = mat[i][j];\n\
    \t\tfor(; y > 0; y /= 2) {\n\t\t\tif(y % 2 != 0) ans = mul(md, ans, x);\n\t\t\t\
    x = mul(md, x, x);\n\t\t}\n\t\treturn ans;\n\t}\n\n\t// sum in [0,n) of floor((ai+b)/m)\n\
    \tpublic static final long floorSum(final long n, final long m, long a, long b)\
    \ { // O(log(N+M+A+B))\n\t\tSimpleUtil.nonNegativeCheck(n);\n\t\tSimpleUtil.positiveCheck(m);\n\
    \t\tSimpleUtil.nonNegativeCheck(a);\n\t\tSimpleUtil.nonNegativeCheck(b);\n\t\t\
    long ans = 0;\n\t\tif(a >= m) {\n\t\t\tans += (n - 1) * n * (a / m) / 2;\n\t\t\
    \ta %= m;\n\t\t}\n\t\tif(b >= m) {\n\t\t\tans += n * (b / m);\n\t\t\tb %= m;\n\
    \t\t}\n\t\n\t\tlong y_max = (a * n + b) / m, x_max = (y_max * m - b);\n\t\tif(y_max\
    \ == 0) return ans;\n\t\tans += (n - (x_max + a - 1) / a) * y_max;\n\t\tans +=\
    \ floorSum(y_max, a, m, (a - x_max % a) % a);\n\t\treturn ans;\n\t}\n\n\t// O(RC^2)\n\
    \tpublic static final int gaussJordan(final Mod md, final long[][] mat) { return\
    \ gaussJordan(md, mat, false); }\n\tpublic static final int gaussJordan(final\
    \ Mod md, final long[][] mat, final boolean isExtended) {\n\t\tmd.mod(mat);\n\t\
    \tint row = mat.length;\n\t\tint col = mat[0].length;\n\t\tfor(int r = 0; r <\
    \ row; r ++) SimpleUtil.assertion(mat[r].length == col);\n\t\tint rank = 0;\n\t\
    \tfor(int c = 0; c < col; c ++) {\n\t\t\tif(isExtended && c == col - 1) continue;\n\
    \t\t\tint pivot = -1;\n\t\t\tfor(int r = rank; r < row; r ++) if(mat[r][c] !=\
    \ 0) { pivot = r; break; }\n\t\t\tif(pivot == -1) continue;\n\t\t\tfor(int c2\
    \ = 0; c2 < col; c2 ++) {\n\t\t\t\tlong tmp = mat[pivot][c2];\n\t\t\t\tmat[pivot][c2]\
    \ = mat[rank][c2];\n\t\t\t\tmat[rank][c2] = tmp;\n\t\t\t}\n\t\t\tlong inv = md.inv(mat[rank][c]);\n\
    \t\t\tfor(int c2 = 0; c2 < col; c2 ++) mat[rank][c2] = md.mul(mat[rank][c2], inv);\n\
    \t\t\tfor(int r = 0; r < row; r ++) {\n\t\t\t\tif(r != rank && mat[r][c] != 0)\
    \ {\n\t\t\t\t\tlong fac = mat[r][c];\n\t\t\t\t\tfor(int c2 = 0; c2 < col; c2 ++)\
    \ {\n\t\t\t\t\t\tmat[r][c2] = md.sub(mat[r][c2], md.mul(mat[rank][c2], fac));\n\
    \t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\trank ++;\n\t\t}\n\t\treturn rank;\n\t}\n\
    \t// O(RC^2)\n\t// solve ax=b; a:=(R,C), x:=(C,1), b:=(R,1)\n\tpublic static final\
    \ int linearEquation(final Mod md, final long[][] a, final long[] b, final long[]\
    \ ans) {\n\t\tint row = a.length;\n\t\tint col = a[0].length;\n\t\tfor(int r =\
    \ 0; r < row; r ++) SimpleUtil.assertion(a[r].length == col);\n\t\tSimpleUtil.assertion(b.length\
    \ == row);\n\t\n\t\tlong mat[][] = new long[row][col + 1];\n\t\tfor(int r = 0;\
    \ r < row; r ++) {\n\t\t\tfor(int c = 0; c < col; c ++) {\n\t\t\t\tmat[r][c] =\
    \ a[r][c];\n\t\t\t}\n\t\t\tmat[r][col] = b[r];\n\t\t}\n\t\n\t\tint rank = gaussJordan(md,\
    \ mat, true);\n\t\tfor(int r = rank; r < row; r ++) if(mat[r][col] != 0) return\
    \ -1;\n\t\tfor(int r = 0; r < rank; r ++) ans[r] = mat[r][col];\n\t\treturn rank;\n\
    \t}\n\tpublic static final class BitMatrix extends ArrayList<BitSet> {\n\t\tint\
    \ row;\n\t\tint col;\n\t\tBitMatrix(int row, int col) {\n\t\t\tSimpleUtil.nonNegativeCheck(row);\n\
    \t\t\tSimpleUtil.nonNegativeCheck(col);\n\t\t\tthis.row = row;\n\t\t\tthis.col\
    \ = col;\n\t\t\tfor(int r = 0; r < row; r ++) add(new BitSet(col));\n\t\t}\n\t\
    \t\n\t\tpublic final boolean get(int r, int c) { return get(r).get(c); }\n\t\t\
    public final void set(int r, int c) { get(r).set(c); }\n\t}\n\t// O(RC)\n\tpublic\
    \ static final int bitGaussJordan(final BitMatrix mat) { return bitGaussJordan(mat,\
    \ false); }\n\tpublic static final int bitGaussJordan(final BitMatrix mat, final\
    \ boolean isExtended) {\n\t\tint row = mat.row;\n\t\tint col = mat.col;\n\t\t\
    int rank = 0;\n\t\tfor(int c = 0; c < col; c ++) {\n\t\t\tif(isExtended && c ==\
    \ col - 1) continue;\n\t\t\tint pivot = -1;\n\t\t\tfor(int r = rank; r < row;\
    \ r ++) if(mat.get(r, c)) { pivot = r; break; }\n\t\t\tif(pivot == -1) continue;\n\
    \t\t\t{\n\t\t\t\tBitSet tmp = mat.get(pivot);\n\t\t\t\tmat.set(pivot, mat.get(rank));\n\
    \t\t\t\tmat.set(rank, tmp);\n\t\t\t}\n\t\t\tfor(int r = 0; r < row; r ++) {\n\t\
    \t\t\tif(r != rank && mat.get(r, c)) mat.get(r).xor(mat.get(rank));\n\t\t\t}\n\
    \t\t\trank ++;\n\t\t}\n\t\treturn rank;\n\t}\n\t// O(RC)\n\t// solve ax=b; a:=(R,C),\
    \ x:=(C,1), b:=(R,1)\n\tpublic static final int bitLinearEquation(final boolean[][]\
    \ a, final boolean[] b, final boolean[] ans) {\n\t\tint row = a.length;\n\t\t\
    int col = a[0].length;\n\t\tfor(int r = 0; r < row; r ++) SimpleUtil.assertion(a[r].length\
    \ == col);\n\t\tSimpleUtil.assertion(b.length == row);\n\t\n\t\tBitMatrix mat\
    \ = new BitMatrix(row, col + 1);\n\t\tfor(int r = 0; r < row; r ++) {\n\t\t\t\
    for(int c = 0; c < col; c ++) if(a[r][c]) mat.set(r, c);\n\t\t\tif(b[r]) mat.set(r,\
    \ col);\n\t\t}\n\t\n\t\tint rank = bitGaussJordan(mat, true);\n\t\tfor(int r =\
    \ rank; r < row; r ++) if(mat.get(r, col)) return -1;\n\t\tfor(int r = 0; r <\
    \ rank; r ++) ans[r] = mat.get(r, col);\n\t\treturn rank;\n\t}\n\t// O(RC)\n\t\
    public static final int longBitGaussJordan(final long[] mat) { return longBitGaussJordan(mat,\
    \ false); }\n\tpublic static final int longBitGaussJordan(final long[] mat, final\
    \ boolean isExtended) {\n\t\tint row = mat.length;\n\t\tlong base[] = new long[row];\n\
    \t\tint rank = 0;\n\t\tfor(int r = 0; r < row; r ++) {\n\t\t\tlong v = mat[r];\n\
    \t\t\tfor(int e = 0; e < rank; e ++) v = Math.min(v, v ^ base[e]);\n\t\t\tif(v\
    \ > 0) base[rank ++] = v;\n\t\t}\n\t\tArrays.sort(base);\n\t\tfor(int i = 0; i\
    \ < row; i ++) mat[row - i - 1] = base[i];\n\t\treturn rank;\n\t}\n\n\t// return\
    \ (g,x) s.t. ax%mod=g=gcd(a,mod) && x>=0\n\tpublic static final Pair.LL invGcd(long\
    \ a, long mod) { // O(loglcm(a,mod))\n\t\tSimpleUtil.positiveCheck(mod, \"mod\"\
    );\n\t\tPair.LL s = new Pair.LL(mod, 0);\n\t\tPair.LL t = new Pair.LL(a, 1);\n\
    \t\twhile(t.a > 0) {\n\t\t\tlong tmp = s.a / t.a;\n\t\t\tPair.LL u = new Pair.LL(s.a\
    \ - t.a * tmp, s.b - t.b * tmp);\n\t\t\ts = t;\n\t\t\tt = u;\n\t\t}\n\t\tif(s.b\
    \ < 0) s.b += mod / s.a;\n\t\treturn s;\n\t}\n\t// return (g,x,y) s.t. ax+by=g=gcd(a,b)\
    \ && |x|+|y| is minimal (primarily) && x<=y (secondarily)\n\tpublic static final\
    \ Util.TupleLLL extGcd(long a, long b) { // O(loglcm(a,b))\n\t\tUtil.TupleLLL\
    \ s = new Util.TupleLLL(a, 1, 0);\n\t\tUtil.TupleLLL t = new Util.TupleLLL(b,\
    \ 0, 1);\n\t\twhile(t.a > 0) {\n\t\t\tlong tmp = s.a / t.a;\n\t\t\tUtil.TupleLLL\
    \ u = new Util.TupleLLL(s.a - t.a * tmp, s.b - t.b * tmp, s.c - t.c * tmp);\n\t\
    \t\ts = t;\n\t\t\tt = u;\n\t\t}\n\t\treturn s;\n\t}\n\t// return (x, lcm(p.b))\
    \ s.t. x%p.b=p.a && x>=0 if exists otherwise null\n\tpublic static final Pair.LL\
    \ chineseRem(Pair.LL[] p) { // O(Nloglcm(ps.a))\n\t\tfor(Pair.LL ele : p) SimpleUtil.positiveCheck(ele.b);\n\
    \t\tint num = p.length;\n\t\tPair.LL ans = new Pair.LL(0, 1);\n\t\tfor(Pair.LL\
    \ crt : p) {\n\t\t\tans = chineseRem(ans, crt);\n\t\t\tif(ans == null) return\
    \ null;\n\t\t}\n\t\treturn ans;\n\t}\n\t// return (x,lcm(p1.b,p2.b)) s.t. x%p1.b=p1.a\
    \ && x%p2.b=p2.a && x>=0 if exists otherwise null\n\tpublic static final Pair.LL\
    \ chineseRem(Pair.LL p1, Pair.LL p2) { // O(loglcm(p1.a,p2.a))\n\t\tSimpleUtil.positiveCheck(p1.b);\n\
    \t\tSimpleUtil.positiveCheck(p2.b);\n\t\tUtil.TupleLLL ans = extGcd(p1.b, p2.b);\n\
    \t\tp1.a = new ArbitraryMod(p1.b).mod(p1.a);\n\t\tp2.a = new ArbitraryMod(p2.b).mod(p2.a);\n\
    \t\tif((p2.a - p1.a) % ans.a != 0) return null;\n\t\tlong lcm = p1.b / ans.a *\
    \ p2.b;\n\t\tlong tmp = new ArbitraryMod(p2.b / ans.a).mul((p2.a - p1.a) / ans.a,\
    \ ans.b);\n\t\tMod md = new ArbitraryMod(lcm);\n\t\treturn new Pair.LL(md.add(p1.a,\
    \ md.mul(p1.b, tmp)), lcm);\n\t}\n\t// requirement: p.b is prime\n\t// return\
    \ x%mod s.t. x%p.b=p.a && x>=0\n\tpublic static final long garner(Pair.LL[] p,\
    \ long mod) { // O(N^2+Nlogmax(p.a)))\n\t\tSimpleUtil.positiveCheck(mod, \"mod\"\
    );\n\t\tfor(Pair.LL ele : p) SimpleUtil.positiveCheck(ele.b);\n\t\tPair.LL p2[]\
    \ = new Pair.LL[p.length + 1];\n\t\tfor(int i = 0; i < p.length; i ++) p2[i] =\
    \ p[i];\n\t\tp = p2;\n\t\tp[p.length - 1] = new Pair.LL(0, mod);\n\t\tlong coffs[]\
    \ = new long[p.length];\n\t\tArrays.fill(coffs, 1);\n\t\tlong constants[] = new\
    \ long[p.length];\n\t\tMod md[] = new ArbitraryMod[p.length];\n\t\tfor(int i =\
    \ 0; i < p.length; i ++) md[i] = new ArbitraryMod(p[i].b);\n\t\tfor(int i = 0;\
    \ i < p.length - 1; i ++) {\n\t\t\tlong v = md[i].mul(p[i].a - constants[i], md[i].inv(coffs[i]));\n\
    \t\t\tfor(int j = i + 1; j < p.length; j ++) {\n\t\t\t\tconstants[j] = md[j].mod(constants[j]\
    \ + md[j].mul(coffs[j], v));\n\t\t\t\tcoffs[j] = md[j].mul(coffs[j], p[i].b);\n\
    \t\t\t}\n\t\t}\n\t\treturn constants[p.length - 1];\n\t}\n}"
  dependsOn:
  - library/Util.java
  - library/Pair.java
  - library/Mod.java
  isVerificationFile: false
  path: library/ExtendedMath.java
  requiredBy: []
  timestamp: '2023-03-23 19:02:13+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: library/ExtendedMath.java
layout: document
redirect_from:
- /library/library/ExtendedMath.java
- /library/library/ExtendedMath.java.html
title: library/ExtendedMath.java
---
