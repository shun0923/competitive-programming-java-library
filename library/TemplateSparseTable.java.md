---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/TemplateSparseTable_test.java
    title: library/TemplateSparseTable_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/TemplateSparseTable.java\n"
  code: "package library;\n\nimport java.util.function.*;\nimport library.SimpleUtil;\n\
    \nclass TemplateSparseTable<T> {\n\tBinaryOperator<T> f;\n\n\tint n;\n\tint m;\n\
    \tT table[][];\n\n\t@SuppressWarnings(\"unchecked\")\n\tTemplateSparseTable(T[]\
    \ a, BinaryOperator<T> f) { // O(NlogN)\n\t\tthis.f = f;\n\t\tn = a.length;\n\t\
    \tm = 1;\n\t\twhile(1 << m < n) m ++;\n\t\ttable = (T[][]) new Object[m][n];\n\
    \t\tfor(int i = 0; i < n; i ++) table[0][i] = a[i];\n\t\tfor(int i = 1; 1 << i\
    \ < n; i ++) {\n\t\t\tfor(int j = 1 << i; j < n + (1 << i); j += 1 << i + 1) {\n\
    \t\t\t\tfor(int k = 0; k < 1 << i && j + k < n; k ++) {\n\t\t\t\t\ttable[i][j\
    \ + k] = k == 0 ? a[j + k] : f.apply(table[i][j + k - 1], a[j + k]);\n\t\t\t\t\
    }\n\t\t\t\tint k0 = Math.max(1, j - n + 1);\n\t\t\t\tfor(int k = k0; k <= 1 <<\
    \ i; k ++) {\n\t\t\t\t\ttable[i][j - k] = k == k0 ? a[j - k] : f.apply(a[j - k],\
    \ table[i][j - k + 1]);\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\n\tT get(int i) { SimpleUtil.rangeCheck(i,\
    \ n); return table[0][i]; } // O(1)\n\n\tT find(int l, int r) { // O(1)\n\t\t\
    r --;\n\t\tSimpleUtil.rangeCheck(l, n);\n\t\tSimpleUtil.rangeCheck(r, n);\n\t\t\
    SimpleUtil.assertion(l <= r, \"l is larger than r.\");\n\t\tint log = Long.numberOfTrailingZeros(Integer.highestOneBit(l\
    \ ^ r));\n\t\treturn l == r ? get(l) : f.apply(table[log][l], table[log][r]);\n\
    \t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/TemplateSparseTable.java
  requiredBy: []
  timestamp: '2022-09-20 19:18:27+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/TemplateSparseTable_test.java
documentation_of: library/TemplateSparseTable.java
layout: document
redirect_from:
- /library/library/TemplateSparseTable.java
- /library/library/TemplateSparseTable.java.html
title: library/TemplateSparseTable.java
---