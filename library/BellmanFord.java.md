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
    path: library/BellmanFord_reversed_test.java
    title: library/BellmanFord_reversed_test.java
  - icon: ':heavy_check_mark:'
    path: library/BellmanFord_test.java
    title: library/BellmanFord_test.java
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
    \n\nfinal class BellmanFord {\n\t// O(VE)\n\tpublic static final <Graph extends\
    \ AbstractGraph<? extends WeightedNode, WeightedEdge>> long[] dist(final Graph\
    \ g, final int start) { return dist(g, start, null, null); }\n\tpublic static\
    \ final <Graph extends AbstractGraph<? extends WeightedNode, WeightedEdge>> long[]\
    \ dist(final Graph g, final int start, final int[] prv) { return dist(g, start,\
    \ prv, null); }\n\tpublic static final <Graph extends AbstractGraph<? extends\
    \ WeightedNode, WeightedEdge>> long[] dist(final Graph g, final int start, final\
    \ int[] prv, final WeightedEdge[] prvEdge) { return dist(g.numNode, g.edges(),\
    \ start, prv, prvEdge); }\n\tpublic static final long[] dist(final int numNode,\
    \ final WeightedNode edges, final int start) { return dist(numNode, edges, start,\
    \ null, null); }\n\tpublic static final long[] dist(final int numNode, final WeightedNode\
    \ edges, final int start, final int[] prv) { return dist(numNode, edges, start,\
    \ prv, null); }\n\tpublic static final long[] dist(final int numNode, final WeightedNode\
    \ edges, final int start, final int[] prv, final WeightedEdge[] prvEdge) {\n\t\
    \tFastIO.rangeCheck(start, numNode);\n\t\tlong dist[] = new long[numNode];\n\t\
    \tif(prv != null) Arrays.fill(prv, -1);\n\n\t\tArrays.fill(dist, FastIO.INF);\n\
    \t\tdist[start] = 0;\n\t\tfor(int i = 0; i < numNode - 1; i ++) {\n\t\t\tfor(WeightedEdge\
    \ e : edges) {\n\t\t\t\tlong updated = dist[e.source] + e.cost;\n\t\t\t\tif(!FastIO.isPlusINF(dist[e.source])\
    \ && dist[e.target] > updated) {\n\t\t\t\t\tdist[e.target] = updated;\n\t\t\t\t\
    \tif(prv != null) prv[e.target] = e.source;\n\t\t\t\t\tif(prvEdge != null) prvEdge[e.target]\
    \ = e;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tfor(int i = 0; i < numNode; i ++) {\n\t\
    \t\tfor(WeightedEdge e : edges) {\n\t\t\t\tif(!FastIO.isPlusINF(dist[e.source])\
    \ && dist[e.target] > dist[e.source] + e.cost) {\n\t\t\t\t\tdist[e.target] = -\
    \ FastIO.INF;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn dist;\n\t}\n}"
  dependsOn:
  - library/FastIO.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/BellmanFord.java
  requiredBy: []
  timestamp: '2023-03-24 01:16:35+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/BellmanFord_test.java
  - library/BellmanFord_reversed_test.java
documentation_of: library/BellmanFord.java
layout: document
redirect_from:
- /library/library/BellmanFord.java
- /library/library/BellmanFord.java.html
title: library/BellmanFord.java
---
