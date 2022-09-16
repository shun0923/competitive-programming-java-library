---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryMod_test.java
    title: library/ArbitraryMod_test.java
  - icon: ':heavy_check_mark:'
    path: library/FastIO_test.java
    title: library/FastIO_test.java
  - icon: ':heavy_check_mark:'
    path: library/FastInputStream.java
    title: library/FastInputStream.java
  - icon: ':heavy_check_mark:'
    path: library/FastOutputStream.java
    title: library/FastOutputStream.java
  - icon: ':heavy_check_mark:'
    path: library/HelloWorld_test.java
    title: library/HelloWorld_test.java
  - icon: ':heavy_check_mark:'
    path: library/ManyFastIO_test.java
    title: library/ManyFastIO_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':heavy_check_mark:'
    path: library/Mod107_test.java
    title: library/Mod107_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod998_test.java
    title: library/Mod998_test.java
  - icon: ':heavy_check_mark:'
    path: library/Util.java
    title: library/Util.java
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: library/FastInputStream.java
    title: library/FastInputStream.java
  - icon: ':heavy_check_mark:'
    path: library/FastOutputStream.java
    title: library/FastOutputStream.java
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':heavy_check_mark:'
    path: library/Util.java
    title: library/Util.java
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryMod_test.java
    title: library/ArbitraryMod_test.java
  - icon: ':heavy_check_mark:'
    path: library/FastIO_test.java
    title: library/FastIO_test.java
  - icon: ':heavy_check_mark:'
    path: library/HelloWorld_test.java
    title: library/HelloWorld_test.java
  - icon: ':heavy_check_mark:'
    path: library/ManyFastIO_test.java
    title: library/ManyFastIO_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod107_test.java
    title: library/Mod107_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod998_test.java
    title: library/Mod998_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/ArbitraryMod.java\n"
  code: "package library;\n\nimport library.Mod;\n\nfinal class ArbitraryMod extends\
    \ Mod {\n\tprivate static final long MASK = 0xffff_ffffl;\n\tprivate final long\
    \ MH;\n\tprivate final long ML;\n\tpublic ArbitraryMod(long mod) { super(mod);\
    \ long a = (1l << 32) / MOD; long b = (1l << 32) % MOD; long m = a * a * MOD +\
    \ 2 * a * b + (b * b) / MOD; MH = m >>> 32; ML = m & MASK; }\n\n\tprivate final\
    \ long reduce(long x) {\n\t\tif(MOD == 1) return 0;\n\t\tif(x < 0) return (x =\
    \ reduce(- x)) == 0 ? 0 : MOD - x;\n\t\tlong z = (x & MASK) * ML;\n\t\tz = (x\
    \ & MASK) * MH + (x >>> 32) * ML + (z >>> 32);\n\t\tz = (x >>> 32) * MH + (z >>>\
    \ 32);\n\t\tx -= z * MOD;\n\t\treturn x < MOD ? x : x - MOD;\n\t}\n\t@Override\n\
    \tpublic long mod(long x) {\n\t\tif(0 <= x && x < MOD) return x;\n\t\tif(- MOD\
    \ <= x && x < 0) return x + MOD;\n\t\treturn reduce(x);\n\t}\n\t@Override\n\t\
    public long mul(long x, long y) {\n\t\tif(x >= 0 && x < MOD && y >= 0 && y < MOD)\
    \ return reduce(x * y);\n\t\tx = mod(x);\n\t\ty = mod(y);\n\t\treturn reduce(x\
    \ * y);\n\t}\n}"
  dependsOn:
  - library/HelloWorld_test.java
  - library/ArbitraryMod_test.java
  - library/Util.java
  - library/FastInputStream.java
  - library/ManyFastIO_test.java
  - library/Mod998_test.java
  - library/FastIO_test.java
  - library/FastOutputStream.java
  - library/Mod.java
  - library/Mod107_test.java
  isVerificationFile: false
  path: library/ArbitraryMod.java
  requiredBy:
  - library/Util.java
  - library/FastInputStream.java
  - library/FastOutputStream.java
  - library/Mod.java
  timestamp: '2022-09-17 01:02:57+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/HelloWorld_test.java
  - library/ArbitraryMod_test.java
  - library/ManyFastIO_test.java
  - library/Mod998_test.java
  - library/FastIO_test.java
  - library/Mod107_test.java
documentation_of: library/ArbitraryMod.java
layout: document
redirect_from:
- /library/library/ArbitraryMod.java
- /library/library/ArbitraryMod.java.html
title: library/ArbitraryMod.java
---
