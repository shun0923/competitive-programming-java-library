---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/FastIO.java
    title: library/FastIO.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/SparseTable_test.java
    title: library/SparseTable_test.java
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
  code: "package library;\n\nimport java.util.function.*;\nimport library.FastIO;\n\
    \nclass SparseTable {\n\tLongBinaryOperator f;\n\n\tint n;\n\tint m;\n\tlong table[][];\n\
    \n\tSparseTable(long[] a, LongBinaryOperator f) { // O(NlogN)\n\t\tthis.f = f;\n\
    \t\tn = a.length;\n\t\tm = 1;\n\t\twhile(1 << m < n) m ++;\n\t\ttable = new long[m][n];\n\
    \t\tfor(int i = 0; i < n; i ++) table[0][i] = a[i];\n\t\tfor(int i = 1; 1 << i\
    \ < n; i ++) {\n\t\t\tfor(int j = 1 << i; j < n + (1 << i); j += 1 << i + 1) {\n\
    \t\t\t\tfor(int k = 0; k < 1 << i && j + k < n; k ++) {\n\t\t\t\t\ttable[i][j\
    \ + k] = k == 0 ? a[j + k] : f.applyAsLong(table[i][j + k - 1], a[j + k]);\n\t\
    \t\t\t}\n\t\t\t\tint k0 = Math.max(1, j - n + 1);\n\t\t\t\tfor(int k = k0; k <=\
    \ 1 << i; k ++) {\n\t\t\t\t\ttable[i][j - k] = k == k0 ? a[j - k] : f.applyAsLong(a[j\
    \ - k], table[i][j - k + 1]);\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\n\tlong get(int\
    \ i) { FastIO.rangeCheck(i, n); return table[0][i]; } // O(1)\n\n\tlong find(int\
    \ l, int r) { // O(1)\n\t\tr --;\n\t\tFastIO.rangeCheck(l, n);\n\t\tFastIO.rangeCheck(r,\
    \ n);\n\t\tFastIO.assertion(l <= r, \"l is larger than r.\");\n\t\tint log = Long.numberOfTrailingZeros(Integer.highestOneBit(l\
    \ ^ r));\n\t\treturn l == r ? get(l) : f.applyAsLong(table[log][l], table[log][r]);\n\
    \t}\n}"
  dependsOn:
  - library/FastIO.java
  isVerificationFile: false
  path: library/SparseTable.java
  requiredBy: []
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/SparseTable_test.java
documentation_of: library/SparseTable.java
layout: document
redirect_from:
- /library/library/SparseTable.java
- /library/library/SparseTable.java.html
title: library/SparseTable.java
---
