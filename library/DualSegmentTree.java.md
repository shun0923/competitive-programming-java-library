---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/DualSegmentTree_test.java
    title: library/DualSegmentTree_test.java
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
  code: "package library;\n\nimport java.util.*;\nimport java.util.function.*;\nimport\
    \ library.SimpleUtil;\n\nclass DualSegmentTree {\n\tlong e2;\n\tLongBinaryOperator\
    \ g;\n\n\tint n;\n\tint height;\n\tlong lazy[];\n\tint rangeL[];\n\tint rangeR[];\n\
    \n\t// O(N)\n\tDualSegmentTree(long[] a, long e2, LongBinaryOperator g) {\n\t\t\
    this(a.length, e2, g);\n\t\tSystem.arraycopy(a, 0, lazy, n, a.length);\n\t}\n\t\
    DualSegmentTree(int len, long x, long e2, LongBinaryOperator g) {\n\t\tthis(len,\
    \ e2, g);\n\t\tSimpleUtil.nonNegativeCheck(len);\n\t\tArrays.fill(lazy, n, n +\
    \ len, x);\n\t}\n\tDualSegmentTree(int len, long e2, LongBinaryOperator g) {\n\
    \t\tSimpleUtil.nonNegativeCheck(len);\n\t\tthis.e2 = e2;\n\t\tthis.g = g;\n\t\t\
    n = 1;\n\t\theight = 0;\n\t\twhile(n < len) { n <<= 1; height ++; }\n\t\tlazy\
    \ = new long[n << 1];\n\t\tArrays.fill(lazy, e2);\n\t\trangeL = new int[n << 1];\n\
    \t\trangeR = new int[n << 1];\n\t\tfor(int i = 0; i < n; i ++) { rangeL[i + n]\
    \ = i; rangeR[i + n] = i + 1; }\n\t\tfor(int i = n - 1; i > 0; i --) { rangeL[i]\
    \ = rangeL[i << 1]; rangeR[i] = rangeR[(i << 1) + 1]; }\n\t}\n\n\tvoid eval(int\
    \ k) { // O(1)\n\t\tif(lazy[k] != e2) {\n\t\t\tif(k < n) {\n\t\t\t\tlazy[k <<\
    \ 1] = g.applyAsLong(lazy[k << 1], lazy[k]);\n\t\t\t\tlazy[(k << 1) + 1] = g.applyAsLong(lazy[(k\
    \ << 1) + 1], lazy[k]);\n\t\t\t\tlazy[k] = e2;\n\t\t\t}\n\t\t}\n\t}\n\n\tvoid\
    \ update(int l, int r, long val) { // O(logN)\n\t\tSimpleUtil.inclusiveRangeCheck(l,\
    \ n);\n\t\tSimpleUtil.inclusiveRangeCheck(r, n);\n\t\tSimpleUtil.assertion(l <=\
    \ r, \"l is larger than r.\");\n\t\tl += n; r += n - 1;\n\t\tfor(int i = height;\
    \ i > 0; i --) { eval(l >> i); eval(r >> i); }\n\t\tr ++;\n\t\twhile(l < r) {\n\
    \t\t\tif((l & 1) != 0) { lazy[l] = g.applyAsLong(lazy[l], val); eval(l); l ++;\
    \ }\n\t\t\tif((r & 1) != 0) { r --; lazy[r] = g.applyAsLong(lazy[r], val); eval(r);\
    \ }\n\t\t\tl >>= 1; r >>= 1;\n\t\t}\n\t}\n\n\tlong get(int j) { // O(logN)\n\t\
    \tSimpleUtil.inclusiveRangeCheck(j, n);\n\t\tj += n;\n\t\tfor(int i = height;\
    \ i > 0; i --) eval(j >> i);\n\t\treturn lazy[j];\n\t}\n}"
  dependsOn: []
  isVerificationFile: false
  path: library/DualSegmentTree.java
  requiredBy: []
  timestamp: '2023-03-23 19:02:13+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/DualSegmentTree_test.java
documentation_of: library/DualSegmentTree.java
layout: document
redirect_from:
- /library/library/DualSegmentTree.java
- /library/library/DualSegmentTree.java.html
title: library/DualSegmentTree.java
---
