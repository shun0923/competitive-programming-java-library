---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Convolution.java
    title: library/Convolution.java
  - icon: ':question:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/Convolution107_test.java
    title: library/Convolution107_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/ExtendedConvolution.java\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\nimport\
    \ library.Mod;\nimport library.Convolution;\n\nabstract class ExtendedConvolution\
    \ {\n\tprotected static final long MOD1 = 754974721; // 2^24\n\tprotected static\
    \ final long MOD2 = 167772161; // 2^25\n\tprotected static final long MOD3 = 469762049;\
    \ // 2^26\n\tprotected static final long M2M3 = MOD2 * MOD3;\n\tprotected static\
    \ final long M1M3 = MOD1 * MOD3;\n\tprotected static final long M1M2 = MOD1 *\
    \ MOD2;\n\tprotected static final long M1M2M3 = MOD1 * MOD2 * MOD3;\n\tprotected\
    \ static final long M1INVM2 = 95869806; // inv(MOD1, MOD2);\n\tprotected static\
    \ final long INV1 = 190329765; // inv(MOD2 * MOD3, MOD1);\n\tprotected static\
    \ final long INV2 = 58587104; // inv(MOD1 * MOD3, MOD2);\n\tprotected static final\
    \ long INV3 = 187290749; // inv(MOD1 * MOD2, MOD3);\n\tprotected final Mod MD1\
    \ = Mod754974721.md;\n\tprotected final Mod MD2 = Mod167772161.md;\n\tprotected\
    \ final Mod MD3 = Mod469762049.md;\n\tprotected final Convolution cnv1 = Convolution754974721.cnv;\n\
    \tprotected final Convolution cnv2 = Convolution167772161.cnv;\n\tprotected final\
    \ Convolution cnv3 = Convolution469762049.cnv;\n\n\tpublic final long[] cnv(final\
    \ long[] a, final long[] b) { return cnv(a, b, Math.max(0, a.length + b.length\
    \ - 1)); }\n\tpublic abstract long[] cnv(final long[] a, final long[] b, final\
    \ int l);\n}\nfinal class ArbitraryConvolution extends ExtendedConvolution {\n\
    \tprivate final Mod md;\n\tpublic ArbitraryConvolution(final Mod md) { this.md\
    \ = md; }\n\t// O((N_1+N_2)log(N_1+N_2))\n\t@Override\n\tpublic final long[] cnv(final\
    \ long[] a, final long[] b, final int l) {\n\t\tSimpleUtil.nonNegativeCheck(l);\n\
    \t\tfinal long M1M2MOD = md.mod(MOD1 * MOD2);\n\n\t\tif(a.length == 0 || b.length\
    \ == 0) return new long[l];\n\t\tlong f1[] = cnv1.cnv(a, b, l);\n\t\tlong f2[]\
    \ = cnv2.cnv(a, b, l);\n\t\tlong f3[] = cnv3.cnv(a, b, l);\n\n\t\tlong f[] = new\
    \ long[l];\n\t\tfor(int i = 0; i < Math.min(l, a.length + b.length - 1); i ++)\
    \ {\n\t\t\tlong v1 = MD2.mod((f2[i] - f1[i]) * M1INVM2);\n\t\t\tlong v2 = MD3.mod(MD3.mod(f3[i]\
    \ - f1[i] - MOD1 * v1) * INV3);\n\t\t\tf[i] = md.mod(f1[i] + MOD1 * v1 + M1M2MOD\
    \ * v2);\n\t\t}\n\t\treturn f;\n\t}\n}\nfinal class LongConvolution extends ExtendedConvolution\
    \ {\n\tpublic static final LongConvolution cnv = new LongConvolution();\n\t@Override\n\
    \tpublic final long[] cnv(final long[] a, final long[] b, final int l) {\n\t\t\
    SimpleUtil.nonNegativeCheck(l);\n\t\tif(a.length == 0 || b.length == 0) return\
    \ new long[l];\n\n\t\tlong f1[] = cnv1.cnv(a, b);\n\t\tlong f2[] = cnv2.cnv(a,\
    \ b);\n\t\tlong f3[] = cnv3.cnv(a, b);\n\n\t\tlong f[] = new long[l];\n\t\tfor(int\
    \ i = 0; i < Math.min(l, a.length + b.length - 1); i ++) {\n\t\t\tlong x = 0;\n\
    \t\t\tx += (f1[i] * INV1) % MOD1 * M2M3;\n\t\t\tx += (f2[i] * INV2) % MOD2 * M1M3;\n\
    \t\t\tx += (f3[i] * INV3) % MOD3 * M1M2;\n\t\t\tlong diff = f1[i] - (x % MOD1);\n\
    \t\t\tif(diff < 0) diff += MOD1;\n\t\t\tlong offset[] = {0, 0, M1M2M3, 2 * M1M2M3,\
    \ 3 * M1M2M3};\n\t\t\tx -= offset[(int)(diff % 5)];\n\t\t\tf[i] = x;\n\t\t}\n\t\
    \treturn f;\n\t}\n}\nfinal class Convolution107 extends ExtendedConvolution {\n\
    \tpublic static final Convolution107 cnv = new Convolution107();\n\tprivate static\
    \ final long M1M2MOD = MOD1 * MOD2 % 1_000_000_007;\n\t@Override\n\tpublic final\
    \ long[] cnv(final long[] a, final long[] b, final int l) {\n\t\tSimpleUtil.nonNegativeCheck(l);\n\
    \n\t\tif(a.length == 0 || b.length == 0) return new long[l];\n\n\t\tlong f1[]\
    \ = cnv1.cnv(a, b, l);\n\t\tlong f2[] = cnv2.cnv(a, b, l);\n\t\tlong f3[] = cnv3.cnv(a,\
    \ b, l);\n\n\t\tlong f[] = new long[l];\n\t\tfor(int i = 0; i < Math.min(l, a.length\
    \ + b.length - 1); i ++) {\n\t\t\tlong v1 = (f2[i] - f1[i]) * M1INVM2 % MOD2;\
    \ if(v1 < 0) v1 += MOD2;\n\t\t\tlong v2 = (f3[i] - f1[i] - MOD1 * v1) % MOD3 *\
    \ INV3 % MOD3; if(v2 < 0) v2 += MOD3;\n\t\t\tf[i] = (f1[i] + MOD1 * v1 + M1M2MOD\
    \ * v2) % 1_000_000_007;\n\t\t}\n\t\treturn f;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/Mod.java
  - library/Convolution.java
  isVerificationFile: false
  path: library/ExtendedConvolution.java
  requiredBy: []
  timestamp: '2022-09-20 15:28:33+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Convolution107_test.java
documentation_of: library/ExtendedConvolution.java
layout: document
redirect_from:
- /library/library/ExtendedConvolution.java
- /library/library/ExtendedConvolution.java.html
title: library/ExtendedConvolution.java
---
