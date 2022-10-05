---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/Doubling_test.java
    title: library/Doubling_test.java
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
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\nimport\
    \ library.AbstractGraph;\n\nfinal class Doubling {\n\tpublic final int n;\n\t\
    public final int log;\n\tpublic final int next[][];\n\n\tprivate Doubling(final\
    \ int n, final long max) { // O(1)\n\t\tSimpleUtil.nonNegativeCheck(n);\n\t\t\
    SimpleUtil.nonNegativeCheck(max);\n\t\tthis.n = n;\n\t\tlog = Long.numberOfTrailingZeros(Long.highestOneBit(max))\
    \ + 1;\n\t\tnext = new int[log][n];\n\t\tArrays.fill(next[0], -1);\n\t}\n\t//\
    \ O(NlogM)\n\tpublic Doubling(final int n, final long max, final int[] edges)\
    \ {\n\t\tthis(n, max);\n\t\tSystem.arraycopy(edges, 0, next[0], 0, n);\n\t\tinit();\n\
    \t}\n\tpublic Doubling(final int n, final long max, final AbstractNode<? extends\
    \ AbstractEdge> edges) {\n\t\tthis(n, max);\n\t\tfor(AbstractEdge e : edges) next[0][e.source]\
    \ = e.target;\n\t\tinit();\n\t}\n\tprivate final void init() {\n\t\tfor(int k\
    \ = 0; k + 1 < log; k ++) {\n\t\t\tfor(int v = 0; v < n; v ++) {\n\t\t\t\tif(next[k][v]\
    \ == -1) next[k + 1][v] = -1;\n\t\t\t\telse next[k + 1][v] = next[k][next[k][v]];\n\
    \t\t\t}\n\t\t}\n\t}\n\n\tint cal(int x, final long q) { // O(logQ)\n\t\tSimpleUtil.rangeCheck(x,\
    \ n);\n\t\tSimpleUtil.nonNegativeCheck(q);\n\t\tfor(int k = log - 1; k >= 0; k\
    \ --) {\n\t\t\tif(x == -1) break;\n\t\t\tif((q & 1l << k) != 0) x = next[k][x];\n\
    \t\t}\n\t\treturn x;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/Doubling.java
  requiredBy: []
  timestamp: '2022-10-05 21:11:17+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Doubling_test.java
documentation_of: library/Doubling.java
layout: document
redirect_from:
- /library/library/Doubling.java
- /library/library/Doubling.java.html
title: library/Doubling.java
---
