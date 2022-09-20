---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: library/SparseTable_test.java
    title: library/SparseTable_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/SparseTable.java\n"
  code: "package library;\n\nimport library.SimpleUtil;\n\nclass SparseTable {\n\t\
    LongBinaryOperator f;\n\n\tint n;\n\tint m;\n\tlong table[][];\n\n\tSparseTable(long[]\
    \ a, LongBinaryOperator f) { // O(NlogN)\n\t\tthis.f = f;\n\t\tn = a.length;\n\
    \t\tm = 1;\n\t\twhile(1 << m < n) m ++;\n\t\ttable = new long[m][n];\n\t\tfor(int\
    \ i = 0; i < n; i ++) table[0][i] = a[i];\n\t\tfor(int i = 1; 1 << i < n; i ++)\
    \ {\n\t\t\tfor(int j = 1 << i; j < n + (1 << i); j += 1 << i + 1) {\n\t\t\t\t\
    for(int k = 0; k < 1 << i && j + k < n; k ++) {\n\t\t\t\t\ttable[i][j + k] = k\
    \ == 0 ? a[j + k] : f.applyAsLong(table[i][j + k - 1], a[j + k]);\n\t\t\t\t}\n\
    \t\t\t\tint k0 = Math.max(1, j - n + 1);\n\t\t\t\tfor(int k = k0; k <= 1 << i;\
    \ k ++) {\n\t\t\t\t\ttable[i][j - k] = k == k0 ? a[j - k] : f.applyAsLong(a[j\
    \ - k], table[i][j - k + 1]);\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\n\tlong get(int\
    \ i) { SimpleUtil.rangeCheck(i, n); return table[0][i]; } // O(1)\n\n\tlong find(int\
    \ l, int r) { // O(1)\n\t\tr --;\n\t\tSimpleUtil.rangeCheck(l, n);\n\t\tSimpleUtil.rangeCheck(r,\
    \ n);\n\t\tSimpleUtil.assertion(l <= r, \"l is larger than r.\");\n\t\tint log\
    \ = Long.numberOfTrailingZeros(Integer.highestOneBit(l ^ r));\n\t\treturn l ==\
    \ r ? get(l) : f.applyAsLong(table[log][l], table[log][r]);\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/SparseTable.java
  requiredBy: []
  timestamp: '2022-09-20 18:58:58+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - library/SparseTable_test.java
documentation_of: library/SparseTable.java
layout: document
redirect_from:
- /library/library/SparseTable.java
- /library/library/SparseTable.java.html
title: library/SparseTable.java
---
