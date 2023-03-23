---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':warning:'
    path: library/FastIO.java
    title: library/FastIO.java
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
  code: "package library;\n\nimport java.util.*;\nimport library.FastIO;\nimport library.AbstractGraph;\n\
    \nfinal class WarshallFloyd {\n\t// O(V^3)\n\tpublic static final <Graph extends\
    \ AbstractGraph<? extends WeightedNode, WeightedEdge>> long[][] dist(final Graph\
    \ g) { return dist(g, null, null); }\n\tpublic static final <Graph extends AbstractGraph<?\
    \ extends WeightedNode, WeightedEdge>> long[][] dist(final Graph g, final int[][]\
    \ prv) { return dist(g, prv, null); }\n\tpublic static final <Graph extends AbstractGraph<?\
    \ extends WeightedNode, WeightedEdge>> long[][] dist(final Graph g, final int[][]\
    \ prv, final WeightedEdge[][] prvEdge) { return dist(g.numNode, g.directed, g.edges(),\
    \ prv, prvEdge); }\n\tpublic static final long[][] dist(final int numNode, final\
    \ boolean directed, final WeightedNode edges) { return dist(numNode, directed,\
    \ edges, null, null); }\n\tpublic static final long[][] dist(final int numNode,\
    \ final boolean directed, final WeightedNode edges, final int[][] prv) { return\
    \ dist(numNode, directed, edges, prv, null); }\n\tpublic static final long[][]\
    \ dist(final int numNode, final boolean directed, final WeightedNode edges, final\
    \ int[][] prv, final WeightedEdge[][] prvEdge) {\n\t\tfinal long dist[][] = new\
    \ long[numNode][numNode];\n\t\tif(prv != null) for(int[] ele : prv) Arrays.fill(ele,\
    \ -1);\n\n\t\tfor(long[] ele : dist) Arrays.fill(ele, FastIO.INF);\n\t\tfor(int\
    \ i = 0; i < numNode; i ++) dist[i][i] = 0;\n\t\tfor(WeightedEdge e : edges) updateDist(dist,\
    \ e, prv, prvEdge);\n\t\tif(!directed) for(WeightedEdge e : edges) updateDist(dist,\
    \ e.reverse(), prv, prvEdge);\n\t\tfor(int k = 0; k < numNode; k ++) {\n\t\t\t\
    for(int i = 0; i < numNode; i ++) {\n\t\t\t\tfor(int j = 0; j < numNode; j ++)\
    \ {\n\t\t\t\t\tlong updated = dist[i][k] + dist[k][j];\n\t\t\t\t\tif(updated <\
    \ dist[i][j]) dist[i][j] = updated;\n\t\t\t\t\tif(prv != null) prv[i][j] = prv[k][j];\n\
    \t\t\t\t\tif(prvEdge != null) prvEdge[i][j] = prvEdge[k][j];\n\t\t\t\t}\n\t\t\t\
    }\n\t\t}\n\t\treturn dist;\n\t}\n\tprivate static final void updateDist(final\
    \ long[][] dist, final WeightedEdge e, final int[][] prv, final WeightedEdge[][]\
    \ prvEdge) {\n\t\tif(dist[e.source][e.target] > e.cost) {\n\t\t\tdist[e.source][e.target]\
    \ = e.cost;\n\t\t\tif(prv != null) prv[e.source][e.target] = e.source;\n\t\t\t\
    if(prvEdge != null) prvEdge[e.source][e.target] = e;\n\t\t}\n\t}\n}"
  dependsOn:
  - library/FastIO.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/WarshallFloyd.java
  requiredBy: []
  timestamp: '2023-03-24 01:16:35+09:00'
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
