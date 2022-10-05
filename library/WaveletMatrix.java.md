---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/BitVector.java
    title: library/BitVector.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: library/CompressedWaveletMatrix.java
    title: library/CompressedWaveletMatrix.java
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/WaveletMatrix_freq_test.java
    title: library/WaveletMatrix_freq_test.java
  - icon: ':heavy_check_mark:'
    path: library/WaveletMatrix_smallest_test.java
    title: library/WaveletMatrix_smallest_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport library.SimpleUtil;\nimport library.BitVector;\n\
    \nclass WaveletMatrix {\n\tfinal int bitSize;\n\tfinal int n;\n\tBitVector mat[];\n\
    \tint mid[];\n\tfinal int max;\n\n\t// O(NlogA)\n\tWaveletMatrix(int[] a) {\n\t\
    \tn = a.length;\n\t\tlong tmp = 1;\n\t\tfor(int i = 0; i < n; i ++) tmp = Math.max(tmp,\
    \ a[i]);\n\t\tbitSize = n == 0 ? 1 : Long.numberOfTrailingZeros(Long.highestOneBit(tmp))\
    \ + 1;\n\t\tmax = 1 << bitSize;\n\t\tmat = new BitVector[bitSize];\n\t\tmid =\
    \ new int[bitSize];\n\t\tfor(int i = bitSize - 1; i >= 0; i --) {\n\t\t\tmat[i]\
    \ = new BitVector(n);\n\t\t\tint a2[] = new int[n];\n\t\t\tint idx = 0;\n\t\t\t\
    for(int j = 0; j < n; j ++) if((a[j] >> i & 1) == 0) a2[idx ++] = a[j];\n\t\t\t\
    mid[i] = idx;\n\t\t\tfor(int j = 0; j < n; j ++) if((a[j] >> i & 1) != 0) { a2[idx\
    \ ++] = a[j]; mat[i].set(j); }\n\t\t\ta = a2;\n\t\t\tmat[i].init();\n\t\t}\n\t\
    }\n\n\t// Query: O(logVloglogN)\n\n\t// a_i\n\tfinal int get(int k) {\n\t\tSimpleUtil.rangeCheck(k,\
    \ n);\n\t\tint val = 0;\n\t\tfor(int i = bitSize - 1; i >= 0; i --) {\n\t\t\t\
    boolean b = mat[i].get(k);\n\t\t\tk = mat[i].rank(b, k);\n\t\t\tif(b) { val |=\
    \ 1 << i; k += mid[i]; }\n\t\t}\n\t\treturn val;\n\t}\n\n\t// count x in [0, k)\n\
    \tfinal int rank(int x, int k) { return rank(x, 0, k); }\n\t// count x in [l,\
    \ r)\n\tfinal int rank(int x, int l, int r) {\n\t\tSimpleUtil.inclusiveRangeCheck(l,\
    \ n);\n\t\tSimpleUtil.inclusiveRangeCheck(r, n);\n\t\tSimpleUtil.assertion(l <=\
    \ r);\n\t\tif(x < 0 || x >= max) return 0;\n\t\tfor(int i = bitSize - 1; i >=\
    \ 0; i --) {\n\t\t\tboolean b = (x >> i & 1) != 0;\n\t\t\tl = mat[i].rank(b, l);\
    \ if(b) l += mid[i];\n\t\t\tr = mat[i].rank(b, r); if(b) r += mid[i];\n\t\t}\n\
    \t\treturn r - l;\n\t}\n\n\t// position of k-th occurrence of x\n\tfinal int select(int\
    \ x, int k) {\n\t\tSimpleUtil.nonNegativeCheck(k);\n\t\tif(x < 0 || x >= max)\
    \ return n;\n\t\tint l[] = new int[bitSize + 1];\n\t\tint l2[] = new int[bitSize\
    \ + 1];\n\t\tint r = n;\n\t\tl[bitSize] = 0;\n\t\tfor(int i = bitSize - 1; i >=\
    \ 0; i --) {\n\t\t\tboolean b = (x >> i & 1) != 0;\n\t\t\tl2[i] = mat[i].rank(b,\
    \ l[i + 1]);\n\t\t\tl[i] = l2[i];\n\t\t\tif(b) l[i] += mid[i];\n\t\t\tr = mat[i].rank(b,\
    \ r);\n\t\t\tif(b) r += mid[i];\n\t\t}\n\t\tif(r - l[0] <= k) return n;\n\t\t\
    for(int i = 0; i < bitSize; i ++) k = mat[i].select((x >> i & 1) != 0, k + l2[i])\
    \ - l[i + 1];\n\t\treturn k;\n\t}\n\n\t// k-th smallest in [l, r)\n\tfinal int\
    \ smallest(int l, int r, int k) {\n\t\tSimpleUtil.nonNegativeCheck(k);\n\t\tSimpleUtil.rangeCheck(l,\
    \ n);\n\t\tSimpleUtil.inclusiveRangeCheck(r, n);\n\t\tSimpleUtil.assertion(k <\
    \ r - l);\n\t\tint val = 0;\n\t\tfor(int i = bitSize - 1; i >= 0; i --) {\n\t\t\
    \tint l2 = mat[i].rank(false, l);\n\t\t\tint r2 = mat[i].rank(false, r);\n\t\t\
    \tif(k < r2 - l2) {\n\t\t\t\tl = l2;\n\t\t\t\tr = r2;\n\t\t\t}else {\n\t\t\t\t\
    l += mid[i] - l2;\n\t\t\t\tr += mid[i] - r2;\n\t\t\t\tval |= 1 << i;\n\t\t\t\t\
    k -= r2 - l2;\n\t\t\t}\n\t\t}\n\t\treturn val;\n\t}\n\t// k-th largest in [l,\
    \ r)\n\tfinal int largest(int l, int r, int k) { return smallest(l, r, r - l -\
    \ k - 1); }\n\n\t// count [0, x) in [l, r)\n\tfinal int lessFreq(int x, int l,\
    \ int r) {\n\t\tSimpleUtil.inclusiveRangeCheck(l, n);\n\t\tSimpleUtil.inclusiveRangeCheck(r,\
    \ n);\n\t\tSimpleUtil.assertion(l <= r);\n\t\tif(x < 0) return 0;\n\t\tif(x >=\
    \ max) return r - l;\n\t\tint cnt = 0;\n\t\tfor(int i = bitSize - 1; i >= 0; i\
    \ --) {\n\t\t\tboolean b = (x >> i & 1) != 0;\n\t\t\tint l2 = mat[i].rank(b, l);\n\
    \t\t\tint r2 = mat[i].rank(b, r);\n\t\t\tif(b) cnt += r + l2 - r2 - l;\n\t\t\t\
    l = l2; if(b) l += mid[i];\n\t\t\tr = r2; if(b) r += mid[i];\n\t\t}\n\t\treturn\
    \ cnt;\n\t}\n\t// count [x, ) in [l, r)\n\tfinal int greaterFreq(int x, int l,\
    \ int r) { return r - l - lessFreq(x, l, r); }\n\t// count [lower, upper) in [l,\
    \ r)\n\tfinal int rangeFreq(int lower, int upper, int l, int r) { return lessFreq(upper,\
    \ l, r) - lessFreq(lower, l, r); }\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/BitVector.java
  isVerificationFile: false
  path: library/WaveletMatrix.java
  requiredBy:
  - library/CompressedWaveletMatrix.java
  timestamp: '2022-10-05 21:11:17+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/WaveletMatrix_freq_test.java
  - library/WaveletMatrix_smallest_test.java
documentation_of: library/WaveletMatrix.java
layout: document
redirect_from:
- /library/library/WaveletMatrix.java
- /library/library/WaveletMatrix.java.html
title: library/WaveletMatrix.java
---
