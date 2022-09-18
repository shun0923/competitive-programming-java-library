---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Util.java
    title: library/Util.java
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryMod.java
    title: library/ArbitraryMod.java
  - icon: ':heavy_check_mark:'
    path: library/Convolution.java
    title: library/Convolution.java
  - icon: ':heavy_check_mark:'
    path: library/ExtendedConvolution.java
    title: library/ExtendedConvolution.java
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/Mod107ManyCombination_test.java
    title: library/Mod107ManyCombination_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod107Pow_test.java
    title: library/Mod107Pow_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod107Random_test.java
    title: library/Mod107Random_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod998ManyCombination_test.java
    title: library/Mod998ManyCombination_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod998Random_test.java
    title: library/Mod998Random_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Mod.java\n"
  code: "package library;\n\nimport java.util.*;\nimport library.Util;\n\nabstract\
    \ class Mod {\n\tpublic final long MOD;\n\tpublic Mod(long mod) { MOD = mod; }\n\
    \n\tpublic abstract long mod(long x);\n\tpublic final long[] mod(final long[]\
    \ a) { for(int i = 0; i < a.length; i ++) a[i] = mod(a[i]); return a; }\n\tpublic\
    \ final long[][] mod(final long[][] a) { for(int i = 0; i < a.length; i ++) mod(a[i]);\
    \ return a; }\n\tpublic final long[][][] mod(final long[][][] a) { for(int i =\
    \ 0; i < a.length; i ++) mod(a[i]); return a; }\n\n\tpublic long add(long x, final\
    \ long y) { return (x += y) >= MOD * 2 || x < 0 ? mod(x) : x >= MOD ? x - MOD\
    \ : x; }\n\tpublic final long sum(final long... x) { long sum = 0; for(long ele\
    \ : x) sum = add(sum, ele); return sum; }\n\tpublic long sub(long x, final long\
    \ y) { return (x -= y) < - MOD || x >= MOD ? mod(x) : x < 0 ? x + MOD : x; }\n\
    \tpublic final long pow(long x, long y) {\n\t\tUtil.nonNegativeCheck(y);\n\t\t\
    x = mod(x);\n\t\tlong ans = 1;\n\t\tfor(; y > 0; y >>= 1) {\n\t\t\tif((y & 1)\
    \ != 0) ans = mul(ans, x);\n\t\t\tx = mul(x, x);\n\t\t}\n\t\treturn ans;\n\t}\n\
    \tpublic abstract long mul(long x, long y);\n\tpublic final long mul(final long...\
    \ x) { long ans = 1; for(long ele : x) ans = mul(ans, ele); return ans; }\n\t\
    public final long div(final long x, final long y) { return mul(x, inv(y)); }\n\
    \n\tpublic final long[] pows(long x, final int n) {\n\t\tx = mod(x);\n\t\tlong\
    \ pow[] = new long[n + 1];\n\t\tpow[0] = 1;\n\t\tfor(int i = 0; i < n; i ++) pow[i\
    \ + 1] = mul(pow[i], x);\n\t\treturn pow;\n\t}\n\tpublic final long fact(final\
    \ int n) {\n\t\tUtil.nonNegativeCheck(n);\n\t\tprepareFact();\n\t\tif(n < MAX_FACT1)\
    \ return fact[n];\n\t\telse {\n\t\t\tlong ans = fact[MAX_FACT1 - 1];\n\t\t\tfor(int\
    \ i = MAX_FACT1; i <= n; i ++) ans = mul(ans, i);\n\t\t\treturn ans;\n\t\t}\n\t\
    }\n\tpublic final long invFact(final int n) {\n\t\tUtil.nonNegativeCheck(n);\n\
    \t\tprepareFact();\n\t\tif(n < MAX_FACT1) return invFact[n];\n\t\telse return\
    \ inv(fact(n));\n\t}\n\n\tprivate static final int MAX_INV_SIZE = 100_100;\n\t\
    private final Map<Long, Long> invMap = new HashMap<>();\n\tpublic final long inv(long\
    \ x) {\n\t\tx = mod(x);\n\t\tif(invMap.containsKey(x)) return invMap.get(x);\n\
    \t\tif(invMap.size() >= MAX_INV_SIZE) return calInv(x);\n\t\tinvMap.put(x, calInv(x));\n\
    \t\treturn invMap.get(x);\n\t}\n\tprivate final long calInv(final long x) { //\
    \ O(logM)\n\t\tlong s0 = MOD, s1 = 0;\n\t\tlong t0 = mod(x), t1 = 1;\n\t\twhile(t0\
    \ > 0) {\n\t\t\tfinal long tmp = s0 / t0;\n\t\t\tfinal long u0 = s0 - t0 * tmp;\n\
    \t\t\tfinal long u1 = s1 - t1 * tmp;\n\t\t\ts0 = t0;\n\t\t\ts1 = t1;\n\t\t\tt0\
    \ = u0;\n\t\t\tt1 = u1;\n\t\t}\n\t\tif(s0 != 1) throw new ArithmeticException(\"\
    / by zero\");\n\t\tif(s1 < 0) s1 += MOD;\n\t\treturn s1;\n\t}\n\tpublic final\
    \ long[] invs(final int n) { // O(N)\n\t\tUtil.positiveCheck(n);\n\t\tlong inv[]\
    \ = new long[n + 1];\n\t\tinv[1] = 1;\n\t\tfor(int i = 2; i <= n; i ++) inv[i]\
    \ = mul(inv[(int)(MOD % i)], (MOD - MOD / i));\n\t\treturn inv;\n\t}\n\n\tprivate\
    \ long g;\n\tpublic final long primitiveRoot() { // O(1) or O(M^(1/2))\n\t\tif(MOD\
    \ == 2) return 1;\n\t\tif(MOD == 167772161) return 3;\n\t\tif(MOD == 469762049)\
    \ return 3;\n\t\tif(MOD == 754974721) return 11;\n\t\tif(MOD == 998244353) return\
    \ 3;\n\t\tif(g != 0) return g;\n\n\t\t// PairLL factor[] = factor(MOD - 1);\n\t\
    \t// outer: for(g = 2; ; g ++) {\n\t\t// \tfor(PairLL p : factor) if(pow(g, (MOD\
    \ - 1) / p.a) == 1) continue outer;\n\t\t// \treturn g;\n\t\t// }\n\t\treturn\
    \ 0;\n\t}\n\n\tprivate static final int MAX_FACT1 = 5_000_100;\n\tprivate static\
    \ final int MAX_FACT2 = 500_100;\n\tprivate static final int MAX_FACT_MAP_SIZE\
    \ = 100;\n\tprivate long fact[];\n\tprivate long invFact[];\n\tprivate boolean\
    \ isFactPrepared = false;\n\tprivate final Map<Long, long[]> factMap = new HashMap<>();\n\
    \tprivate final void prepareFact() {\n\t\tif(isFactPrepared) return;\n\t\tfact\
    \ = new long[MAX_FACT1];\n\t\tinvFact = new long[MAX_FACT1];\n\t\tfact[0] = 1;\n\
    \t\tint maxIndex = Math.min(MAX_FACT1, (int)MOD);\n\t\tfor(int i = 1; i < maxIndex;\
    \ i ++) fact[i] = mul(fact[i - 1], i);\n\t\tinvFact[maxIndex - 1] = inv(fact[maxIndex\
    \ - 1]);\n\t\tfor(int i = maxIndex - 1; i > 0; i --) invFact[i - 1] = mul(invFact[i],\
    \ i);\n\n\t\tisFactPrepared = true;\n\t}\n\n\tpublic final long P(final long n,\
    \ final long r) {\n\t\tif(!isFactPrepared) prepareFact();\n\t\tif(n < 0 || r <\
    \ 0 || n < r) return 0;\n\t\tif(n < MAX_FACT1 && n < MOD) return mul(fact[(int)n],\
    \ invFact[(int)(n - r)]);\n\t\tif(!factMap.containsKey(n)) {\n\t\t\tlong largeFact[]\
    \ = new long[MAX_FACT2];\n\t\t\tfactMap.put(n, largeFact);\n\t\t\tArrays.fill(largeFact,\
    \ -1);\n\t\t\tlargeFact[0] = 1;\n\t\t}\n\t\tlong largeFact[] = factMap.get(n);\n\
    \t\tif(r >= MAX_FACT2) {\n\t\t\tlong ans = 1;\n\t\t\tfor(long i = n - r + 1; i\
    \ <= n; i ++) ans = mul(ans, i);\n\t\t\treturn ans;\n\t\t}else {\n\t\t\tint i\
    \ = (int)r;\n\t\t\twhile(largeFact[i] < 0) i --;\n\t\t\tfor(; i < r; i ++) largeFact[i\
    \ + 1] = mul(largeFact[i], n - i);\n\t\t\tif(factMap.size() > MAX_FACT_MAP_SIZE)\
    \ factMap.remove(n);\n\t\t\treturn largeFact[(int)r];\n\t\t}\n\t}\n\tpublic final\
    \ long C(long n, long r) {\n\t\tif(!isFactPrepared) prepareFact();\n\t\tif(n <\
    \ 0) return mod(C(- n + r - 1, - n - 1) * ((r & 1) == 0 ? 1 : -1));\n\t\tif(r\
    \ < 0 || n < r) return 0;\n\t\tr = Math.min(r, n - r);\n\t\tif(n < MOD) return\
    \ mul(P(n, r), r < MAX_FACT1 ? invFact[(int)r] : inv(fact((int)r)));\n\n\t\tlong\
    \ ans = 1;\n\t\twhile(n > 0) {\n\t\t\tfinal long n2 = n / MOD;\n\t\t\tfinal long\
    \ r2 = r / MOD;\n\t\t\tans = mul(ans, C(n - n2 * MOD, r - r2 * MOD));\n\t\t\t\
    n = n2;\n\t\t\tr = r2;\n\t\t}\n\t\treturn ans;\n\t}\n\tpublic final long H(final\
    \ long n, final long r) { return C(n - 1 + r, r); }\n\n\tpublic final long sqrt(long\
    \ x) {\n\t\tx = mod(x);\n\t\tif(x < 2) return x;\n\t\tlong p = (MOD - 1) >> 1;\n\
    \t\tif(pow(x, p) != 1) return -1;\n\t\tlong q = MOD - 1;\n\t\tint m = 1;\n\t\t\
    while(((q >>= 1) & 1) == 0) m ++;\n\t\tlong z = 1;\n\t\twhile(pow(z, p) == 1)\
    \ z = (long)Math.floor(Math.random() * (MOD - 1)) + 1;\n\t\tlong c = pow(z, q);\n\
    \t\tlong t = pow(x, q);\n\t\tlong r = pow(x, (q + 1) >> 1);\n\t\tif(t == 0) return\
    \ 0;\n\t\tm -= 2;\n\t\twhile(t != 1) {\n\t\t\tlong pows[] = new long[m + 1];\n\
    \t\t\tpows[0] = t;\n\t\t\tfor(int i = 0; i < m; i ++) pows[i + 1] = mul(pows[i],\
    \ pows[i]);\n\t\t\twhile(pows[m --] == 1) c = mul(c, c);\n\t\t\tr = mul(r, c);\n\
    \t\t\tc = mul(c, c);\n\t\t\tt = mul(t, c);\n\t\t}\n\t\treturn Math.min(r, MOD\
    \ - r);\n\t}\n}\nfinal class Mod107 extends Mod {\n\tpublic static final Mod107\
    \ md = new Mod107();\n\tpublic static final long MOD = 1_000_000_007;\n\tprivate\
    \ Mod107() { super(MOD); }\n\n\t@Override\n\tpublic final long mod(long x) {\n\
    \t\tif(0 <= x && x < MOD) return x;\n\t\tif(- MOD <= x && x < 0) return x + MOD;\n\
    \t\treturn (x %= MOD) < 0 ? x + MOD : x;\n\t}\n\t@Override\n\tpublic final long\
    \ mul(long x, long y) {\n\t\tif(x >= 0 && x < MOD && y >= 0 && y < MOD) return\
    \ (x * y) % MOD;\n\t\tx = mod(x);\n\t\ty = mod(y);\n\t\treturn (x * y) % MOD;\n\
    \t}\n}\nfinal class Mod998 extends Mod {\n\tpublic static final Mod998 md = new\
    \ Mod998();\n\tpublic static final long MOD = 998_244_353;\n\tprivate Mod998()\
    \ { super(MOD); }\n\n\t@Override\n\tpublic final long mod(long x) {\n\t\tif(0\
    \ <= x && x < MOD) return x;\n\t\tif(- MOD <= x && x < 0) return x + MOD;\n\t\t\
    return (x %= MOD) < 0 ? x + MOD : x;\n\t}\n\t@Override\n\tpublic final long mul(long\
    \ x, long y) {\n\t\tif(x >= 0 && x < MOD && y >= 0 && y < MOD) return (x * y)\
    \ % MOD;\n\t\tx = mod(x);\n\t\ty = mod(y);\n\t\treturn (x * y) % MOD;\n\t}\n}\n\
    final class Mod754974721 extends Mod {\n\tpublic static final Mod754974721 md\
    \ = new Mod754974721();\n\tpublic static final long MOD = 754_974_721;\n\tprivate\
    \ Mod754974721() { super(MOD); }\n\n\t@Override\n\tpublic final long mod(long\
    \ x) {\n\t\tif(0 <= x && x < MOD) return x;\n\t\tif(- MOD <= x && x < 0) return\
    \ x + MOD;\n\t\treturn (x %= MOD) < 0 ? x + MOD : x;\n\t}\n\t@Override\n\tpublic\
    \ final long mul(long x, long y) {\n\t\tif(x >= 0 && x < MOD && y >= 0 && y <\
    \ MOD) return (x * y) % MOD;\n\t\tx = mod(x);\n\t\ty = mod(y);\n\t\treturn (x\
    \ * y) % MOD;\n\t}\n}\nfinal class Mod167772161 extends Mod {\n\tpublic static\
    \ final Mod167772161 md = new Mod167772161();\n\tpublic static final long MOD\
    \ = 167_772_161;\n\tprivate Mod167772161() { super(MOD); }\n\n\t@Override\n\t\
    public final long mod(long x) {\n\t\tif(0 <= x && x < MOD) return x;\n\t\tif(-\
    \ MOD <= x && x < 0) return x + MOD;\n\t\treturn (x %= MOD) < 0 ? x + MOD : x;\n\
    \t}\n\t@Override\n\tpublic final long mul(long x, long y) {\n\t\tif(x >= 0 &&\
    \ x < MOD && y >= 0 && y < MOD) return (x * y) % MOD;\n\t\tx = mod(x);\n\t\ty\
    \ = mod(y);\n\t\treturn (x * y) % MOD;\n\t}\n}\nfinal class Mod469762049 extends\
    \ Mod {\n\tpublic static final Mod469762049 md = new Mod469762049();\n\tpublic\
    \ static final long MOD = 469_762_049;\n\tprivate Mod469762049() { super(MOD);\
    \ }\n\n\t@Override\n\tpublic final long mod(long x) {\n\t\tif(0 <= x && x < MOD)\
    \ return x;\n\t\tif(- MOD <= x && x < 0) return x + MOD;\n\t\treturn (x %= MOD)\
    \ < 0 ? x + MOD : x;\n\t}\n\t@Override\n\tpublic final long mul(long x, long y)\
    \ {\n\t\tif(x >= 0 && x < MOD && y >= 0 && y < MOD) return (x * y) % MOD;\n\t\t\
    x = mod(x);\n\t\ty = mod(y);\n\t\treturn (x * y) % MOD;\n\t}\n}"
  dependsOn:
  - library/Util.java
  isVerificationFile: false
  path: library/Mod.java
  requiredBy:
  - library/Convolution.java
  - library/ExtendedConvolution.java
  - library/ArbitraryMod.java
  timestamp: '2022-09-17 23:18:18+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Mod998Random_test.java
  - library/Mod998ManyCombination_test.java
  - library/Mod107Pow_test.java
  - library/Mod107Random_test.java
  - library/Mod107ManyCombination_test.java
documentation_of: library/Mod.java
layout: document
redirect_from:
- /library/library/Mod.java
- /library/library/Mod.java.html
title: library/Mod.java
---
