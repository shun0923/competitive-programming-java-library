---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/FenwickTree_test.java
    title: library/FenwickTree_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/FenwickTree.java\n"
  code: "package library;\n\nimport library.SimpleUtil;\n\nclass FenwickTree {\n\t\
    int n;\n\tlong nodes[];\n\n\tFenwickTree(int n) { SimpleUtil.nonNegativeCheck(n);\
    \ init(n); } // O(N)\n\tFenwickTree(long[] a) { init(a.length); for(int i = 0;\
    \ i < n; i ++) add(i, a[i]); }// O(NlogN)\n\tvoid init(int n) {\n\t\tSimpleUtil.nonNegativeCheck(n);\n\
    \t\tthis.n = n;\n\t\tnodes = new long[n];\n\t}\n\n\tvoid add(int a, long x) {\
    \ // O(logN)\n\t\tSimpleUtil.rangeCheck(a, n);\n\t\ta ++;\n\t\twhile(a <= n) {\n\
    \t\t\tnodes[a - 1] += x;\n\t\t\ta += a & - a;\n\t\t}\n\t}\n\tlong sum(int r) {\
    \ // return sum of [0, r) // O(logN)\n\t\tSimpleUtil.inclusiveRangeCheck(r, n);\n\
    \t\tlong sum = 0;\n\t\twhile(r > 0) {\n\t\t\tsum += nodes[r - 1];\n\t\t\tr -=\
    \ r & - r;\n\t\t}\n\t\treturn sum;\n\t}\n\tlong sum(int l, int r) { // return\
    \ sum of [l, r) // O(logN)\n\t\tSimpleUtil.inclusiveRangeCheck(l, n);\n\t\tSimpleUtil.inclusiveRangeCheck(r,\
    \ n);\n\t\tif(l > r) return 0;\n\t\telse return sum(r) - sum(l);\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/FenwickTree.java
  requiredBy: []
  timestamp: '2022-09-20 15:30:32+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/FenwickTree_test.java
documentation_of: library/FenwickTree.java
layout: document
redirect_from:
- /library/library/FenwickTree.java
- /library/library/FenwickTree.java.html
title: library/FenwickTree.java
---
