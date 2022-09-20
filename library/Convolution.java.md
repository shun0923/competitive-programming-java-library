---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':warning:'
    path: library/Util.java
    title: library/Util.java
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: library/ExtendedConvolution.java
    title: library/ExtendedConvolution.java
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/Convolution998_test.java
    title: library/Convolution998_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Convolution.java\n"
  code: "package library;\n\nimport java.util.*;\nimport library.Util;\nimport library.Mod;\n\
    \nclass Convolution { // M=MOD\n\tpublic Mod md;\n\tprivate long g;\n\tstatic\
    \ final int SIZE = 30;\n\tprotected final long sumE[] = new long[SIZE];\n\tprotected\
    \ final long sumIE[] = new long[SIZE];\n\tstatic final int NAIVE_THRESHOLD = 512;\n\
    \tpublic Convolution(Mod md) { // O(logM)\n\t\tthis.md = md;\n\t\tg = md.primitiveRoot();\n\
    \t\tprepareSum();\n\t}\n\n\tprivate final void prepareSum() { // O(logM)\n\t\t\
    final long[] es = new long[SIZE];\n\t\tfinal long[] ies = new long[SIZE];\n\t\t\
    final int len = Long.numberOfTrailingZeros(md.MOD - 1);\n\t\tlong e = md.pow(g,\
    \ (md.MOD - 1) >> len);\n\t\tlong ie = md.inv(e);\n\t\tfor(int i = len - 2; i\
    \ >= 0; i --) {\n\t\t\tes[i] = e;\n\t\t\ties[i] = ie;\n\t\t\te = md.mul(e, e);\n\
    \t\t\tie = md.mul(ie, ie);\n\t\t}\n\t\tlong tmpE = 1;\n\t\tlong tmpIE = 1;\n\t\
    \tfor(int i = 0; i < len - 2; i++) {\n\t\t\tsumE[i] = md.mul(es[i], tmpE);\n\t\
    \t\ttmpE = md.mul(tmpE, ies[i]);\n\t\t\tsumIE[i] = md.mul(ies[i], tmpIE);\n\t\t\
    \ttmpIE = md.mul(tmpIE, es[i]);\n\t\t}\n\t}\n\n\tpublic long[] butterfly(final\
    \ long[] a) { // O(NlogN)\n\t\tfinal int n = a.length;\n\t\tint h = 0;\n\t\twhile((1L\
    \ << h) < n) h ++;\n\n\t\tfor(int ph = 1; ph <= h; ph ++) {\n\t\t\tfinal int w\
    \ = 1 << ph - 1;\n\t\t\tfinal int p = 1 << h - ph;\n\t\t\tlong tmp = 1;\n\t\t\t\
    for(int s = 0; s < w; s ++) {\n\t\t\t\tfinal int offset = s << h - ph + 1;\n\t\
    \t\t\tfor(int i = 0; i < p; i ++) {\n\t\t\t\t\tfinal long l = a[i + offset];\n\
    \t\t\t\t\tfinal long r = md.mul(a[i + offset + p], tmp);\n\t\t\t\t\ta[i + offset]\
    \ = md.add(l, r);\n\t\t\t\t\ta[i + offset + p] = md.sub(l, r);\n\t\t\t\t}\n\t\t\
    \t\ttmp = md.mul(tmp, sumE[Integer.numberOfTrailingZeros(~ s)]);\n\t\t\t}\n\t\t\
    }\n\t\treturn a;\n\t}\n\tpublic long[] butterflyInv(final long[] a) { // O(NlogN)\n\
    \t\tfinal int n = a.length;\n\t\tint h = 0;\n\t\twhile((1L << h) < n) h ++;\n\n\
    \t\tfor(int ph = h; ph >= 1; ph --) {\n\t\t\tfinal int w = 1 << ph - 1;\n\t\t\t\
    final int p = 1 << h - ph;\n\t\t\tlong tmp = 1;\n\t\t\tfor(int s = 0; s < w; s\
    \ ++) {\n\t\t\t\tint offset = s << h - ph + 1;\n\t\t\t\tfor(int i = 0; i < p;\
    \ i ++) {\n\t\t\t\t\tfinal long l = a[i + offset];\n\t\t\t\t\tfinal long r = a[i\
    \ + offset + p];\n\t\t\t\t\ta[i + offset] = md.add(l, r);\n\t\t\t\t\ta[i + offset\
    \ + p] = md.mul(md.sub(l, r), tmp);\n\t\t\t\t}\n\t\t\t\ttmp = md.mul(tmp, sumIE[Integer.numberOfTrailingZeros(~\
    \ s)]);\n\t\t\t}\n\t\t}\n\t\treturn a;\n\t}\n\n\t// O((N_1+N_2)log(N_1+N_2))\n\
    \tpublic final long[] cnv(final long[] a, final long[] b) { return cnv(a, b, Math.max(0,\
    \ a.length + b.length - 1)); }\n\tpublic long[] cnv(final long[] a, final long[]\
    \ b, final int l) {\n\t\tUtil.nonNegativeCheck(l);\n\t\tif(a.length == 0 || b.length\
    \ == 0) return new long[l];\n\n\t\tint len = 1;\n\t\twhile(len < a.length + b.length\
    \ - 1) len <<= 1;\n\t\tif(len <= NAIVE_THRESHOLD) return naiveCnv(a, b, l);\n\n\
    \t\tfinal long g[] = new long[len];\n\t\tSystem.arraycopy(a, 0, g, 0, a.length);\n\
    \t\tfinal long h[] = new long[len];\n\t\tSystem.arraycopy(b, 0, h, 0, b.length);\n\
    \n\t\tbutterfly(g);\n\t\tbutterfly(h);\n\n\t\tlong f[] = new long[len];\n\t\t\
    for(int i = 0; i < len; i ++) f[i] = md.mul(g[i], h[i]);\n\t\tbutterflyInv(f);\n\
    \t\tfinal long f2[] = new long[l];\n\t\tSystem.arraycopy(f, 0, f2, 0, Math.min(l,\
    \ len));\n\n\t\tfinal long invLen = md.inv(len);\n\t\tfor(int i = 0; i < Math.min(l,\
    \ len); i ++) f2[i] = md.mul(f2[i], invLen);\n\t\treturn f2;\n\t}\n\n\t// O(N_1N_2)\n\
    \tpublic final long[] naiveCnv(final long[] a, final long[] b) {\n\t\treturn naiveCnv(a,\
    \ b, Math.max(0, a.length + b.length - 1));\n\t}\n\tpublic long[] naiveCnv(final\
    \ long[] a, final long[] b, final int l) {\n\t\tUtil.nonNegativeCheck(l);\n\t\t\
    if(a.length == 0 || b.length == 0) return new long[l];\n\n\t\tfinal long f[] =\
    \ new long[l];\n\t\tfor(int i = 0; i < a.length; i ++) {\n\t\t\tfor(int j = 0;\
    \ j < b.length && i + j < l; j ++) {\n\t\t\t\tf[i + j] = md.add(f[i + j], md.mul(a[i],\
    \ b[j]));\n\t\t\t}\n\t\t}\n\t\treturn f;\n\t}\n\n\t// O(NlogN)\n\tpublic final\
    \ long[] doubling(final long[] a) {\n\t\tfinal int len = a.length;\n\t\tfinal\
    \ long b[] = new long[len];\n\t\tfor(int i = 0; i < len; i ++) b[i] = a[i];\n\n\
    \t\tbutterflyInv(b);\n\t\tfinal long invLen = md.inv(len);\n\t\tlong r = 1;\n\t\
    \tfinal long zeta = md.pow(g, (md.MOD - 1) / (len << 1));\n\t\tfor(int i = 0;\
    \ i < len; i ++) {\n\t\t\tb[i] = md.mul(b[i], invLen, r);\n\t\t\tr = md.mul(r,\
    \ zeta);\n\t\t}\n\n\t\tbutterfly(b);\n\t\tfinal long b2[] = new long[len << 1];\n\
    \t\tSystem.arraycopy(b, 0, b2, len, len);\n\t\tSystem.arraycopy(a, 0, b2, 0, len);\n\
    \t\treturn b;\n\t}\n}\nfinal class Convolution998 extends Convolution { // M=MOD\n\
    \tpublic static final Convolution998 cnv = new Convolution998();\n\tpublic Convolution998()\
    \ { super(Mod998.md); }\n\n\tpublic final long[] butterfly(final long[] a) { //\
    \ O(NlogN)\n\t\tfinal int n = a.length;\n\t\tint h = 0;\n\t\twhile((1L << h) <\
    \ n) h ++;\n\t\tfor(int i = 0; i < n; i ++) a[i] %= 998_244_353;\n\n\t\tfor(int\
    \ ph = 1; ph <= h; ph ++) {\n\t\t\tfinal int w = 1 << ph - 1;\n\t\t\tfinal int\
    \ p = 1 << h - ph;\n\t\t\tlong tmp = 1;\n\t\t\tfor(int s = 0; s < w; s ++) {\n\
    \t\t\t\tint offset = s << h - ph + 1;\n\t\t\t\tfor(int i = 0; i < p; i ++) {\n\
    \t\t\t\t\tfinal long l = a[i + offset];\n\t\t\t\t\tfinal long r = a[i + offset\
    \ + p] * tmp % 998_244_353;\n\t\t\t\t\ta[i + offset] = md.add(l, r);\n\t\t\t\t\
    \ta[i + offset + p] = md.sub(l, r);\n\t\t\t\t}\n\t\t\t\ttmp = tmp * sumE[Integer.numberOfTrailingZeros(~\
    \ s)] % 998_244_353;\n\t\t\t}\n\t\t}\n\t\treturn a;\n\t}\n\tpublic final long[]\
    \ butterflyInv(final long[] a) { // O(NlogN)\n\t\tfinal int n = a.length;\n\t\t\
    int h = 0;\n\t\twhile((1L << h) < n) h ++;\n\n\t\tfor(int ph = h; ph >= 1; ph\
    \ --) {\n\t\t\tfinal int w = 1 << ph - 1;\n\t\t\tfinal int p = 1 << h - ph;\n\t\
    \t\tlong tmp = 1;\n\t\t\tfor(int s = 0; s < w; s ++) {\n\t\t\t\tint offset = s\
    \ << h - ph + 1;\n\t\t\t\tfor(int i = 0; i < p; i ++) {\n\t\t\t\t\tfinal long\
    \ l = a[i + offset];\n\t\t\t\t\tfinal long r = a[i + offset + p];\n\t\t\t\t\t\
    a[i + offset] = l + r >= 998_244_353 ? l + r - 998_244_353 : l + r;\n\t\t\t\t\t\
    a[i + offset + p] = (l - r + 998_244_353) * tmp % 998_244_353;\n\t\t\t\t}\n\t\t\
    \t\ttmp = tmp * sumIE[Integer.numberOfTrailingZeros(~ s)] % 998_244_353;\n\t\t\
    \t}\n\t\t}\n\t\treturn a;\n\t}\n\n\t// O((N_1+N_2)log(N_1+N_2))\n\tpublic final\
    \ long[] cnv(final long[] a, final long[] b, final int l) {\n\t\tUtil.nonNegativeCheck(l);\n\
    \t\tif(a.length == 0 || b.length == 0) return new long[l];\n\n\t\tint len = 1;\n\
    \t\twhile(len < a.length + b.length - 1) len <<= 1;\n\t\tif(len <= NAIVE_THRESHOLD)\
    \ return naiveCnv(a, b, l);\n\n\t\tfinal long g[] = new long[len];\n\t\tSystem.arraycopy(a,\
    \ 0, g, 0, a.length);\n\t\tfinal long h[] = new long[len];\n\t\tSystem.arraycopy(b,\
    \ 0, h, 0, b.length);\n\n\t\tbutterfly(g);\n\t\tbutterfly(h);\n\n\t\tfinal long\
    \ f[] = new long[len];\n\t\tfor(int i = 0; i < len; i ++) f[i] = g[i] * h[i] %\
    \ 998_244_353;\n\t\tbutterflyInv(f);\n\t\tfinal long f2[] = new long[l];\n\t\t\
    System.arraycopy(f, 0, f2, 0, Math.min(l, len));\n\n\t\tfinal long invLen = md.inv(len);\n\
    \t\tfor(int i = 0; i < Math.min(l, len); i ++) f2[i] = f2[i] * invLen % 998_244_353;\n\
    \t\treturn f2;\n\t}\n\n\tpublic final long[] naiveCnv(final long[] a, final long[]\
    \ b, final int l) {\n\t\tUtil.nonNegativeCheck(l);\n\t\tif(a.length == 0 || b.length\
    \ == 0) return new long[l];\n\n\t\tfinal long f[] = new long[l];\n\t\tfor(int\
    \ i = 0; i < a.length; i ++) {\n\t\t\tfor(int j = 0; j < b.length && i + j < l;\
    \ j ++) {\n\t\t\t\tf[i + j] = (f[i + j] + a[i] * b[j]) % 998_244_353;\n\t\t\t\
    }\n\t\t}\n\t\treturn f;\n\t}\n}\nfinal class Convolution754974721 extends Convolution\
    \ { // M=MOD\n\tpublic static final Convolution754974721 cnv = new Convolution754974721();\n\
    \tpublic Convolution754974721() { super(Mod754974721.md); }\n\n\tpublic final\
    \ long[] butterfly(final long[] a) { // O(NlogN)\n\t\tfinal int n = a.length;\n\
    \t\tint h = 0;\n\t\twhile((1L << h) < n) h ++;\n\t\tfor(int i = 0; i < n; i ++)\
    \ a[i] %= 754_974_721;\n\n\t\tfor(int ph = 1; ph <= h; ph ++) {\n\t\t\tfinal int\
    \ w = 1 << ph - 1;\n\t\t\tfinal int p = 1 << h - ph;\n\t\t\tlong tmp = 1;\n\t\t\
    \tfor(int s = 0; s < w; s ++) {\n\t\t\t\tint offset = s << h - ph + 1;\n\t\t\t\
    \tfor(int i = 0; i < p; i ++) {\n\t\t\t\t\tfinal long l = a[i + offset];\n\t\t\
    \t\t\tfinal long r = a[i + offset + p] * tmp % 754_974_721;\n\t\t\t\t\ta[i + offset]\
    \ = md.add(l, r);\n\t\t\t\t\ta[i + offset + p] = md.sub(l, r);\n\t\t\t\t}\n\t\t\
    \t\ttmp = tmp * sumE[Integer.numberOfTrailingZeros(~ s)] % 754_974_721;\n\t\t\t\
    }\n\t\t}\n\t\treturn a;\n\t}\n\tpublic final long[] butterflyInv(final long[]\
    \ a) { // O(NlogN)\n\t\tfinal int n = a.length;\n\t\tint h = 0;\n\t\twhile((1L\
    \ << h) < n) h ++;\n\n\t\tfor(int ph = h; ph >= 1; ph --) {\n\t\t\tfinal int w\
    \ = 1 << ph - 1;\n\t\t\tfinal int p = 1 << h - ph;\n\t\t\tlong tmp = 1;\n\t\t\t\
    for(int s = 0; s < w; s ++) {\n\t\t\t\tint offset = s << h - ph + 1;\n\t\t\t\t\
    for(int i = 0; i < p; i ++) {\n\t\t\t\t\tfinal long l = a[i + offset];\n\t\t\t\
    \t\tfinal long r = a[i + offset + p];\n\t\t\t\t\ta[i + offset] = l + r >= 754_974_721\
    \ ? l + r - 754_974_721 : l + r;\n\t\t\t\t\ta[i + offset + p] = (l - r + 754_974_721)\
    \ * tmp % 754_974_721;\n\t\t\t\t}\n\t\t\t\ttmp = tmp * sumIE[Integer.numberOfTrailingZeros(~\
    \ s)] % 754_974_721;\n\t\t\t}\n\t\t}\n\t\treturn a;\n\t}\n\n\t// O((N_1+N_2)log(N_1+N_2))\n\
    \tpublic final long[] cnv(final long[] a, final long[] b, final int l) {\n\t\t\
    Util.nonNegativeCheck(l);\n\t\tif(a.length == 0 || b.length == 0) return new long[l];\n\
    \n\t\tint len = 1;\n\t\twhile(len < a.length + b.length - 1) len <<= 1;\n\t\t\
    if(len <= NAIVE_THRESHOLD) return naiveCnv(a, b, l);\n\n\t\tfinal long g[] = new\
    \ long[len];\n\t\tSystem.arraycopy(a, 0, g, 0, a.length);\n\t\tfinal long h[]\
    \ = new long[len];\n\t\tSystem.arraycopy(b, 0, h, 0, b.length);\n\n\t\tbutterfly(g);\n\
    \t\tbutterfly(h);\n\n\t\tlong f[] = new long[len];\n\t\tfor(int i = 0; i < len;\
    \ i ++) f[i] = g[i] * h[i] % 754_974_721;\n\t\tbutterflyInv(f);\n\t\tfinal long\
    \ f2[] = new long[l];\n\t\tSystem.arraycopy(f, 0, f2, 0, Math.min(l, len));\n\n\
    \t\tfinal long invLen = md.inv(len);\n\t\tfor(int i = 0; i < Math.min(l, len);\
    \ i ++) f2[i] = f2[i] * invLen % 754_974_721;\n\t\treturn f2;\n\t}\n\n\tpublic\
    \ final long[] naiveCnv(final long[] a, final long[] b, final int l) {\n\t\tUtil.nonNegativeCheck(l);\n\
    \t\tif(a.length == 0 || b.length == 0) return new long[l];\n\n\t\tfinal long f[]\
    \ = new long[l];\n\t\tfor(int i = 0; i < a.length; i ++) {\n\t\t\tfor(int j =\
    \ 0; j < b.length && i + j < l; j ++) {\n\t\t\t\tf[i + j] = (f[i + j] + a[i] *\
    \ b[j]) % 754_974_721;\n\t\t\t}\n\t\t}\n\t\treturn f;\n\t}\n}\nfinal class Convolution167772161\
    \ extends Convolution { // M=MOD\n\tpublic static final Convolution167772161 cnv\
    \ = new Convolution167772161();\n\tpublic Convolution167772161() { super(Mod167772161.md);\
    \ }\n\n\tpublic final long[] butterfly(final long[] a) { // O(NlogN)\n\t\tfinal\
    \ int n = a.length;\n\t\tint h = 0;\n\t\twhile((1L << h) < n) h ++;\n\t\tfor(int\
    \ i = 0; i < n; i ++) a[i] %= 167_772_161;\n\n\t\tfor(int ph = 1; ph <= h; ph\
    \ ++) {\n\t\t\tfinal int w = 1 << ph - 1;\n\t\t\tfinal int p = 1 << h - ph;\n\t\
    \t\tlong tmp = 1;\n\t\t\tfor(int s = 0; s < w; s ++) {\n\t\t\t\tint offset = s\
    \ << h - ph + 1;\n\t\t\t\tfor(int i = 0; i < p; i ++) {\n\t\t\t\t\tfinal long\
    \ l = a[i + offset];\n\t\t\t\t\tfinal long r = a[i + offset + p] * tmp % 167_772_161;\n\
    \t\t\t\t\ta[i + offset] = md.add(l, r);\n\t\t\t\t\ta[i + offset + p] = md.sub(l,\
    \ r);\n\t\t\t\t}\n\t\t\t\ttmp = tmp * sumE[Integer.numberOfTrailingZeros(~ s)]\
    \ % 167_772_161;\n\t\t\t}\n\t\t}\n\t\treturn a;\n\t}\n\tpublic final long[] butterflyInv(final\
    \ long[] a) { // O(NlogN)\n\t\tfinal int n = a.length;\n\t\tint h = 0;\n\t\twhile((1L\
    \ << h) < n) h ++;\n\n\t\tfor(int ph = h; ph >= 1; ph --) {\n\t\t\tfinal int w\
    \ = 1 << ph - 1;\n\t\t\tfinal int p = 1 << h - ph;\n\t\t\tlong tmp = 1;\n\t\t\t\
    for(int s = 0; s < w; s ++) {\n\t\t\t\tint offset = s << h - ph + 1;\n\t\t\t\t\
    for(int i = 0; i < p; i ++) {\n\t\t\t\t\tfinal long l = a[i + offset];\n\t\t\t\
    \t\tfinal long r = a[i + offset + p];\n\t\t\t\t\ta[i + offset] = l + r >= 167_772_161\
    \ ? l + r - 167_772_161 : l + r;\n\t\t\t\t\ta[i + offset + p] = (l - r + 167_772_161)\
    \ * tmp % 167_772_161;\n\t\t\t\t}\n\t\t\t\ttmp = tmp * sumIE[Integer.numberOfTrailingZeros(~\
    \ s)] % 167_772_161;\n\t\t\t}\n\t\t}\n\t\treturn a;\n\t}\n\n\t// O((N_1+N_2)log(N_1+N_2))\n\
    \tpublic final long[] cnv(final long[] a, final long[] b, final int l) {\n\t\t\
    Util.nonNegativeCheck(l);\n\t\tif(a.length == 0 || b.length == 0) return new long[l];\n\
    \n\t\tint len = 1;\n\t\twhile(len < a.length + b.length - 1) len <<= 1;\n\t\t\
    if(len <= NAIVE_THRESHOLD) return naiveCnv(a, b, l);\n\n\t\tfinal long g[] = new\
    \ long[len];\n\t\tSystem.arraycopy(a, 0, g, 0, a.length);\n\t\tfinal long h[]\
    \ = new long[len];\n\t\tSystem.arraycopy(b, 0, h, 0, b.length);\n\n\t\tbutterfly(g);\n\
    \t\tbutterfly(h);\n\n\t\tlong f[] = new long[len];\n\t\tfor(int i = 0; i < len;\
    \ i ++) f[i] = g[i] * h[i] % 167_772_161;\n\t\tbutterflyInv(f);\n\t\tfinal long\
    \ f2[] = new long[l];\n\t\tSystem.arraycopy(f, 0, f2, 0, Math.min(l, len));\n\n\
    \t\tfinal long invLen = md.inv(len);\n\t\tfor(int i = 0; i < Math.min(l, len);\
    \ i ++) f2[i] = f2[i] * invLen % 167_772_161;\n\t\treturn f2;\n\t}\n\n\tpublic\
    \ final long[] naiveCnv(final long[] a, final long[] b, final int l) {\n\t\tUtil.nonNegativeCheck(l);\n\
    \t\tif(a.length == 0 || b.length == 0) return new long[l];\n\n\t\tfinal long f[]\
    \ = new long[l];\n\t\tfor(int i = 0; i < a.length; i ++) {\n\t\t\tfor(int j =\
    \ 0; j < b.length && i + j < l; j ++) {\n\t\t\t\tf[i + j] = (f[i + j] + a[i] *\
    \ b[j]) % 167_772_161;\n\t\t\t}\n\t\t}\n\t\treturn f;\n\t}\n}\nfinal class Convolution469762049\
    \ extends Convolution { // M=MOD\n\tpublic static final Convolution469762049 cnv\
    \ = new Convolution469762049();\n\tpublic Convolution469762049() { super(Mod469762049.md);\
    \ }\n\n\tpublic final long[] butterfly(final long[] a) { // O(NlogN)\n\t\tfinal\
    \ int n = a.length;\n\t\tint h = 0;\n\t\twhile((1L << h) < n) h ++;\n\t\tfor(int\
    \ i = 0; i < n; i ++) a[i] %= 469_762_049;\n\n\t\tfor(int ph = 1; ph <= h; ph\
    \ ++) {\n\t\t\tfinal int w = 1 << ph - 1;\n\t\t\tfinal int p = 1 << h - ph;\n\t\
    \t\tlong tmp = 1;\n\t\t\tfor(int s = 0; s < w; s ++) {\n\t\t\t\tint offset = s\
    \ << h - ph + 1;\n\t\t\t\tfor(int i = 0; i < p; i ++) {\n\t\t\t\t\tfinal long\
    \ l = a[i + offset];\n\t\t\t\t\tfinal long r = a[i + offset + p] * tmp % 469_762_049;\n\
    \t\t\t\t\ta[i + offset] = md.add(l, r);\n\t\t\t\t\ta[i + offset + p] = md.sub(l,\
    \ r);\n\t\t\t\t}\n\t\t\t\ttmp = tmp * sumE[Integer.numberOfTrailingZeros(~ s)]\
    \ % 469_762_049;\n\t\t\t}\n\t\t}\n\t\treturn a;\n\t}\n\tpublic final long[] butterflyInv(final\
    \ long[] a) { // O(NlogN)\n\t\tfinal int n = a.length;\n\t\tint h = 0;\n\t\twhile((1L\
    \ << h) < n) h ++;\n\n\t\tfor(int ph = h; ph >= 1; ph --) {\n\t\t\tfinal int w\
    \ = 1 << ph - 1;\n\t\t\tfinal int p = 1 << h - ph;\n\t\t\tlong tmp = 1;\n\t\t\t\
    for(int s = 0; s < w; s ++) {\n\t\t\t\tint offset = s << h - ph + 1;\n\t\t\t\t\
    for(int i = 0; i < p; i ++) {\n\t\t\t\t\tfinal long l = a[i + offset];\n\t\t\t\
    \t\tfinal long r = a[i + offset + p];\n\t\t\t\t\ta[i + offset] = l + r >= 469_762_049\
    \ ? l + r - 469_762_049 : l + r;\n\t\t\t\t\ta[i + offset + p] = (l - r + 469_762_049)\
    \ * tmp % 469_762_049;\n\t\t\t\t}\n\t\t\t\ttmp = tmp * sumIE[Integer.numberOfTrailingZeros(~\
    \ s)] % 469_762_049;\n\t\t\t}\n\t\t}\n\t\treturn a;\n\t}\n\n\t// O((N_1+N_2)log(N_1+N_2))\n\
    \tpublic final long[] cnv(final long[] a, final long[] b, final int l) {\n\t\t\
    Util.nonNegativeCheck(l);\n\t\tif(a.length == 0 || b.length == 0) return new long[l];\n\
    \n\t\tint len = 1;\n\t\twhile(len < a.length + b.length - 1) len <<= 1;\n\t\t\
    if(len <= NAIVE_THRESHOLD) return naiveCnv(a, b, l);\n\n\t\tfinal long g[] = new\
    \ long[len];\n\t\tSystem.arraycopy(a, 0, g, 0, a.length);\n\t\tfinal long h[]\
    \ = new long[len];\n\t\tSystem.arraycopy(b, 0, h, 0, b.length);\n\n\t\tbutterfly(g);\n\
    \t\tbutterfly(h);\n\n\t\tlong f[] = new long[len];\n\t\tfor(int i = 0; i < len;\
    \ i ++) f[i] = g[i] * h[i] % 469_762_049;\n\t\tbutterflyInv(f);\n\t\tfinal long\
    \ f2[] = new long[l];\n\t\tSystem.arraycopy(f, 0, f2, 0, Math.min(l, len));\n\n\
    \t\tfinal long invLen = md.inv(len);\n\t\tfor(int i = 0; i < Math.min(l, len);\
    \ i ++) f2[i] = f2[i] * invLen % 469_762_049;\n\t\treturn f2;\n\t}\n\n\tpublic\
    \ final long[] naiveCnv(final long[] a, final long[] b, final int l) {\n\t\tUtil.nonNegativeCheck(l);\n\
    \t\tif(a.length == 0 || b.length == 0) return new long[l];\n\n\t\tfinal long f[]\
    \ = new long[l];\n\t\tfor(int i = 0; i < a.length; i ++) {\n\t\t\tfor(int j =\
    \ 0; j < b.length && i + j < l; j ++) {\n\t\t\t\tf[i + j] = (f[i + j] + a[i] *\
    \ b[j]) % 469_762_049;\n\t\t\t}\n\t\t}\n\t\treturn f;\n\t}\n}"
  dependsOn:
  - library/Util.java
  - library/Mod.java
  isVerificationFile: false
  path: library/Convolution.java
  requiredBy:
  - library/ExtendedConvolution.java
  timestamp: '2022-09-20 14:50:17+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Convolution998_test.java
documentation_of: library/Convolution.java
layout: document
redirect_from:
- /library/library/Convolution.java
- /library/library/Convolution.java.html
title: library/Convolution.java
---
