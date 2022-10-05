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
    path: library/WeightedDoubling_test.java
    title: library/WeightedDoubling_test.java
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
  code: "package library;\n\nimport java.util.*;\nimport java.util.function.*;\nimport\
    \ library.SimpleUtil;\nimport library.AbstractGraph;\n\nfinal class WeightedDoubling\
    \ {\n\tprivate final long id;\n\tprivate final LongBinaryOperator f;\n\tpublic\
    \ final int n;\n\tpublic final int log;\n\tpublic final int next[][];\n\tpublic\
    \ final long val[][];\n\n\tprivate WeightedDoubling(final int n, final long max,\
    \ final long id, final LongBinaryOperator f) { // O(1)\n\t\tSimpleUtil.nonNegativeCheck(n);\n\
    \t\tSimpleUtil.nonNegativeCheck(max);\n\t\tthis.id = id;\n\t\tthis.f = f;\n\t\t\
    this.n = n;\n\t\tlog = Long.numberOfTrailingZeros(Long.highestOneBit(max)) + 1;\n\
    \t\tnext = new int[log][n];\n\t\tval = new long[log][n];\n\t\tArrays.fill(next[0],\
    \ -1);\n\t}\n\t// O(NlogM)\n\tpublic WeightedDoubling(final int n, final long\
    \ max, final long id, final LongBinaryOperator f, final WeightedNode edges) {\n\
    \t\tthis(n, max, id, f);\n\t\tfor(WeightedEdge e : edges) {\n\t\t\tnext[0][e.source]\
    \ = e.target;\n\t\t\tval[0][e.source] = e.cost;\n\t\t}\n\t\tinit();\n\t}\n\tprivate\
    \ final void init() {\n\t\tfor(int k = 0; k + 1 < log; k ++) {\n\t\t\tfor(int\
    \ v = 0; v < n; v ++) {\n\t\t\t\tif(next[k][v] == -1) {\n\t\t\t\t\tnext[k + 1][v]\
    \ = -1;\n\t\t\t\t\tval[k + 1][v] = id;\n\t\t\t\t}else {\n\t\t\t\t\tnext[k + 1][v]\
    \ = next[k][next[k][v]];\n\t\t\t\t\tval[k + 1][v] = f.applyAsLong(val[k][v], val[k][next[k][v]]);\n\
    \t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\n\tWeightedEdge cal(int x, final long q) { //\
    \ O(logQ)\n\t\tSimpleUtil.rangeCheck(x, n);\n\t\tSimpleUtil.nonNegativeCheck(q);\n\
    \t\tWeightedEdge e = new WeightedEdge(x, x, id);\n\t\tfor(int k = log - 1; k >=\
    \ 0; k --) {\n\t\t\tif(e.target == -1) { e.cost = id; break; }\n\t\t\tif((q &\
    \ 1l << k) != 0) {\n\t\t\t\te.cost = f.applyAsLong(e.cost, val[k][e.target]);\n\
    \t\t\t\te.target = next[k][e.target];\n\t\t\t}\n\t\t}\n\t\treturn e;\n\t}\n\n\t\
    long bisect(int x, long q) { // O(logM)\n\t\tSimpleUtil.rangeCheck(x, n);\n\t\t\
    long ans = 0;\n\t\tWeightedEdge e = new WeightedEdge(x, x, id);\n\t\tfor(int k\
    \ = log - 1; k >= 0; k --) {\n\t\t\tif(e.target == -1) return -1;\n\t\t\tlong\
    \ tmp = f.applyAsLong(e.cost, val[k][e.target]);\n\t\t\tif(tmp <= q) {\n\t\t\t\
    \te.cost = tmp;\n\t\t\t\te.target = next[k][e.target];\n\t\t\t\tans |= 1l << k;\n\
    \t\t\t}\n\t\t}\n\t\treturn ans;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/WeightedDoubling.java
  requiredBy: []
  timestamp: '2022-10-05 21:11:17+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/WeightedDoubling_test.java
documentation_of: library/WeightedDoubling.java
layout: document
redirect_from:
- /library/library/WeightedDoubling.java
- /library/library/WeightedDoubling.java.html
title: library/WeightedDoubling.java
---
