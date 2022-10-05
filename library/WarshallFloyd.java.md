---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':heavy_check_mark:'
    path: library/PathRestoration.java
    title: library/PathRestoration.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/WarshallFloyd_reversed_test.java
    title: library/WarshallFloyd_reversed_test.java
  - icon: ':heavy_check_mark:'
    path: library/WarshallFloyd_test.java
    title: library/WarshallFloyd_test.java
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
    \ library.AbstractGraph;\nimport library.PathRestoration;\n\nfinal class WarshallFloyd\
    \ {\n\tprivate static int prv[][];\n\tprivate static WeightedEdge prvEdge[][];\n\
    \t// O(V^3)\n\tpublic static final long[][] dist(final WeightedGraph g) { return\
    \ dist(g, false); }\n\tpublic static final long[][] dist(final WeightedGraph g,\
    \ final boolean memoize) { return dist(g.numNode, g.directed, g.edges(), memoize);\
    \ }\n\tpublic static final long[][] dist(final int numNode, final boolean directed,\
    \ final WeightedNode edges) { return dist(numNode, directed, edges, false); }\n\
    \tpublic static final long[][] dist(final int numNode, final boolean directed,\
    \ final WeightedNode edges, final boolean memoize) {\n\t\tfinal long dist[][]\
    \ = new long[numNode][numNode];\n\t\tif(memoize) {\n\t\t\tprv = new int[numNode][numNode];\n\
    \t\t\tfor(int[] ele : prv) Arrays.fill(ele, -1);\n\t\t\tprvEdge = new WeightedEdge[numNode][numNode];\n\
    \t\t}\n\n\t\tfor(long[] ele : dist) Arrays.fill(ele, SimpleUtil.INF);\n\t\tfor(int\
    \ i = 0; i < numNode; i ++) dist[i][i] = 0;\n\t\tfor(WeightedEdge e : edges) updateDist(dist,\
    \ e, memoize);\n\t\tif(!directed) for(WeightedEdge e : edges) updateDist(dist,\
    \ e.reverse(), memoize);\n\t\tfor(int k = 0; k < numNode; k ++) {\n\t\t\tfor(int\
    \ i = 0; i < numNode; i ++) {\n\t\t\t\tfor(int j = 0; j < numNode; j ++) {\n\t\
    \t\t\t\tlong updated = dist[i][k] + dist[k][j];\n\t\t\t\t\tif(updated < dist[i][j])\
    \ dist[i][j] = updated;\n\t\t\t\t\tif(memoize) {\n\t\t\t\t\t\tprv[i][j] = prv[k][j];\n\
    \t\t\t\t\t\tprvEdge[i][j] = prvEdge[k][j];\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\
    \t}\n\t\treturn dist;\n\t}\n\tprivate static final void updateDist(final long[][]\
    \ dist, final WeightedEdge e, final boolean memoize) {\n\t\tif(dist[e.source][e.target]\
    \ > e.cost) {\n\t\t\tdist[e.source][e.target] = e.cost;\n\t\t\tif(memoize) {\n\
    \t\t\t\tprv[e.source][e.target] = e.source;\n\t\t\t\tprvEdge[e.source][e.target]\
    \ = e;\n\t\t\t}\n\t\t}\n\t}\n\n\tpublic static final int[] path(final int start,\
    \ final int goal) { return PathRestoration.path(prv[start], start, goal); }\n\t\
    public static final ArrayWeightedNode pathEdge(final int start, final int goal)\
    \ { return PathRestoration.pathEdge(new ArrayWeightedNode(-1), prv[start], prvEdge[start],\
    \ start, goal); }\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  - library/PathRestoration.java
  isVerificationFile: false
  path: library/WarshallFloyd.java
  requiredBy: []
  timestamp: '2022-10-05 20:31:46+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/WarshallFloyd_reversed_test.java
  - library/WarshallFloyd_test.java
documentation_of: library/WarshallFloyd.java
layout: document
redirect_from:
- /library/library/WarshallFloyd.java
- /library/library/WarshallFloyd.java.html
title: library/WarshallFloyd.java
---
